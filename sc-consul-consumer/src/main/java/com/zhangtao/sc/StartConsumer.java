package com.zhangtao.sc;

import com.zhangtao.sc.config.BalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 启动消费者
 */
@SpringBootApplication
@RibbonClient(name="providerName",configuration = {BalanceConfig.class})
public class StartConsumer {
    public static void main(String[] args) {
        SpringApplication.run(StartConsumer.class);
    }
}
