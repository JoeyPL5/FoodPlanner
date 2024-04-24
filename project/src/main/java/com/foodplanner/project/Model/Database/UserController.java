package com.foodplanner.project.Database;

import org.springframework.web.bind.annotation.RestController;

import com.foodplanner.project.Model.Recipe;
import com.foodplanner.project.Model.User;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    private UserService userService;
    private RecipeService recipeService;

    public UserController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @PostMapping("/db-user-save-recipe")
    public User saveRecipeForUser(@RequestParam Long userId, Long recipeId) throws ResourceNotFoundException {
        return userService.saveRecipeForUser(userId, recipeService.getRecipe(recipeId));
    }

    @PostMapping("/db-user-save-recipe")
    public User saveRecipeForUser(@RequestParam Long userId, @RequestBody Recipe recipe) throws ResourceNotFoundException {
        return userService.saveRecipeForUser(userId, recipe);
    }

    @PutMapping("db-user-remove-recipe")
    public User removeRecipeForUser(@RequestParam Long userId, Long recipeId) throws ResourceNotFoundException {
        return userService.removeRecipeForUser(userId, recipeId);
    }
    
}
