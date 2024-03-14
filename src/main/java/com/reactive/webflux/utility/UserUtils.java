package com.reactive.webflux.utility;

import com.reactive.webflux.dto.UserDto;
import com.reactive.webflux.entity.Users;

public class UserUtils {

  public static Users toUser(UserDto userDto) {
    return new Users(userDto.getUserId(), userDto.getFirstName(), userDto.getLastName(),
        userDto.getUserEmail(), userDto.getUserMobileNo());
  }


}
