package org.launchcode.recipes.controllers;

import org.launchcode.recipes.models.Recipe;
import org.launchcode.recipes.models.data.CuisineRepository;
import org.launchcode.recipes.models.data.IngredientRepository;
import org.launchcode.recipes.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    /* FIELDS */
    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository repository;

    static HashMap<String, String> columnChoices = new HashMap<>();


    /* CONTROLLER */
    public ListController () {
        columnChoices.put("all", "All");
        columnChoices.put("cuisine", "Cuisine");
        columnChoices.put("ingredient", "Ingredient");
    }


    /* CONTROLLER METHODS */

}
