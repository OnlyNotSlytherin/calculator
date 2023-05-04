package com.slytherin.calculator.controllers;

import com.slytherin.calculator.services.CalculatingServicable;
import com.slytherin.calculator.services.CalculatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class CalculatorController {
    CalculatingServicable clc;
    @GetMapping("/calculate")
    public String greeting(@RequestParam(value = "salary") double salary,
                           @RequestParam(value = "holidays") int holidays) throws Exception {

        clc = new CalculatingService(holidays);
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        String result = decimalFormat.format(clc.calculate(salary));
        return result;
    }

}