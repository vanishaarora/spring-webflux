package com.reactive.webflux.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

  private int userId;
  private String firstName;
  private String lastName;
  private String userEmail;
  private long userMobileNo;

}
