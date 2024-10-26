package com.iot.raspberrypi.service;

import java.util.List;

import com.iot.raspberrypi.dto.DeviceDto;


public interface DeviceService {
    
    DeviceDto createDevice(DeviceDto deviceDto);

    DeviceDto getDeviceById(Long deviceId);

    List<DeviceDto> getAllDevices();

    DeviceDto updateDevice(Long deviceId, DeviceDto updatedDevice);

    void deleteDevice(Long deviceId);
}
