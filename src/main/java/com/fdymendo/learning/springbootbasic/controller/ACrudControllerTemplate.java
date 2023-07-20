package com.fdymendo.learning.springbootbasic.controller;

import org.springframework.http.ResponseEntity;
import com.fdymendo.learning.springbootbasic.handlers.ApplicationException;
import com.fdymendo.learning.springbootbasic.model.ResponseDefault;

/**
 *  Crud type interface
 * @param <S> Generic parameter
 * @param <I> Generic parameter
 *
 * ACrudControllerTemplate constructor that needs S service to create the object
 */
public abstract class ACrudControllerTemplate<S, I> {

  protected S service;

  protected ACrudControllerTemplate(S service) {
    this.service = service;
  }

  protected abstract ResponseEntity<ResponseDefault> save(I animalDTO);

  protected abstract ResponseEntity<ResponseDefault> deleteById(int id);

  protected abstract ResponseEntity<ResponseDefault> findAll();

  protected abstract ResponseEntity<ResponseDefault> findById(int id);

  protected abstract ResponseEntity<ResponseDefault> update(I animalDTO, int id) throws ApplicationException;

}
