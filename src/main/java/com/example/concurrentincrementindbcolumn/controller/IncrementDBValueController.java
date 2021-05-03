package com.example.concurrentincrementindbcolumn.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.concurrentincrementindbcolumn.service.IncrementDBValueService;

@RestController
public class IncrementDBValueController {

	private final AtomicInteger globalDBValueToIncrement = new AtomicInteger(0);
	
	@Autowired
	private IncrementDBValueService incrementDBValueService; 

//	@PostMapping("/incrementDBValue")
//    public void incrementDBValue() {
//    	
////    	incrementDBValueService.incrementDBValue();
//		
//		globalDBValueToIncrement++;
//    }
//
//	@GetMapping("/getDBValue")
//    public long getDBValue() {
//    	
//    	return globalDBValueToIncrement;
//    }
	
    
	@GetMapping("/getDBValue")
    public int getValue() {
        return globalDBValueToIncrement.get();
    }
	
	@PostMapping("/incrementDBValue")
    public void increment() {
        while(true) {
            int existingValue = getValue();
            int newValue = existingValue + 1;
            if(globalDBValueToIncrement.compareAndSet(existingValue, newValue)) {
            			            	
            	// schedule
            	ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
            	
            	scheduledExecutor.schedule(
            			() -> incrementDBValueService.updateDBValue(getValue())
            			, 10
            			, TimeUnit.SECONDS
            			);
            	
				
                return;
            }
        }
        
        
    }
}
