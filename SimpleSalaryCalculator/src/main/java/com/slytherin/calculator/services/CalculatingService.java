package com.slytherin.calculator.services;

public class CalculatingService implements CalculatingServicable {


    private int holidays;

    public CalculatingService(int holidays) throws Exception {
        if (holidays < 0) {
            throw new Exception("Введено отрицательное число дней");
        }
        this.holidays = holidays;
    }

    public double calculate(double salary) throws Exception {
        if (salary < 0) {
            throw new Exception("Введены некорректные значения: Зарплата не может быть отрицательным числом");
        }
        return salary / 365 * holidays;
    }
}
