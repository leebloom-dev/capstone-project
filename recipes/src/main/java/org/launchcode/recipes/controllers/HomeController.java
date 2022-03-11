package org.launchcode.recipes.controllers;

import org.launchcode.recipes.models.Cuisine;
import org.launchcode.recipes.models.Ingredient;
import org.launchcode.recipes.models.Recipe;
import org.launchcode.recipes.models.data.CuisineRepository;
import org.launchcode.recipes.models.data.IngredientRepository;
import org.launchcode.recipes.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/* This controller starts at the ROOT path */
@Controller
public class HomeController {

    /* FIELDS */
    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;


    /* CONTROLLER METHODS */
    @RequestMapping
    public String index(Model model) {
        model.addAttribute("title", "My Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddRecipeForm(Model model) {
        model.addAttribute("title", "Add Recipes");
        model.addAttribute(new Recipe());
        model.addAttribute("cuisines", cuisineRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                       Errors errors,
                                       Model model,
                                       @RequestParam int cuisineId,
                                       @RequestParam List<Integer> ingredients) {

        // Validates if any errors, redirects to ROOT/add.html
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            return "add";
        }

        // Either finds the Cuisine Id from repository or creates a new
        // Cuisine object
        Cuisine cuisine = cuisineRepository.findById(cuisineId).orElse(new Cuisine());
        newRecipe.setCuisine(cuisine);

        /*
        Creating a list of ingredient objects.
        It is trying to cast whatever comes in to that type.

        It's establishing that ingredientsObjs should be a List of Ingredient objects,
        but whatever comes back from that "find all" method, it(s going to case it to
        the appropriate type to make sure that it gets set correctly.
        */
        List<Ingredient> ingredientObjs = (List<Ingredient>) ingredientRepository.findAllById(ingredients);
        newRecipe.setIngredients(ingredientObjs);

        /* Saving the Ingredients of the Recipes to the Recipe Repository */
        recipeRepository.save(newRecipe);
        return "redirect:";

    }

    @GetMapping("view/{recipeId}")
    public String displayViewRecipe(Model model,
                                    @PathVariable int recipeId) {
        Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);

        model.addAttribute("title", "Recipe ID: " + recipeId);
        model.addAttribute("recipe", optRecipe.get());
        return "view";
    }

}
