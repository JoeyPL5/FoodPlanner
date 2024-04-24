package com.foodplanner.project.Model.API;

import java.util.List;

import com.foodplanner.project.Model.Recipe;

public class RecipesResponse {
    private List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
