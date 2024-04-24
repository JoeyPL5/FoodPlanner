package com.foodplanner.project;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodplanner.project.Model.Ingredient;
import com.foodplanner.project.Model.Recipe;

@RestController
public class PlannerController {
    
    private final PlannerService service;

    public PlannerController(PlannerService plannerService) {
        this.service = plannerService;
    }

    // @GetMapping("/login")
    // public void login(@RequestParam username, @RequestParam password) {

    // }

    // @GetMapping("/ingredient")
    // public String getIngredient() {

    // }

    @GetMapping("/recipe-search")
    public List<Recipe> searchRecipe(@RequestParam String input) {
        return service.searchRecipe(input);
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipesById(@RequestParam int... ids) {
        return service.getRecipesById(ids);
    }
    

    @GetMapping("/ingredient-search")
    public List<Ingredient> searchIngredient(@RequestParam String input) {
        return service.searchIngredient(input);
    }

    @GetMapping("/ingredient")
    public Ingredient getIngredientById(@RequestParam int id) {
        return service.getIngredientById(id);
    }
}
