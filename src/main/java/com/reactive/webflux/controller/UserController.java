package com.reactive.webflux.controller;

import com.reactive.webflux.dto.UserDto;
import com.reactive.webflux.entity.Users;
import com.reactive.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/")
  Mono<Users> createUser(@RequestBody Mono<UserDto> userDtoMono) {
    return userService.createUser(userDtoMono);
  }

  @GetMapping("/{userId}")
  Mono<Users> getUser(@PathVariable int userId) {
    return userService.getUser(userId);
  }

  @PutMapping("/{userId}")
  Mono<Users> updateUser(@PathVariable int userId, @RequestBody Mono<UserDto> userDto) {
    return userService.updateUser(userId, userDto);
  }

  @DeleteMapping("/{userId}")
  Mono<Void> deleteUser(@PathVariable int userId) {
    return userService.deleteUser(userId);
  }

  @GetMapping("/")
  Flux<Users> getAllUsers() {
    return userService.getUserList();
  }

}
