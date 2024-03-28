package com.adrenaline.rush.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request,
                            Model model) {
//        System.out.println(name + " " + surname);

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");


        model.addAttribute("message", "Hey " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

}
