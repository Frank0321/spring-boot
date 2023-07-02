/**
 * @Description : 排程範例程式
 * @ClassName : ScheduleTasks.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/06, frankchang
 *   1) First Release.
 *   2) 2022/12/09 新增 @ConditionalOnProperty 控制 component 是否被啟用
 */

package com.example.springboot.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@ConditionalOnProperty(value = "spring.scedule.enable", havingValue = "Y")
public class ScheduleTasks {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(initialDelay = 6000, fixedRate = 12000)
	public void showFixedDelay() {
		log.info("show fixedDelay, time :{}", DATE_FORMAT.format(new Date()));
	}
	
	@Scheduled(cron = "0/30 * * * * *")
	public void showCronTime() {
		log.info("show cron time :{}", DATE_FORMAT.format(new Date()));
	}

}
