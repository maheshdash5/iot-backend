package com.iot.raspberrypi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.iot.raspberrypi.dto.DeviceDto;
import com.iot.raspberrypi.entity.Device;
import com.iot.raspberrypi.exception.ResourceNotFoundException;
import com.iot.raspberrypi.mapper.DeviceMapper;
import com.iot.raspberrypi.repository.DeviceRepository;
import com.iot.raspberrypi.service.DeviceService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService{

    private DeviceRepository deviceRepository;

    @Override
    public DeviceDto createDevice(DeviceDto deviceDto) {

        Device device = DeviceMapper.mapToDevice(deviceDto);
        Device savedDevice = deviceRepository.save(device);
        return DeviceMapper.mapToDeviceDto(savedDevice);
        
    }

    @Override
    public DeviceDto getDeviceById(Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
            .orElseThrow( () -> new ResourceNotFoundException("Device does not exist with given Id : " + deviceId));
        return DeviceMapper.mapToDeviceDto(device);
    }

    @Override
    public List<DeviceDto> getAllDevices() {
        List <Device> devices = deviceRepository.findAll();
        return devices.stream().map((device) -> DeviceMapper.mapToDeviceDto(device))
                     .collect(Collectors.toList());
    }

    @Override
    public DeviceDto updateDevice(Long deviceId, DeviceDto updatedDevice) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(
            () -> new ResourceNotFoundException("Device does not exist with given Id : " + deviceId));
        device.setName(updatedDevice.getName());
        device.setPower(updatedDevice.getPower());
        device.setUsage(updatedDevice.getUsage());
        device.setStatus(updatedDevice.getStatus());
        Device updatedDeviceObj = deviceRepository.save(device);

        return DeviceMapper.mapToDeviceDto(updatedDeviceObj);
    }

    @Override
    public void deleteDevice(Long deviceId) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(
            () -> new ResourceNotFoundException("Device does not exist with given Id : " + deviceId));
        System.out.println(device);
        deviceRepository.deleteById(deviceId);
        }
    
}
