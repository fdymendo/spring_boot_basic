package com.fdymendo.learning.springbootbasic.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class AnimalDTO {

  private Integer id;
  private String name;
  private Date creationDate;
  private Date lastUpdate;

  public void cleanRequest() {
    this.id = null;
    this.creationDate = null;
    this.lastUpdate = null;
  }
}
