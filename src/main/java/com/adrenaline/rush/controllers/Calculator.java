package com.adrenaline.rush.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Calculator {
    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request, Model model) {
        int firstDigit = Integer.parseInt(request.getParameter("firstDigit"));
        int secondDigit = Integer.parseInt(request.getParameter("secondDigit"));
        String action = request.getParameter("action");
        double count;

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
                count = (double) firstDigit / secondDigit;
                break;
            default:
                count = 0;
                break;
        }

        model.addAttribute("count", "The result is: " + count);

        return "calculator/calculator";
    }
}
