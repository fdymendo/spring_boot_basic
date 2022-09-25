package com.fdymendo.learning.springbootbasic.service;

import org.springframework.http.ResponseEntity;
import com.fdymendo.learning.springbootbasic.handlers.ApplicationException;
import com.fdymendo.learning.springbootbasic.model.ResponseDefault;

public interface ICrudTemplate<T> {

  ResponseEntity<ResponseDefault> saveItem(T item);

  ResponseEntity<ResponseDefault> updateItem(T item, int id) throws ApplicationException;

  ResponseEntity<ResponseDefault> deleteItem(int id);

  ResponseEntity<ResponseDefault> getItem(int id);

  ResponseEntity<ResponseDefault> getAllItems();

}
