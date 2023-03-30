package com.highfive.tuto.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "application",ignoreUnknownFields = false)
@Getter
@Setter

public class ApplicationProperties {
    private String hello;

}
    