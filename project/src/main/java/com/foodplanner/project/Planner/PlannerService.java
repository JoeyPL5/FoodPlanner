package com.foodplanner.project.Planner;

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
import com.foodplanner.project.Food.IngredientResponse;
import com.google.gson.Gson;

@Service
public class PlannerService {
    private final RestTemplate restTemplate;
    
    private String apiKey;

    private String apiBase;

    public PlannerService(RestTemplate restTemplate, 
                                    @Value("${exchange-api.key}") String key, 
                                    @Value("${exchange-api.base}") String base) {
        this.restTemplate = restTemplate;
        this.apiKey = key;
        this.apiBase = base;
    }

    /**
     * 
     * 
     * @param input
     * @return
     */
    public List<Ingredient> searchIngredient(String input) {
        Map<String, String> params = new HashMap<>();
        params.put("query", input);
        IngredientResponse response = this.sendIngredientQuery(this.buildQuery(params));
        List<Ingredient> results = response.asList();
        return results;
    }

    /**
     * 
     * @param parameters
     * @return
     */
    private String buildQuery(Map<String, String> parameters) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiBase)
            .queryParam("apikey", apiKey);
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        String url = builder.toUriString();
        return url;
    }

    /**
     * Sends the given ingredient query to the API and retrieves the response.
     * 
     * @param url the query to send
     * @return an ExchangeRatesResponse object
     */
    private IngredientResponse sendIngredientQuery(String url) {
        ResponseEntity<String> entity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String body = entity.getBody();
        Gson gson = new Gson();
        IngredientResponse response = gson.fromJson(body, IngredientResponse.class);

        if (response != null) {
            return response;
        } else {
            throw new IllegalArgumentException("Unable to fetch exchange rates for given parameters.\n");
        }
    }


}
