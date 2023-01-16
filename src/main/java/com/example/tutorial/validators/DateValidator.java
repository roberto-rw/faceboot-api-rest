package com.example.tutorial.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {
    public static boolean validateDate(String date){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, formato);
        } catch (DateTimeParseException e) {
            localDate = null;
        }

        // Si el objeto localDate es diferente de null, significa que el String tiene el formato correcto y es una fecha válida
        if (localDate != null) {
            return true;
        } else {
            return false;
        }
    }
}
