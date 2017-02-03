package com.igypap.controller;

import com.igypap.dao.CategoryDao;
import com.igypap.dao.GifDao;
import com.igypap.model.Gif;
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
    private CategoryDao categoryDao;

    @Autowired
    private GifDao gifDao;

    @GetMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        /*categoryDao.addCategory(new Category(1, "Gifs"));
        categoryDao.addCategory(new Category(2, "Mems"));
        categoryDao.addCategory(new Category(3, "Technology"));*/
        modelMap.addAttribute("categories", categoryDao.getAllCategories());
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String showCategory(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("category", categoryDao.findById(id));
        List<Gif> gifs = gifDao.findByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }

}
