package com.iot.raspberrypi.mapper;

import com.iot.raspberrypi.dto.DeviceDto;
import com.iot.raspberrypi.entity.Device;

public class DeviceMapper {

    public static DeviceDto mapToDeviceDto(Device devices){

        return new DeviceDto(
            devices.getId(),
            devices.getName(),
            devices.getPower(),
            devices.getUsage(),
            devices.getStatus()
        );    
    }
    public static Device mapToDevice (DeviceDto deviceDto){
        return new Device(
            deviceDto.getId(),
            deviceDto.getName(),
            deviceDto.getPower(),
            deviceDto.getUsage(),
            deviceDto.getStatus()

        );
    }
    
}
