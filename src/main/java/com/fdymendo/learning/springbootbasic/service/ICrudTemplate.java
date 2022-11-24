package com.fdymendo.learning.springbootbasic.service;

import org.springframework.http.ResponseEntity;
import com.fdymendo.learning.springbootbasic.handlers.ApplicationException;
import com.fdymendo.learning.springbootbasic.model.ResponseDefault;


/**
 *  An interface that extends from JpaRepository and has saveItem , updateItem, deleteItem, getItem
 *  and getAllItems functions.
 */

public interface ICrudTemplate<T> {

  ResponseEntity<ResponseDefault> saveItem(T item);

  ResponseEntity<ResponseDefault> updateItem(T item, int id) throws ApplicationException;

  ResponseEntity<ResponseDefault> deleteItem(int id);

  ResponseEntity<ResponseDefault> getItem(int id);

  ResponseEntity<ResponseDefault> getAllItems();

}
