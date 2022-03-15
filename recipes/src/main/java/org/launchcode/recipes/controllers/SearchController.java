package org.launchcode.recipes.controllers;

import org.launchcode.recipes.models.Recipe;
import org.launchcode.recipes.models.RecipeData;
import org.launchcode.recipes.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.launchcode.recipes.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model,
                                       @RequestParam String searchType,
                                       @RequestParam String searchTerm) {
        Iterable<Recipe> recipes;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")) {
            recipes = recipeRepository.findAll();
        } else {
            recipes = RecipeData.findByColumnAndValue(searchType, searchTerm, recipeRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Recipes with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("recipes", recipes);

        return "search";
    }

}
