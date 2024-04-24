package com.foodplanner.project.Database;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodplanner.project.Model.Recipe;

@RestController
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/db-recipe")
    public Recipe getRecipeFromDB(@RequestParam Long id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping("/db-save-recipe")
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return recipe;
    }    
}
