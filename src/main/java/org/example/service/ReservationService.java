package org.example.service;

import org.example.dao.DeviceDao;
import org.example.dao.ReservationDao;
import org.example.jdbctemplate.JdbcTemplate;

import java.sql.Connection;

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

}


