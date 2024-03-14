package com.reactive.webflux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Users {

  @Id
  private int userId;
  private String firstName;
  private String lastName;
  private String userEmail;
  private long userMobileNo;

}
