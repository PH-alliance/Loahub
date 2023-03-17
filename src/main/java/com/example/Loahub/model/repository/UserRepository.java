package com.example.Loahub.model.repository;

import com.example.Loahub.model.entity.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserTest, Long> {
    public List<UserTest> findByCharacterName(String characterName);

}
