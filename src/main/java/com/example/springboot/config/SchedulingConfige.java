/**
 * @Description : Schedule config
 * @ClassName : SchedulingConfige.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/03/31, frankchang
 *   1) First Release.
 */

package com.example.springboot.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import com.example.springboot.scheduler.CountPorpoerites;
import com.example.springboot.vo.TaskCycleConfig;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class SchedulingConfige implements SchedulingConfigurer{
	
	@Autowired
	private CountPorpoerites countPorpoerites;
	
    // 移除 @Scheduled 標記
    public void notifyLoginUser() {
        // 其餘略過
    }
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
        Runnable runnable = this::notifyLoginUser;
        
        log.info("setting config");
        
        TaskCycleConfig config = new TaskCycleConfig();
        config.setDelay(0);
        
        Trigger trigger = triggerContext -> {
        	
            if (config.getDelay() != null) {
                PeriodicTrigger t = new PeriodicTrigger(countPorpoerites.getCount(), TimeUnit.MILLISECONDS);
                log.info("delay : {}", countPorpoerites.getCount());
                t.setFixedRate(false);
                int count = countPorpoerites.getCount() + 1000;
                countPorpoerites.setCount(count);
                return t.nextExecutionTime(triggerContext);
                
            } else if (config.getRate() != null) {
            	PeriodicTrigger t = new PeriodicTrigger(config.getRate(), TimeUnit.MILLISECONDS);
            	log.info("rate : {}", config.getRate());
                t.setFixedRate(true);
                return t.nextExecutionTime(triggerContext);
                
            } else if (config.getCron() != null) {
                return new CronTrigger(config.getCron()).nextExecutionTime(triggerContext);
                
            } else {
                throw new RuntimeException("Please define at least one schedule parameter.");
            }
        };
        
        taskRegistrar.addTriggerTask(runnable, trigger);

	}

}
