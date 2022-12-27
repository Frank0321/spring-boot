/**
 * @Description : session 相關測試 res
 * @ClassName : SessionResponse.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/27, frankchang
 *   1) First Release.
 */

package com.example.springboot.api.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import net.bytebuddy.asm.Advice.Return;

@Data
@JsonInclude(Include.NON_NULL)
public class SessionResponse implements Serializable {
	
	private static final long serialVersionUID = -4484688050178165852L;
	
	private String returnMsg;
	
	private Integer empId;
	
	private String name;
	
	private String phone;

}
