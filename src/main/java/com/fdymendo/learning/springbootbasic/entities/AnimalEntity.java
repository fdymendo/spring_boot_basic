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


/**
 * @table Is an annotation that indicates the JPA in which table needs to map an entity.
 * So JPA will know on which table of the date base will interact
 */

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


  /**
   * The method Date() returns  a String that represent the current date and time
   */

  public void init() {
    this.creationDate = new Date();
    this.lastUpdate = new Date();
  }

}
