/**
 * @Description : TaskCycle 參數
 * @ClassName : TaskCycleConfig.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/03/31, frankchang
 *   1) First Release.
 */

package com.example.springboot.vo;

import lombok.Data;

@Data
public class TaskCycleConfig {

    private Integer delay;
    
    private Integer rate;
    
    private String cron;
    
}
