package com.oocl.eParking.repository;

import com.oocl.eParking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
  User findById(int userId);
}
