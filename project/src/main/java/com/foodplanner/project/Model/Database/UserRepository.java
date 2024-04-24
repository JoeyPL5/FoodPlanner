package com.foodplanner.project.Database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodplanner.project.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Stub
}
