package com.igypap.controller;

import com.igypap.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by igypap on 28.01.17.
 */
@Controller
public class GifController {


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/gif")
    public String gifDetails(ModelMap modelMap) {
        Gif gif = new Gif("android-explosion", "igypap", true);
        modelMap.addAttribute("gif", gif);
        return "gif-details";
    }
}
