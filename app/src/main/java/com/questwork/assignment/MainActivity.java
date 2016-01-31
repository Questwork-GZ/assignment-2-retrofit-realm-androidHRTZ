package com.questwork.assignment;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private  List<FloorPlan> floorPlanList;
    private List<FloorPlanRepository> floorPlanRepositoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floorPlanList=new ArrayList<>();
        floorPlanRepositoryList=new ArrayList<>();
        switchFloorPlanToRepository(floorPlanList);
        saveToFloorPlanRealmObject(floorPlanRepositoryList);
        ShowData();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.3:8028")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiservice service = retrofit.create(Apiservice.class);

        Call<List<FloorPlan>> floorPlans = service.ReadFloorPlans();
        floorPlans.enqueue(new Callback<List<FloorPlan>>() {

            @Override
            public void onResponse(Response<List<FloorPlan>> response) {
                for (int i=0;i<response.body().size();i++){
                    Log.e(TAG, "response:" + response.body().get(i).getName());
                    FloorPlan floorPlan=new FloorPlan();
                    floorPlan.setId(response.body().get(i).getId());
                    floorPlan.setName(response.body().get(i).getName());
                    floorPlan.setAsset(new Asset(response.body().get(i).getAsset().getFullPath(),response.body().get(i).getAsset().getTimestamp()));
                    floorPlan.setParentId(response.body().get(i).getParentId());
                    floorPlanList.add(floorPlan);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG,"failure:");
            }
        });
    }


    public void switchFloorPlanToRepository(List<FloorPlan> floorPlans){
        for (int i=0;i<floorPlans.size();i++) {
            FloorPlanRepository floorPlanRepository=new FloorPlanRepository();
            AssetRepository assetRepository=new AssetRepository();
            assetRepository.setFullPath(floorPlans.get(i).getAsset().getFullPath());
            floorPlanRepository.setId(floorPlans.get(i).getId());
            floorPlanRepository.setName(floorPlans.get(i).getName());
            floorPlanRepository.setAsset(new AssetRepository(floorPlans.get(i).getAsset().getFullPath(), floorPlans.get(i).getAsset().getTimestamp()));
            floorPlanRepository.setParentId(floorPlans.get(i).getParentId());
            floorPlanRepositoryList.add(floorPlanRepository);
        }
    }

    public void saveToFloorPlanRealmObject(List<FloorPlanRepository> list){
        for (int i=0;i<list.size();i++) {
            Realm realm=Realm.getInstance(this);
            realm.beginTransaction();
            realm.copyToRealm(list.get(i));
            realm.commitTransaction();
        }
    }

    public void ShowData(){
        Realm realm=Realm.getInstance(this);
        RealmResults<FloorPlanRepository> fpData=realm.where(FloorPlanRepository.class).findAll();
        Toast.makeText(this,fpData+"",Toast.LENGTH_LONG).show();
    }

}
