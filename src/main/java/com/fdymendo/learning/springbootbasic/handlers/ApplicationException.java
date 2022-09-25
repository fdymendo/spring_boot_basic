package com.fdymendo.learning.springbootbasic.handlers;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

public class ApplicationException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Getter
  @Setter
  private HttpStatus httpStatus;

  public ApplicationException(Exception e, String message, HttpStatus httpStatus) {
    super(message, e);
    this.httpStatus = httpStatus;
  }

}
