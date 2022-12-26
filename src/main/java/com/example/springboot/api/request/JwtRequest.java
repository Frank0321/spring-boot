/**
 * @Description : jwt request
 * @ClassName : JwtRequest.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/26, frankchang
 *   1) First Release.
 */

package com.example.springboot.api.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class JwtRequest implements Serializable{

	private static final long serialVersionUID = 1006099575454603869L;

	private String name;
	
	private String pwd;
	
	private String token;
}
