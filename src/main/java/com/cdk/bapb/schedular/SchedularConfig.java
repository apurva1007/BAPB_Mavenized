package com.cdk.bapb.schedular;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedularConfig {

    @Bean
    public CheckBidPeriod checkBidPeriod() {
        return new CheckBidPeriod();
    }
}
