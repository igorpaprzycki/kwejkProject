package com.igypap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by igypap on 28.01.17.
 */
@Controller
public class GifController {


    @GetMapping("/")
    public String listGifs(){
        return "home";
    }
}
