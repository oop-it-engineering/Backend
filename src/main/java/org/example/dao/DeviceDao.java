package org.example.dao;

import org.example.entity.Device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.jdbctemplate.JdbcTemplate.close;

public class DeviceDao {
    //장비 조회 -> 1개
    public Device getDevice(Connection conn, int deviceId) {
        String sql = "SELECT D_NAME, D_VERSION, D_CPU, D_RAM, D_CNT FROM DEVICE WHERE DEVICE_ID = ?";
        //기기 이름, 버전(os), cpu, ram, 수량
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Device device = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, deviceId);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                device = new Device();
                device.setdName(rset.getString("D_NAME"));
                device.setdVersion(rset.getString("D_VERSION"));
                device.setdCpu(rset.getString("D_CPU"));
                device.setdRam(rset.getString("D_RAM"));
                device.setdCount(rset.getInt("D_CNT"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return device;

    }

    //장비 조회 -> 리스트
    public List<Device> getDeviceList(Connection conn, String dCategory) {
        String sql = "SELECT D_NAME, D_VERSION FROM DEVICE WHERE D_CATEGORY = ?";
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Device> devices = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dCategory);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Device device = new Device();
                device.setdName(rset.getString("D_NAME"));
                device.setdVersion(rset.getString("D_VERSION"));

                devices.add(device);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;

    }





}
