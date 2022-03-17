package org.launchcode.recipes.controllers;

import org.launchcode.recipes.models.Recipe;
import org.launchcode.recipes.models.RecipeData;
import org.launchcode.recipes.models.data.CuisineRepository;
import org.launchcode.recipes.models.data.IngredientRepository;
import org.launchcode.recipes.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private RecipeRepository recipeRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();


    /* CONTROLLER */
    public ListController () {
        columnChoices.put("all", "All");
        columnChoices.put("cuisine", "Cuisine");
        columnChoices.put("ingredient", "Ingredient");
    }


    /* CONTROLLER METHODS */
    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("cuisines", cuisineRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "recipes")
    public String listJobsByColumnAndValue(Model model,
                                           @RequestParam String column,
                                           @RequestParam String value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")) {
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
            model.addAttribute("title", "Recipes with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("recipes", recipes);

        return "list-recipes";
    }

}
