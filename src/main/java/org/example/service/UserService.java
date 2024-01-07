package org.example.service;

import org.example.dao.UserDao;
import org.example.entity.User;
import org.example.jdbctemplate.JdbcTemplate;

import java.sql.Connection;

import static org.example.jdbctemplate.JdbcTemplate.*;

public class UserService {
    private UserDao userDao = new UserDao();

    //회원가입
    public int userJoin(User user) {
        int result = -10;

        Connection conn = JdbcTemplate.getConnection();

        result = userDao.userJoin(conn, user);

        if(result>0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);

        return result;
    }
    //로그인
    public int userLogin(String userId) {
        int result = -10;
        Connection conn = JdbcTemplate.getConnection();
        result = userDao.userLogin(conn, userId);

        close(conn);

        return result;

    }
    //유저정보 가져오기
    public User getUser(String userId) {
        Connection conn = JdbcTemplate.getConnection();

        User user = userDao.getUser(conn, userId);

        return user;
    }


}
