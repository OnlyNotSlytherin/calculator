package com.slytherin.calculator.services;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
//Сервис содержащий список праздников и метод проверки на выходной или праздничный день день
@Service
public class HolidayCheckService implements HolidayCheckServicable {

    private int year = LocalDate.now().getYear();
    //список праздников
    private List<LocalDate> holidays = List.of(
            LocalDate.of(year, 1, 1),
            LocalDate.of(year, 1, 2),
            LocalDate.of(year, 1, 3),
            LocalDate.of(year, 1, 4),
            LocalDate.of(year, 1, 5),
            LocalDate.of(year, 1, 6),
            LocalDate.of(year, 1, 7),
            LocalDate.of(year, 1, 8),
            LocalDate.of(year, 2, 23),
            LocalDate.of(year, 3, 8),
            LocalDate.of(year, 5, 9)
    );
    //Метод проверки. true - если день явлется выходным или праздничным
    @Override
    public boolean check(LocalDate date) {
        return holidays.contains(date) || date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;

    }
}
