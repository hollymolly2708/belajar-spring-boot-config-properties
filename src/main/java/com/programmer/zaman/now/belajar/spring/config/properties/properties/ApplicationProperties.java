package com.programmer.zaman.now.belajar.spring.config.properties.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
public class ApplicationProperties {
    private String name;
    private Integer version;
    private boolean productionMode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public boolean isProductionMode() {
        return productionMode;
    }

    public void setProductionMode(boolean productionMode) {
        this.productionMode = productionMode;
    }
}
