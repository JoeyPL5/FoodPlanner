package com.foodplanner.project.Food.SearchResults;

import java.util.List;

public abstract class SearchResult<T> {
    private List<T> results;
    private int offset;
    private int number;
    private int totalResults;

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        for (T result : results) {
            resultString.append(result.toString());
            resultString.append(", ");
        }
        if (!results.isEmpty()) {
            resultString.delete(resultString.length() - 2, resultString.length()); // remove trailing ", "
        }
        return resultString.toString();
    }

    public List<T> getResults() {
        return results;
    }

    public int getOffset() {
        return offset;
    }

    public int getNumber() {
        return number;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }    
}
