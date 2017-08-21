package com.cdk.bapb.schedular;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Bean
    public CheckBidPeriod checkBidPeriod() {
        /*
        * Initialises Check Bid period scheduler.
        */
        return new CheckBidPeriod();
    }
}
