/**
 * @Description : jwt response
 * @ClassName : JwtResponse.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/26, frankchang
 *   1) First Release.
 */

package com.example.springboot.api.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 6427947402855066613L;
	
	private String token;
	
	private String returnMsg;
	
}
