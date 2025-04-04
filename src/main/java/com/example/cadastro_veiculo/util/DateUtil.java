package com.example.cadastro_veiculo.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class DateUtil {

    public static LocalDateTime stringToLocalDateTime(String dateStr) {
        if (dateStr == null || dateStr.isBlank()) {
            return null;
        }
        try {
            return LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use: yyyy-MM-dd'T'HH:mm:ss");
        }
    }
}
