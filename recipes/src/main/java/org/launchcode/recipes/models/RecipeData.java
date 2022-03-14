package org.launchcode.recipes.models;

import java.util.ArrayList;

public class RecipeData {

    /**
     * Returns the results of searching the Recipes data by field and search term.
     *
     * For example, searching for cuisine "Japanese" will include results
     * with "Japanese Soups".
     *
     * @param column Recipe field that should be searched.
     * @param value Value of the field to search for.
     * @param allRecipes The list of jobs to search.
     * @return List of all recipes matching the criteria.
     */
    public static ArrayList<Recipe> findByColumnAndValue(String column,
                                                         String value,
                                                         Iterable<Recipe> allRecipes) {

        ArrayList<Recipe> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Recipe>) allRecipes;
        }

        if (column.equals("all")){
            results = findByValue(value, allRecipes);
            return results;
        }
        for (Recipe recipe : allRecipes) {

            String aValue = getFieldValue(recipe, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(recipe);
            }
        }

        return results;
    }

    public static String getFieldValue(Recipe recipe, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = recipe.getName();
        } else if (fieldName.equals("employer")){
            theValue = recipe.getCuisine().toString();
        } else {
            theValue = recipe.getIngredients().toString();
        }

        return theValue;
    }

    /**
     * Search all Recipe fields for the given term.
     *
     * @param value The search term to look for.
     * @param allRecipes The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Recipe> findByValue(String value,
                                                Iterable<Recipe> allRecipes) {
        String lower_val = value.toLowerCase();

        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe job : allRecipes) {

            if (job.getName().toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (job.getCuisine().toString().toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (job.getIngredients().toString().toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (job.toString().toLowerCase().contains(lower_val)) {
                results.add(job);
            }

        }

        return results;
    }
}
