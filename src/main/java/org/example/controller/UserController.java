package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;

public class UserController {
    private UserService userService = new UserService();


    //회원가입
    //user객체에 담을 정보 입력후 user객체에 저장하는 과정은 menu에서 구현
    public void userJoin(User user) {
        int result = userService.userJoin(user);
        if (result > 0) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }

    }

    //로그인 -> 정보 입력 받고 result따라서 결과 출력
    //로그인 입력 받고 처리하는 부분은 menu에서 구현할 예정
    public void userLogin(String userId) {
        int result = userService.userLogin(userId);
        User user = userService.getUser(userId);
        if(result == 1) {
            System.out.println("로그인 성공");
        }
        else if(result == 0) {
            System.out.println("비밀번호 오류");
        }
        else if(result == -1)
            System.out.println("아이디 오류");
        else{
            System.out.println("DB오류");
        }
    }

    public User getUser(String userId) {
        User user = userService.getUser(userId);
        return user;

    }
}
