package com.slytherin.calculator.services;

import java.time.LocalDate;
// Интерфейс для сервисов, выполняющих проверку является ли день праздничным или выходным
public interface HolidayCheckServicable {
    boolean check(LocalDate date);
}
