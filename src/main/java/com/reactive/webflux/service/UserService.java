package com.reactive.webflux.service;


import com.reactive.webflux.dto.UserDto;
import com.reactive.webflux.entity.Users;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<Users> createUser(Mono<UserDto> userDtoMono);

  Mono<Users> getUser(int userId);

  Mono<Users> updateUser(int userId, Mono<UserDto> userDtoMono);

  Mono<Void> deleteUser(int userId);

  Flux<Users> getUserList();


}
