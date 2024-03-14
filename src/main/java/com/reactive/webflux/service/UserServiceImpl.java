package com.reactive.webflux.service;

import com.reactive.webflux.dto.UserDto;
import com.reactive.webflux.entity.Users;
import com.reactive.webflux.repository.UserRepository;
import com.reactive.webflux.utility.UserUtils;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public Mono<Users> createUser(Mono<UserDto> userDtoMono) {
    return userDtoMono.map(UserUtils::toUser).flatMap(userRepository::save);
  }

  @Override
  public Mono<Users> getUser(int userId) {
    return userRepository.findById(userId);
  }

  @Override
  public Mono<Users> updateUser(int userId, Mono<UserDto> userDtoMono) {
    return userRepository.findById(userId).flatMap(
            user -> userDtoMono.map(UserUtils::toUser).doOnNext(userDetails -> user.setUserId(userId)))
        .flatMap(userRepository::save);
  }

  @Override
  public Mono<Void> deleteUser(int userId) {
    return userRepository.deleteById(userId);
  }

  @Override
  public Flux<Users> getUserList() {
    return userRepository.findAll().onBackpressureBuffer(10, BufferOverflowStrategy.DROP_OLDEST)
        .delayElements(Duration.ofMillis(2000)).log();
  }
}
