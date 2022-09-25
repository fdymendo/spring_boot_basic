package com.fdymendo.learning.springbootbasic.handlers;

import java.util.NoSuchElementException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.fdymendo.learning.springbootbasic.model.ResponseDefault;
import com.fdymendo.learning.springbootbasic.model.ResponseError;
import com.fdymendo.learning.springbootbasic.utils.ApplicationConstant;
import com.fdymendo.learning.springbootbasic.utils.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseError> exceptionFound(Exception ex, WebRequest request) {
    log.error(ex.getMessage());
    return GenericMethods.responseError500(ApplicationConstant.ERROR_MESSAGE_500);
  }

  @ExceptionHandler(ApplicationException.class)
  public ResponseEntity<ResponseError> exceptionFound(ApplicationException ex, WebRequest request) {
    log.error(ex.getMessage());
    return GenericMethods.genericResponse(ex);
  }

  @ExceptionHandler({EmptyResultDataAccessException.class, NoSuchElementException.class})
  public ResponseEntity<ResponseDefault> exceptionFound(EmptyResultDataAccessException ex,
      WebRequest request) {
    log.warn(ex.getMessage());
    return GenericMethods.responseBadRequest();
  }

}
