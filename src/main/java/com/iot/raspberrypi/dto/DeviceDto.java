package com.iot.raspberrypi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {

    private Long id;
    private String name;
    private String power;
    private String usage;
    private String status;
    
}
