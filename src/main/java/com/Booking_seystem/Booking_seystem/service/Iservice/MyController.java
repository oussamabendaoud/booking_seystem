package com.Booking_seystem.Booking_seystem.service.Iservice;

import com.Booking_seystem.Booking_seystem.dao.entities.Room;
import jakarta.validation.Valid;
import springMVCAppw.dao.entities.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {



    @GetMapping("/index1")
    public String index1(Model model) {
        model.addAttribute("title", "Index1 Page");
        return "index1";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("title", "Rooms Page");
        return "rooms";
    }

    @GetMapping("/about-us")
    public String about_us(Model model) {
        model.addAttribute("title", "About Us Page");
        return "about-us";
    }

    @GetMapping("/room-details")
    public String room_details(Model model) {
        model.addAttribute("title", "Room Details");
        return "room-details";
    }

    @GetMapping("/blog-details")
    public String blog_details(Model model) {
        model.addAttribute("title", "Blog Details");
        return "blog-details";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact");
        return "contact";
    }

    @GetMapping("/CRUD_Room")
    public String CRUD_Room(Model model) {
        model.addAttribute("title", "CRUD Room");
        return "CRUD_Room";
    }
    

}
