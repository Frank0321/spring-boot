/**
 * @Description : 課本 req
 * @ClassName : BookReqBody.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/06, frankchang
 *   1) First Release.
 */

package com.example.springboot.api.request;

import lombok.Data;

@Data
public class BookReqBody {

	private String name;
	
	private String author;
	
	private Integer page;
}
