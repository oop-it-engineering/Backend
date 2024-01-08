package org.example.dao;

import java.sql.*;
import java.util.Date;


import static org.example.jdbctemplate.JdbcTemplate.close;

public class ReservationDao {
    //장비 예약
    public int reservation(Connection conn, int deviceId, String userId) {

        PreparedStatement pstmt = null;
        int result = 0;
        try {
            // 예약 정보를 Reservation 테이블에 추가
            String insertResSql = "INSERT INTO RESERVATION (USER_ID, DEVICE_ID, D_RES, D_RES_CONF, D_STATUS, RESTIME) VALUES (?,?,1,0,1,?)";
            pstmt = conn.prepareStatement(insertResSql);
            pstmt.setString(1, userId);
            pstmt.setInt(2,deviceId);
            pstmt.setTimestamp(3,new Timestamp(new Date().getTime()));
            pstmt.executeUpdate();

            // Device 테이블에서 장비 수(d_cnt)를 업데이트하고 잔여 장비 수 체크
            String updateDeviceSql = "UPDATE DEVICE d " +
                    "INNER JOIN RESERVATION r ON d.DEVICE_ID = r.DEVICE_ID " +
                    "SET d.D_NT = d.D_CNT - 1 " +
                    "WHERE d.DEVICE_ID = ? AND d.D_CNT > 0";
            pstmt = conn.prepareStatement(updateDeviceSql);
            pstmt.setInt(1, deviceId);

            result = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(pstmt);
        }
        return result;
    }

}
