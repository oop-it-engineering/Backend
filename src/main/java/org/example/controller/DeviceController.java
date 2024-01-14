package org.example.controller;

import org.example.entity.Device;
import org.example.service.DeviceService;

import java.util.List;

public class DeviceController {
    private DeviceService deviceService = new DeviceService();

    //장비 조회 -> 1개
    public Device getDevice(int deviceId) {
        Device device = deviceService.getDevice(deviceId);
        return device;
    }
    //장비 조회 -> 리스트
    public List<Device> getDeviceList(String dCategory) {
        List<Device> devices = deviceService.getDeviceList(dCategory);
        return devices;
    }

}
