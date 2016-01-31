package com.questwork.assignment;

/**
 * Created by Administrator on 2016/1/26.
 */
public class Asset {
    public static final String TAG = "Asset";
    private String fullPath;
    private long timestamp;

    public Asset(String fullPath, long timestamp) {
        this.fullPath = fullPath;
        this.timestamp = timestamp;
    }

    public String getFullPath() {return fullPath;}

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
