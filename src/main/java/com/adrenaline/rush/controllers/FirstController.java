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

    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request, Model model) {
        String first = request.getParameter("firstDigit");
        String second = request.getParameter("secondDigit");
        String action = request.getParameter("action");
        int count = 0;

        int firstDigit = Integer.parseInt(first);
        int secondDigit = Integer.parseInt(second);

        switch (action) {
            case "multiplication":
                count = firstDigit * secondDigit;
                break;
            case "addition":
                count = firstDigit + secondDigit;
                break;
            case "subtraction":
                count = firstDigit - secondDigit;
                break;
            case "division":
                count = firstDigit / secondDigit;
                break;
        }

        model.addAttribute("count", Integer.toString(count));

        return "calculator/calculator";
    }
}
