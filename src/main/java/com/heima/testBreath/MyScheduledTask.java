package com.heima.testBreath;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
    @EnableScheduling
    @Slf4j
    public class MyScheduledTask {

        @Scheduled(fixedRate = 60000)
        public void outputMessage() {
            log.info("heart beat．．．．．．．．．．．．．{}．．．．．．．．．．．．．．．．．．．．．．．", new Date());
        }

    }