package com.foodplanner.project.Food;

import java.util.ArrayList;
import java.util.List;

public class IngredientResponse {
    private List<Ingredient> results;
    private int offset;
    private int number;
    private int totalResults;

    public List<Ingredient> asList() {
        // TODO
        return new ArrayList<Ingredient>();
    }
}
