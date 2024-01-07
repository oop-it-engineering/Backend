package org.example.controller;

import org.example.entity.Device;
import org.example.service.DeviceService;

public class DeviceController {
    private DeviceService deviceService = new DeviceService();

    //장비 조회
    public Device getDevice(int dCategory) {
        Device device = deviceService.getDevice(dCategory);
        return device;
    }
}
