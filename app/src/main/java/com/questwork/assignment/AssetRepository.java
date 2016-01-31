package com.questwork.assignment;

import io.realm.RealmObject;

/**
 * Created by Administrator on 2016/1/31.
 */
public class AssetRepository extends RealmObject {
    private String fullPath;
    private long timestamp;

    public AssetRepository(String fullPath, long timestamp) {
        this.fullPath = fullPath;
        this.timestamp = timestamp;
    }

    public AssetRepository() {
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
