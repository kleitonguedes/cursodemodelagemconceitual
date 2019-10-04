package com.kleitonguedes.cursodemodelagemconceitual.resouces.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kleitonguedes.cursodemodelagemconceitual.services.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ManipuladorExcecaoResource {

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objectNotFound(ObjetoNaoEncontradoException e, HttpServletRequest request) {
		
		ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
}
