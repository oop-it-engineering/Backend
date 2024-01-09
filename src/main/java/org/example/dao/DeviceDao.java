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
    //장비 조회
    public List<Device> getDevice(Connection conn, String dCategory) {
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
