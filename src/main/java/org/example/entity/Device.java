package org.example.entity;
import java.sql.Timestamp;

public class Device {
    //기기 이름, 버전(os), cpu, ram, 수량
    private int deviceId;
    private String dName;   //장비 이름
    private int dCategory;   // 장비 카테고리(노트북,모바일기기)
    private String dVersion;    //os 버전
    private String dCpu; //device cpu
    private String dRam;//device ram
    private int dCount; // device 개수


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

    public String getdCpu() {
        return dCpu;
    }

    public void setdCpu(String dCpu) {
        this.dCpu = dCpu;
    }

    public String getdRam() {
        return dRam;
    }

    public void setdRam(String dRam) {
        this.dRam = dRam;
    }

    public int getdCount() {
        return dCount;
    }

    public void setdCount(int dCount) {
        this.dCount = dCount;
    }
}

