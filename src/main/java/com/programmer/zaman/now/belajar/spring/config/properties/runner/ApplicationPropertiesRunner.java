package com.programmer.zaman.now.belajar.spring.config.properties.runner;

import com.programmer.zaman.now.belajar.spring.config.properties.properties.ApplicationProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ApplicationPropertiesRunner implements ApplicationRunner {
    private ApplicationProperties properties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(properties.getName());
        System.out.println(String.valueOf(properties.getVersion()));
        System.out.println(properties.isProductionMode());
    }
}
