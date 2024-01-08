package org.example.entity;
import java.sql.Timestamp;

public class User {
    private String userId;
    private String userName;


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




}
