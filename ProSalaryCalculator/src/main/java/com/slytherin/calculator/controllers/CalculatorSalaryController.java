package com.slytherin.calculator.controllers;

import com.slytherin.calculator.services.CalculateService;
import com.slytherin.calculator.services.CalculatingServicable;
import com.slytherin.calculator.services.HolidayCheckServicable;
import com.slytherin.calculator.services.HolidayCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

//Благодаря инрефейсам CalculatingServicable и HolidayCheckServicable можно, в случае необходимости,
//поменять метод подсчёта отпускных и метод проверки на выходные,
//        используя классы реализующие эти интерфейсы
@RestController
public class CalculatorSalaryController {
    CalculatingServicable clc;
    HolidayCheckServicable hcs;

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam("salary") double salary,
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate) throws Exception {

        hcs = new HolidayCheckService();
        clc = new CalculateService(startDate, endDate, hcs);
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        String result = decimalFormat.format(clc.calculate(salary));
        return result;

    }

}