package com.adrenaline.rush.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Calculator {
    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request, Model model) {
        String first = request.getParameter("firstDigit");
        String second = request.getParameter("secondDigit");
        String action = request.getParameter("action");
        double count = 0;

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
                count = (double) firstDigit / secondDigit;
                break;
        }

        model.addAttribute("count", Double.toString(count));

        return "calculator/calculator";
    }
}
