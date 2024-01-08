package org.example.service;

import org.example.dao.DeviceDao;
import org.example.dao.ReservationDao;
import org.example.entity.Reservation;
import org.example.jdbctemplate.JdbcTemplate;

import java.sql.Connection;
import java.util.List;

import static org.example.jdbctemplate.JdbcTemplate.*;

public class ReservationService {
    private ReservationDao reservationDao = new ReservationDao();
    //장비 예약
    public int reservation(int deviceId, String userId) {
        int result = -10;
        Connection conn = JdbcTemplate.getConnection();
        result = reservationDao.reservation(conn,deviceId, userId);
        if (result >0) {
            commit(conn);

        }else{
            rollback(conn);

        }
        close(conn);

        return result;
    }
    //수령 대기중인 장비 목록 조회
    public List<Reservation> getRes(String userId){
        Connection conn = JdbcTemplate.getConnection();

        List<Reservation> res = reservationDao.getRes(conn, userId);

        close(conn);

        return res;
    }

    //대여중인 장비 목록 조회

}


