package com.zhangtao.sc;

import com.zhangtao.sc.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyConfig.class)
public class StartConfig {
    public static void main(String[] args) {
        SpringApplication.run(StartConfig.class);
    }
}
