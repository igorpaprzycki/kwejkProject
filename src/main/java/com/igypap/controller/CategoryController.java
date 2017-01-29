package com.igypap.controller;

import com.igypap.model.Gif;
import com.igypap.repository.CategoryRepository;
import com.igypap.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by igypap on 29.01.17.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryRepository.getAllCategories());
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String showCategory(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("category", categoryRepository.findById(id));
        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }

}
