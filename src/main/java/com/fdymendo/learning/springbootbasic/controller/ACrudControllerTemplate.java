package com.fdymendo.learning.springbootbasic.controller;

import org.springframework.http.ResponseEntity;
import com.fdymendo.learning.springbootbasic.handlers.ApplicationException;
import com.fdymendo.learning.springbootbasic.model.ResponseDefault;

public abstract class ACrudControllerTemplate<S, I> {

  protected S service;

  public ACrudControllerTemplate(S service) {
    this.service = service;
  }

  protected abstract ResponseEntity<ResponseDefault> save(I animalDTO);

  protected abstract ResponseEntity<ResponseDefault> deleteById(int id);

  protected abstract ResponseEntity<ResponseDefault> findAll();

  protected abstract ResponseEntity<ResponseDefault> findById(int id);

  protected abstract ResponseEntity<ResponseDefault> update(I animalDTO, int id) throws ApplicationException;

}
