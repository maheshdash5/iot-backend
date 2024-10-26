package com.iot.raspberrypi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iot.raspberrypi.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long>{
    
}
