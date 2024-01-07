package org.example.service;

import org.example.dao.DeviceDao;
import org.example.entity.Device;
import org.example.jdbctemplate.JdbcTemplate;

import java.sql.Connection;

public class DeviceService {
    private DeviceDao deviceDao = new DeviceDao();

    //장비 조회
    public Device getDevice(int dCategory) {
        Connection conn = JdbcTemplate.getConnection();
        Device device = deviceDao.getDevice(conn, dCategory);
        return device;
    }
}