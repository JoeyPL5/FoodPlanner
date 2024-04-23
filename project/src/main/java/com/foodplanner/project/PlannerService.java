package com.foodplanner.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.foodplanner.project.Food.Ingredient;
import com.foodplanner.project.Food.Recipe;
import com.foodplanner.project.Food.SearchResults.IngredientSearchResult;
import com.foodplanner.project.Food.SearchResults.RecipeSearchResult;
import com.foodplanner.project.Util.Constants;
import com.google.gson.Gson;

@Service
public class PlannerService {
    private final RestTemplate restTemplate;
    private String apiKey;
    private String apiBase;

    public PlannerService(RestTemplate restTemplate, 
                                    @Value("${food-api.key}") String key, 
                                    @Value("${food-api.base}") String base) {
        this.restTemplate = restTemplate;
        this.apiKey = key;
        this.apiBase = base;
    }

    /**
     * Builds a query from the given parameters and endpoint. 
     * 
     * @param parameters the parameters for the query
     * @param endpoint the endpoint to append to the url
     * @return the url for the query
     */
    private String buildQuery(Map<String, String> parameters, String endpoint) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiBase + endpoint)
            .queryParam("apiKey", apiKey);
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        String url = builder.toUriString();
        System.out.println(url);
        return url;
    }

    /**
     * Sends the given query to the API and retrieves the response.
     * 
     * @param url the query to send
     * @param responseType the type the response will deserialize to
     * @return an object of type T
     */
    private <T> T sendQuery(String url, Class<T> responseType) {
        ResponseEntity<String> entity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String body = entity.getBody();
        Gson gson = new Gson();
        T response = gson.fromJson(body, responseType);

        if (response != null) {
            return response;
        } else {
            throw new IllegalArgumentException("Unable to fetch query results for the given parameters.\n");
        }
    }

    /**
     * Searches for a recipe with the given input and returns a list of the results.
     * 
     * @param input the search input
     * @return a list of Recipe results
     */
    public List<Recipe> searchRecipe(String input) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("query", input);
        String url = this.buildQuery(params, Constants.SEARCH_RECIPE_ENDPOINT);
        RecipeSearchResult response = this.sendQuery(url, RecipeSearchResult.class);
        List<Recipe> results = response.getResults();
        return results; 
    }

    /**
     * Retrieve an recipe from the API with the given id. 
     * 
     * @param id the id of the recipe
     * @return the corresponding Recipe object
     */
    public Recipe getRecipeById(int id) {
        Map<String, String> params = new HashMap<>();
        //params.put("id", Integer.toString(id));
        String endpoint = String.format(Constants.RECIPE_BY_ID_ENDPOINT, id);
        String url = this.buildQuery(params, endpoint);
        Recipe response = this.sendQuery(url, Recipe.class);
        return response; 
    }

    /**
     * Searches for an ingredient with the given input and returns a list of the results. 
     * 
     * @param input the search input
     * @return a list of Ingredient results
     */
    public List<Ingredient> searchIngredient(String input) {
        Map<String, String> params = new HashMap<>();
        params.put("query", input);
        String url = this.buildQuery(params, Constants.SEARCH_INGREDIENT_ENDPOINT);
        IngredientSearchResult response = this.sendQuery(url, IngredientSearchResult.class);
        List<Ingredient> results = response.getResults();
        return results;
    }

    /**
     * Retrieve an ingredient from the API with the given id. 
     * 
     * @param id the id of the ingredient
     * @return the corresponding Ingredient object
     */
    public Ingredient getIngredientById(int id) {
        Map<String, String> params = new HashMap<>();
        //params.put("id", Integer.toString(id));
        String endpoint = String.format(Constants.INGREDIENT_BY_ID_ENDPOINT, id);
        String url = this.buildQuery(params, endpoint);
        Ingredient response = this.sendQuery(url, Ingredient.class);
        return response; 
    }
}
