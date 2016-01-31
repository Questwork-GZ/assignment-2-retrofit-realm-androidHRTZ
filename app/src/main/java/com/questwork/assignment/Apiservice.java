package com.questwork.assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/1/26.
 */
public interface Apiservice {
    @GET("/questcms/floorplan")
    Call<List<FloorPlan>> ReadFloorPlans();
}
