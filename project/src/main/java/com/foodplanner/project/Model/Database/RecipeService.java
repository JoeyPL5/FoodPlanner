package com.foodplanner.project.Database;

import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.foodplanner.project.Model.Recipe;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    /**
     * Retrieve a recipe stored in the database. 
     * 
     * @param id the id of the recipe
     * @return the corresponding Recipe object
     * @throws ResourceNotFoundException if the recipe is not found
     */
    public Recipe getRecipe(Long id) throws ResourceNotFoundException {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return recipe.get();
        } else {
            throw new ResourceNotFoundException(String.format("No recipe matches ID (%s).\n", id));
        }
    }

    /**
     * 
     * 
     * @param recipe
     */
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
