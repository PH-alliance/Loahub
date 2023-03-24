package com.example.Loahub.model.repository;

import com.example.Loahub.model.entity.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserTest, Long> {
    public Optional<UserTest> findByCharacterName(String characterName);
    public Optional<UserTest> getByCharacterName(String characterName);

}
