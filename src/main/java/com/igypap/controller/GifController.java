package com.igypap.controller;

import com.igypap.dao.GifDao;
import com.igypap.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by igypap on 28.01.17.
 */
@Controller
public class GifController {


    @Autowired
    private GifDao gifDao;

    @GetMapping("/")
    public String home(ModelMap modelMap) {
        /*gifDao.addGif(new Gif("android-explosion", "Chris Ramacciotti", 1, false));
        gifDao.addGif(new Gif("ben-and-mike", "Ben Jakuben", 2, true));
        gifDao.addGif(new Gif("book-dominos", "Craig Dennis", 2, false));
        gifDao.addGif(new Gif("compiler-bot", "Ada Lovelace", 1, true));
        gifDao.addGif(new Gif("cowboy-coder", "Grace Hopper", 3, false));
        gifDao.addGif(new Gif("infinite-andrew", "Marissa Mayer", 3, true));*/
        modelMap.addAttribute("gifs", gifDao.getAllGifs());
        return "home";
    }

    @GetMapping("/gif")
    public String gifDetails(ModelMap modelMap) {
        Gif gif = gifDao.findGifById("android-explosion");
        modelMap.addAttribute("gif", gif);
        return "gif-details";
    }

    @GetMapping("/favorites")
    public String favorites(ModelMap modelMap) {
        modelMap.addAttribute("gifs", gifDao.getFavorites());
        return "favorites";
    }

    @GetMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        modelMap.addAttribute("gif", gifDao.findGifById(name));
        return "gif-details";
    }
}
