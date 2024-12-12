package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class IPLTeamRestControllerAdvice {
	
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public  ResponseEntity<String>  handleIAE(IllegalArgumentException  iae){
		log.info("from  the  handleAE(-) method");
		 return new  ResponseEntity<String>(iae.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<String>  handleAllExceptions(Exception  e){
		log.info("from  the  handleAllExceptions(-) method");
		 return new  ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
