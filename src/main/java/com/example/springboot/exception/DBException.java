/**
 * @Description : Exception Controller
 * @ClassName : DBException.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/01/25, frankchang
 *   1) First Release.
 */

package com.example.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DBException extends Exception{

	private static final long serialVersionUID = 6665878557148623098L;
	
	private String message;
	
}
