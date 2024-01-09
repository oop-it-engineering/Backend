package org.example.controller;

import org.example.entity.Device;
import org.example.service.DeviceService;

import java.util.List;

public class DeviceController {
    private DeviceService deviceService = new DeviceService();
    
    //장비 조회
    public List<Device> getDevice(String dCategory) {
        List<Device> devices = deviceService.getDevice(dCategory);
        return devices;
    }



}
