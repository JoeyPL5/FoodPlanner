package com.foodplanner.project.Model.Database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodplanner.project.Model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // Stub
}