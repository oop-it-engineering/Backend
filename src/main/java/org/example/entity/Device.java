package org.example.entity;
import java.sql.Timestamp;

public class Device {
    private int deviceId;
    private String dName;   //장비 이름
    private String dCategory;   // 장비 카테고리(노트북,모바일기기)
    private String dVersion;    //os 버전
    private boolean dRes;   //장비 예약 유무, 1이면 대여 가능
    private boolean dResConf;   //장비 예약 확정 유무, 1이면 예약 확정 -> 대여중
    private boolean dStatus;    //장비 손상 및 분실 유무, 1이면 이용 가능한 장비

    
}

