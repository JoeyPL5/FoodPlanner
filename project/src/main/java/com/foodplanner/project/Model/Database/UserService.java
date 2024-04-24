package com.foodplanner.project.Database;

import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.foodplanner.project.Model.Recipe;
import com.foodplanner.project.Model.User;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User retrieveUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No user in the database matching ID (%s)\n", id));
        }
        return user.get();
    }

    /**
     * Saves the given recipe to the database for the user with the given ID.
     * 
     * @param userId the User's ID
     * @param recipe the recipe to save
     * @return the updated User object
     * @throws ResourceNotFoundException if the given User ID does not match a User in the database
     */
    public User saveRecipeForUser(Long userId, Recipe recipe) throws ResourceNotFoundException {
        User user = retrieveUser(userId);
        user.addSavedRecipe(recipe);
        return userRepository.save(user);
    }

    /**
     * Updates the User's List of saved Recipes with the given Recipe.
     * 
     * @param userId the User's ID
     * @param recipe the Recipe to update
     * @return the User with the updated Recipe
     * @throws ResourceNotFoundException
     */
    public User updateRecipeForUser(Long userId, Recipe recipe) throws ResourceNotFoundException {
        User user = retrieveUser(userId);
        user.updateSavedRecipe(recipe);
        return user;
    }

    public User removeRecipeForUser(Long userId, Long recipeId) throws ResourceNotFoundException {
        User user = retrieveUser(userId);
        user.removeSavedRecipe(recipeId);
        return user;
    }
}
