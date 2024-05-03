package com.heima.testBreath;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

    @Component
    @EnableScheduling
    public class MyScheduledTask {

        @Scheduled(fixedRate = 5000)
        public void outputMessage() {
            System.out.println("输出消息---------------------------------");
        }

    }