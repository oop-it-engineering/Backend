package org.example.dao;

import org.example.entity.Device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.jdbctemplate.JdbcTemplate.close;

public class DeviceDao {
    //장비 조회 -> 리스트 형식으로 변경 필요할듯
    public Device getDevice(Connection conn, int dCategory) {
        String sql = "SELECT D_NAME, D_VERSION FROM DEVICE WHERE D_CATEGORY = ?";
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Device device = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dCategory);

            rset = pstmt.executeQuery();

            while (rset.next()) {
                device = new Device();
                device.setdName(rset.getString("D_NAME"));
                device.setdVersion(rset.getString("D_VERSION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);

        }
        return device;
    }




}
