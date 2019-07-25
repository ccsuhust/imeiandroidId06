package com.gtja.ydpt.imei.androidId.model;

/**
 * Created by nowcoder on 2016/6/26.
 */
public class Collect {
    private int id;
    private String imei;
    private String androidID;
    private String deviceInfo;
    private String androidSystemVersion;
    private String jhVersion;
    private String createTime;
    private String updateTime;


    public Collect() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAndroidID() {
        return androidID;
    }

    public void setAndroidID(String androidID) {
        this.androidID = androidID;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getAndroidSystemVersion() {
        return androidSystemVersion;
    }

    public void setAndroidSystemVersion(String androidSystemVersion) {
        this.androidSystemVersion = androidSystemVersion;
    }

    public String getJhVersion() {
        return jhVersion;
    }

    public void setJhVersion(String jhVersion) {
        this.jhVersion = jhVersion;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", imei='" + imei + '\'' +
                ", androidID='" + androidID + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", androidSystemVersion='" + androidSystemVersion + '\'' +
                ", jhVersion='" + jhVersion + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
