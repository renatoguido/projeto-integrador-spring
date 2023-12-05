package com.example.projetointegrador.application.exception;

import com.example.projetointegrador.application.models.ErrorDTO;
import com.example.projetointegrador.application.models.Ranking;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

  // violação de restrições de validação.
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorDTO> handleConstraintViolationException(ConstraintViolationException e){
    ErrorDTO error = new ErrorDTO(LocalDateTime.now(), 400, "Bad Request");

    return ResponseEntity.status(400).body(error);
  }

  // tratamento genérico de exceções não especificadas.
  @ExceptionHandler
  public ResponseEntity<ErrorDTO> handleRuntimeException(RuntimeException e){
    ErrorDTO error = new ErrorDTO(LocalDateTime.now(), 500, "Jogador com o nickname já criado ou o jogador não foi encontrado.");
    return  ResponseEntity.status(500).body(error);
  }

  //quando não é possível encontrar um jogador ou jogo pelo ID fornecido.
  @ExceptionHandler
  public ResponseEntity<ErrorDTO> handleEntityNotFoundException(EntityNotFoundException e){
    ErrorDTO error = new ErrorDTO(LocalDateTime.now(), 500, "Jogador ou Jogo não encontrado");
    return  ResponseEntity.status(500).body(error);
  }

  //quando um objeto nulo é utilizado sem verificação.
  @ExceptionHandler
  public ResponseEntity<ErrorDTO> handleNullPointerException(NullPointerException e){
    ErrorDTO error = new ErrorDTO(LocalDateTime.now(), 500, "Ocorreu uma NullPointerException. Verifique se todos os objetos estão sendo devidamente inicializados.");
    return  ResponseEntity.status(500).body(error);
  }

  //argumentos diferentes do metodos
  @ExceptionHandler
  public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException e){
    ErrorDTO error = new ErrorDTO(LocalDateTime.now(), 400, "Argumentos inválidos. ID ou Nickname deve ser fornecido.");
    return  ResponseEntity.status(400).body(error);
  }

  //caso ocorra falhas na comunicação com o banco de dados.
  @ExceptionHandler
  public ResponseEntity<ErrorDTO> handleDataAccessException(DataAccessException e){
    ErrorDTO error = new ErrorDTO(LocalDateTime.now(), 500, "Ocorreu um erro inesperado. Entre em contato com o suporte.");
    return  ResponseEntity.status(500).body(error);
  }



}
