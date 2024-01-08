package org.example.entity;

import java.sql.Timestamp;

public class Reservation {
    private boolean dRes;   //장비 예약 유무, 1이면 대여 가능
    private boolean dResConf;   //장비 예약 확정 유무, 1이면 예약 확정 -> 대여중
    private boolean dStatus;    //장비 손상 및 분실 유무, 0이면 이용 가능한 장비
    private Timestamp resTime;
    private Timestamp resConfTime;
    private String userId;
    private int deviceId;

    public Reservation() {}

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

    public Timestamp getResTime() {
        return resTime;
    }

    public void setResTime(Timestamp resTime) {
        this.resTime = resTime;
    }

    public Timestamp getResConfTime() {
        return resConfTime;
    }

    public void setResConfTime(Timestamp resConfTime) {
        this.resConfTime = resConfTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
}
