package com.abrahamxts.bank.utils;

import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utileria {  

    public static String generarId() {
        return UUID.randomUUID().toString();
    }

    public static String generarFecha() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
    }
}