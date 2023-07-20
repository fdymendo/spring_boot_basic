package com.fdymendo.learning.springbootbasic.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * Sheet of the AnimalDTO Object creation
 */
@Data
@JsonInclude(Include.NON_NULL)
public class AnimalDTO {

  private Integer id;
  private String name;
  private Date creationDate;
  private Date lastUpdate;

  /**
   * Constructor needs three parameters to be initialized: ID, CreationDate and LastUpdate
   */
  public void cleanRequest() {
    this.id = null;
    this.creationDate = null;
    this.lastUpdate = null;
  }
}
