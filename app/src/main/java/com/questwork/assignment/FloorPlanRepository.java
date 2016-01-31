package com.questwork.assignment;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/1/31.
 */
public class FloorPlanRepository extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;
    private AssetRepository asset;
    private String parentId;

    public FloorPlanRepository(String id, String name, AssetRepository asset, String parentId) {
        this.id = id;
        this.name = name;
        this.asset = asset;
        this.parentId = parentId;
    }

    public FloorPlanRepository() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AssetRepository getAsset() {
        return asset;
    }

    public void setAsset(AssetRepository asset) {
        this.asset = asset;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
