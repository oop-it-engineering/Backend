package org.example.entity;
import java.sql.Timestamp;

public class User {
    private String userId;
    private String userName;
    private int deviceId;
    private Timestamp resTime;
    private Timestamp resConfTime;


    //생성자
    public User() {}

    //회원가입 할 때 User객체에 담아서 저장
    public User(String userId, String userName) {
        super();
        this.userId = userId;
        this.userName = userName;
    }

    //getter&setter
    //기능 만들때 User 객체에 관련된 정보를 가져올때 사용함
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
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
}
