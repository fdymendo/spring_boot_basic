package com.fdymendo.learning.springbootbasic.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "animal")
public class AnimalEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false)
  private Integer id;
  @Column(name = "name", updatable = true)
  private String name;
  @Column(name = "creation_date", updatable = false)
  private Date creationDate;
  @Column(name = "last_update", updatable = true)
  private Date lastUpdate;

  public void init() {
    this.creationDate = new Date();
    this.lastUpdate = new Date();
  }

}
