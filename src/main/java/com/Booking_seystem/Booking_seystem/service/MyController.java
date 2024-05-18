package com.Booking_seystem.Booking_seystem.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "Index Page");
        return "index";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("title", "Rooms Page");
        return "rooms";
    }
    
    @GetMapping("/about-us")
    public String about_us(Model model) {
        model.addAttribute("title", "about-us Page");
        return "about-us";
    }
    
    @GetMapping("/room-details")
    public String room_details(Model model) {
        model.addAttribute("title", "room-details");
        return "room-details";
    }
    
    
    @GetMapping("/blog-details")
    public String blog_details(Model model) {
        model.addAttribute("title", "blog-details");
        return "blog-details";
    }
    
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "contact");
        return "contact";
    }
    
    
    
    
    
    
    
}








