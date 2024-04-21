package com.foodplanner.project.Planner;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodplanner.project.Food.Ingredient;

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

    @GetMapping("/ingredient-search")
    public List<Ingredient> searchIngredient(@RequestParam String input) {
        return service.searchIngredient(input);
    }
}
