package org.launchcode.recipes.controllers;

import org.launchcode.recipes.models.data.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cuisine")
public class CuisineController {

    @Autowired
    private CuisineRepository cuisineRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cuisine", cuisineRepository.findAll());
        return "cuisine/index";
    }



}
