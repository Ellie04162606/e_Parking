package com.oocl.eParking.service.impl;

import com.oocl.eParking.entity.User;
import com.oocl.eParking.enums.UserEnum;
import com.oocl.eParking.exception.UserException;
import com.oocl.eParking.repository.UserRepository;
import com.oocl.eParking.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUserInfo(int userId) {
    User user = userRepository.findById(userId);
    if (user != null) {
      return user;
    } else {
      throw new UserException(UserEnum.USER_NOT_FOUND);
    }
  }
}
