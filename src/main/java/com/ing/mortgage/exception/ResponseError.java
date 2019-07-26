package com.ing.mortgage.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class ResponseError implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String statusMessage;
	private Integer statusCode;
	public ResponseError(String statusMessage,Integer statusCode) {
		this.statusMessage = statusMessage;
		this.statusCode=statusCode;
	}
}

