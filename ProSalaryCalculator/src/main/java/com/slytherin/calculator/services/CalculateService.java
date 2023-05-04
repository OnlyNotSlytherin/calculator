package com.slytherin.calculator.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Сервис для подсчета отпускных
public class CalculateService implements CalculatingServicable {
    //Дата начала отпуска
    private LocalDate startDate;
    //Дата конца отпуска
    private LocalDate endDate;
    //Сервис для выполняющий проверку является ли день праздничным или выходным
    private HolidayCheckServicable holidayCheckService;


    public CalculateService(
            String startDate,
            String endDate,
            HolidayCheckServicable holidayCheckService) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.startDate = LocalDate.parse(startDate, formatter);
        this.endDate = LocalDate.parse(endDate, formatter);
        this.holidayCheckService = holidayCheckService;
        if (!this.endDate.isAfter(this.startDate)) {
            throw new Exception("Введены некорректные значения: День начала отпуска начинается позже дня конца отпуска");
        }

    }

    public double calculate(double salaryPerYear) throws Exception {
        if (salaryPerYear < 0) {
            throw new Exception("Введены некорректные значения: Зарплата не может быть отрицательным числом");
        }
        LocalDate date = startDate;
        int workDays = 0;
        while (!date.isAfter(endDate)) {
            if (!holidayCheckService.check(date)) {
                workDays++;
            }
            date = date.plusDays(1);
        }
        return salaryPerYear / 365 * workDays;
    }
}
