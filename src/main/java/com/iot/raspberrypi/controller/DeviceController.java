package com.iot.raspberrypi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iot.raspberrypi.dto.DeviceDto;
import com.iot.raspberrypi.service.DeviceService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private DeviceService deviceService;

    // Build Add Device REST API
    @PostMapping
    public ResponseEntity<DeviceDto> createDevice(@RequestBody DeviceDto deviceDto){
        DeviceDto savedDevice = deviceService.createDevice(deviceDto);
        return new ResponseEntity<>(savedDevice,HttpStatus.CREATED);
    }


    // Build Get Device REST API
    @GetMapping("{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable("id") Long deviceId){
        DeviceDto deviceDto = deviceService.getDeviceById(deviceId);
        return ResponseEntity.ok(deviceDto);

    }

    // Build Get All Devices REST API
    @GetMapping
    public ResponseEntity<List<DeviceDto>> getAllDevices(){
        List<DeviceDto> devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    // Build Update Device REST API
    @PutMapping("{id}")
    public ResponseEntity<DeviceDto> updateDevice(@PathVariable("id") Long deviceId, @RequestBody DeviceDto updatedDevice){
    DeviceDto deviceDto = deviceService.updateDevice(deviceId, updatedDevice);
    return ResponseEntity.ok(deviceDto);
    }

    // Build Delete Device REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") Long deviceId){
        deviceService.deleteDevice(deviceId);
        return ResponseEntity.ok("Device deleted successfully!.");
    }
}
