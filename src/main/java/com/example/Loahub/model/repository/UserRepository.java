package com.example.Loahub.model.repository;

import com.example.Loahub.model.entity.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTest, Long> {
}
