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

    public List<Device> getDevice(String dCategory) {
        Connection conn = JdbcTemplate.getConnection();

        List<Device> devices = deviceDao.getDevice(conn, dCategory);

        close(conn);

        return devices;
    }


}
