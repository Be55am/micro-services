package com.bessam.limitsservice;


import com.bessam.limitsservice.bean.LimitConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LimitsConfigurationController {

    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations(){

        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }
}
