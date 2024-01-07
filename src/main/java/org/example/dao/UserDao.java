package org.example.dao;

import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.jdbctemplate.JdbcTemplate.close;

public class UserDao {
    //회원가입
    public int userJoin(Connection conn, User user) {
        String sql = "INSERT INTO USER (USER_ID, USER_NAME) VALUES(?,?)";
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }

    //로그인
    public int userLogin(Connection conn, String userId) {
        String sql = "SELECT * FROM USER WHERE USER_ID = ? ";
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        User user = null;
        int result = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);

            rset = pstmt.executeQuery();
            if (rset.next()) {
                if (rset.getString(1).equals(userId))
                    return result = 1;
                else
                    return result = 0;
            } else {
                return result = -1;//잘못입력
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result = 2; //db오류

    }

    //user정보 불러오기
    public User getUser(Connection conn, String userId) {
        String sql = "SELECT * FROM USER WHERE USER_ID = ?";
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        User user = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);

            rset = pstmt.executeQuery();

            while (rset.next()) {
                user = new User();
                user.setUserId(rset.getString("USER_ID"));
                user.setUserName(rset.getString("USER_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);

        }
        return user;
    }
}
