package org.example.dao;

import org.example.entity.Device;
import org.example.entity.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.example.jdbctemplate.JdbcTemplate.close;

public class ReservationDao {
    //장비 예약
    public int reservation(Connection conn, int deviceId, String userId) {
        String insertResSql = "INSERT INTO RESERVATION (USER_ID, DEVICE_ID, D_RES, D_RES_CONF, D_STATUS, RESTIME) VALUES (?,?,1,0,1,?)";

        String updateDeviceSql = "UPDATE DEVICE d " +
                "INNER JOIN RESERVATION r ON d.DEVICE_ID = r.DEVICE_ID " +
                "SET d.D_NT = d.D_CNT - 1 " +
                "WHERE d.DEVICE_ID = ? AND d.D_CNT > 0";
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            // 예약 정보를 Reservation 테이블에 추가
            pstmt = conn.prepareStatement(insertResSql);
            pstmt.setString(1, userId);
            pstmt.setInt(2,deviceId);
            pstmt.setTimestamp(3,new Timestamp(new Date().getTime()));
            pstmt.executeUpdate();

            // Device 테이블에서 장비 수(d_cnt)를 업데이트하고 잔여 장비 수 체크

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

    //수령 대기중인 장비 목록 조회
    public List<Reservation> getRes(Connection conn, String userId) {
        String sql = "SELECT r.RES_TIME, d.D_NAME, d.D_VERSION" +
                    "FROM RESERVATION r" +
                    "JOIN DEVICE d ON r.DEVICE_ID = d.DEVICE_ID" +
                    "WHERE r.USER_ID = ? AND r.D_RES = 1";
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Reservation> reservations = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rset = pstmt.executeQuery();

            while (rset.next()){
                String dname = rset.getString("D_NAME");
                String dversion = rset.getString("D_VERSION");
                Timestamp resTime = rset.getTimestamp("RES_TIME");

                Device device = new Device();
                device.setdName(dname);
                device.setdVersion(dversion);

                Reservation reservation = new Reservation();
                reservation.setDevice(device);
                reservation.setResTime(resTime);

                reservations.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    //대여중인 장비 목록 조회
    public List<Reservation> getResConf(Connection conn, String userId) {
        String sql = "SELECT r.RES_TIME, d.D_NAME, d.D_VERSION" +
                "FROM RESERVATION r" +
                "JOIN DEVICE d ON r.DEVICE_ID = d.DEVICE_ID" +
                "WHERE r.USER_ID = ? AND r.D_RES_CONF = 1";
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Reservation> reservations = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rset = pstmt.executeQuery();

            while (rset.next()){
                String dname = rset.getString("D_NAME");
                String dversion = rset.getString("D_VERSION");
                Timestamp resTime = rset.getTimestamp("RES_TIME");

                Device device = new Device();
                device.setdName(dname);
                device.setdVersion(dversion);

                Reservation reservation = new Reservation();
                reservation.setDevice(device);
                reservation.setResTime(resTime);

                reservations.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

}
