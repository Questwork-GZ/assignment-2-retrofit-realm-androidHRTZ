package com.questwork.assignment;

/**
 * Created by Administrator on 2016/1/26.
 */
public class FloorPlan{
    public static final String TAG = "FloorPlan";
    private String id;
    private String name;
    private Asset asset;
    private String parentId;

    public FloorPlan(String id, String name, Asset asset, String parentId) {
        this.id = id;
        this.name = name;
        this.asset = asset;
        this.parentId = parentId;
    }

    public FloorPlan() {
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

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public String getParentId() {return parentId;}

    public void setParentId(String parentId) {this.parentId = parentId;}

}
