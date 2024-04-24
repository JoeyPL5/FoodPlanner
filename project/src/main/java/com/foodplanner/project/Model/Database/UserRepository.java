package com.foodplanner.project.Model.Database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodplanner.project.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Stub
}
