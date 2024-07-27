package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.User;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
