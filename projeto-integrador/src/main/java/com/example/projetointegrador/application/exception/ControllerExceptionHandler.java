package com.example.projetointegrador.application.exception;

import com.example.projetointegrador.application.models.ErrorDTO;
import com.example.projetointegrador.application.models.Ranking;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorDTO> handleConstraintViolationException(ConstraintViolationException e){
    ErrorDTO error = new ErrorDTO(LocalDateTime.now(), 400, "Bad Request");

    return ResponseEntity.status(400).body(error);
  }

  @ExceptionHandler
  public ResponseEntity<ErrorDTO> handleRuntimeException(RuntimeException e){
    ErrorDTO error = new ErrorDTO(LocalDateTime.now(), 500, "Jogador não encontrado");
    return  ResponseEntity.status(500).body(error);
  }

}
