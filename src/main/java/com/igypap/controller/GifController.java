package com.igypap.controller;

import com.igypap.model.Gif;
import com.igypap.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by igypap on 28.01.17.
 */
@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("gifs", gifRepository.getAllGifs());
        return "home";
    }

    @GetMapping("/gif")
    public String gifDetails(ModelMap modelMap) {
        Gif gif = gifRepository.findByName("android-explosion");
        modelMap.addAttribute("gif", gif);
        return "gif-details";
    }
}
