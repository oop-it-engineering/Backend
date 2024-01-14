package org.example.service;

import org.example.dao.DeviceDao;
import org.example.entity.Device;
import org.example.jdbctemplate.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.example.jdbctemplate.JdbcTemplate.*;


public class DeviceService {
    private DeviceDao deviceDao = new DeviceDao();
    //장비 조회 -> 1개
    public Device getDevice(int deviceId) {
        Connection conn = JdbcTemplate.getConnection();

        Device device = deviceDao.getDevice(conn,deviceId);

        close(conn);

        return device;
    }

    //장비 조회 -> 리스트
    public List<Device> getDeviceList(String dCategory) {
        Connection conn = JdbcTemplate.getConnection();

        List<Device> devices = deviceDao.getDeviceList(conn, dCategory);

        close(conn);

        return devices;
    }

}
