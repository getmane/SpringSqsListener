package com.getmane.springsqslistener;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@ConstructorBinding
@ConfigurationProperties(prefix = "config")
public class ApplicationConfig {

    @NestedConfigurationProperty
    AWS aws;

    @Value
    public static class AWS {

        String localstackEndpoint;
        String accessKey;
        String secretKey;
        String region;
        String sqsQueueUrl;
    }
}