package com.foodplanner.project.Model;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private List<Recipe> savedRecipes;

    // Getters
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Logic

    /**
     * Adds a Recipe to this User's List of saved Recipes. 
     * 
     * @param recipe Recipe to add
     */
    public void addSavedRecipe(Recipe recipe) {
        savedRecipes.add(recipe);
    }

    /**
     * Updates an existing saved recipe.
     * 
     * @param recipe the updated recipe
     * @throws ResourceNotFoundException if the existing recipe is not found
     */
    public void updateSavedRecipe(Recipe recipe) throws ResourceNotFoundException {
        Long thisId = recipe.getdbId();
        for (Recipe savedRecipe : savedRecipes) {
            if (thisId.equals(savedRecipe.getdbId())) {
                savedRecipe = recipe;
                return;
            }
        }
        throw new ResourceNotFoundException("Failed to update recipe, existing recipe not found.\n");
    }

    /**
     * Removes a recipe from the User's saved recipes. 
     * 
     * @param recipeId id of the recipe
     * @throws ResourceNotFoundException if the existing recipe is not found
     */
    public void removeSavedRecipe(Long recipeId) throws ResourceNotFoundException {
        boolean removed = this.savedRecipes.removeIf(recipe -> recipe.getdbId().equals(recipeId));
        if (!removed) {
            throw new ResourceNotFoundException("Failed to remove recipe, existing recipe not found.\n");
        }
    }
}
