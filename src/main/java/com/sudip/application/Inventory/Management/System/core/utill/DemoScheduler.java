package com.sudip.application.Inventory.Management.System.core.utill;

import com.sudip.application.Inventory.Management.System.service.ProductServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DemoScheduler {
    private static final Logger log = LoggerFactory.getLogger(DemoScheduler.class);
    @Scheduled(cron="0 */5 * * * *")

    public void printMessage() {
        log.info("Running after every 5 minutes" +
                " ..." + LocalDateTime.now());

    }

}







