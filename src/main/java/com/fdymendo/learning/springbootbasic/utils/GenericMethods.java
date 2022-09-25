package com.fdymendo.learning.springbootbasic.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fdymendo.learning.springbootbasic.handlers.ApplicationException;
import com.fdymendo.learning.springbootbasic.model.ResponseDefault;
import com.fdymendo.learning.springbootbasic.model.ResponseError;

public class GenericMethods {


  public static ResponseEntity<ResponseDefault> responseOk(ResponseDefault responseDefault) {
    return ResponseEntity.ok(responseDefault);
  }

  public static ResponseEntity<ResponseDefault> responseNoContent() {
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
  }

  public static ResponseEntity<ResponseDefault> responseBadRequest() {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
  }

  public static ResponseEntity<ResponseError> responseError500(String message) {
    return ResponseEntity.internalServerError().body(new ResponseError(message));
  }

  public static ResponseEntity<ResponseError> genericResponse(
      ApplicationException applicationException) {
    return ResponseEntity.status(applicationException.getHttpStatus())
        .body(new ResponseError(applicationException.getMessage()));
  }
}
