package org.example.entity;
import java.sql.Timestamp;

public class Device {
    private int deviceId;
    private String dName;   //장비 이름
    private int dCategory;   // 장비 카테고리(노트북,모바일기기)
    private String dVersion;    //os 버전
    private boolean dRes;   //장비 예약 유무, 1이면 대여 가능
    private boolean dResConf;   //장비 예약 확정 유무, 1이면 예약 확정 -> 대여중
    private boolean dStatus;    //장비 손상 및 분실 유무, 1이면 이용 가능한 장비

    public Device() {}  //생성자


    //getter&setter

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public int getdCategory() {
        return dCategory;
    }

    public void setdCategory(int dCategory) {
        this.dCategory = dCategory;
    }

    public String getdVersion() {
        return dVersion;
    }

    public void setdVersion(String dVersion) {
        this.dVersion = dVersion;
    }

    public boolean isdRes() {
        return dRes;
    }

    public void setdRes(boolean dRes) {
        this.dRes = dRes;
    }

    public boolean isdResConf() {
        return dResConf;
    }

    public void setdResConf(boolean dResConf) {
        this.dResConf = dResConf;
    }

    public boolean isdStatus() {
        return dStatus;
    }

    public void setdStatus(boolean dStatus) {
        this.dStatus = dStatus;
    }
}

