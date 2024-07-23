package io.github.tibetteixeira.java8.new_date_api;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class App {

    // LocalDate - Representa uma data: 06/12/2021
    // LocalTime - Representa um tempo: 12:25:00
    // LocalDateTime - Representa data + hora: 21/10/2022 14:33:00
    // Instant -  Representa um instante/momento na linha do tempo (milissegundos a partir de 01/01/1970 00:00:00)
    // ZonedDateTime - É um LocalDateTime com timezone: 21/10/2022 14:33:00 GMT-3 (America/Sao_Paulo)
    // Period - Espaço de tempo baseado em datas
    // Duration - Espaço de tempo baseado em horas

    public static void main(String[] args) {
        nowMethods();
        ofMethods();
        plusMethods();
        minusMethods();
        betweenMethods();
        dateTimeFormatter();
    }

    private static void minusMethods() {
        LocalDate localDate = LocalDate.now().minusDays(2);
        LocalTime localTime = LocalTime.now().minusHours(2);
        Instant instant = Instant.now().minusSeconds(2);
        LocalDateTime localDateTime = LocalDateTime.now().minusWeeks(2);

        System.out.println("\n----- MINUS METHODS -----");
        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalTime: " + localTime);
        System.out.println("Instant: " + instant);
        System.out.println("LocalDateTime: " + localDateTime);
    }

    private static void plusMethods() {
        LocalDate localDate = LocalDate.now().plusWeeks(2);
        LocalTime localTime = LocalTime.now().plusHours(2);
        Instant instant = Instant.now().plusSeconds(2);
        LocalDateTime localDateTime = LocalDateTime.now().plusWeeks(2);

        Period period5Days = Period.ofDays(5);
        LocalDate localDateAfter5Days = localDate.plus(period5Days);

        Duration duration5Hours = Duration.ofHours(5);
        LocalTime localTimeAfter5Hours = localTime.plus(duration5Hours);

        System.out.println("\n----- PLUS METHODS -----");
        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalDate after 5 days: " + localDateAfter5Days);
        System.out.println("LocalTime: " + localTime);
        System.out.println("LocalTime after 5 hours: " + localTimeAfter5Hours);
        System.out.println("Instant: " + instant);
        System.out.println("LocalDateTime: " + localDateTime);
    }

    private static void betweenMethods() {
        LocalDate localDateStart = LocalDate.of(2022, Month.MARCH, 3);
        LocalDate localDateEnd = LocalDate.of(2023, Month.DECEMBER, 15);

        LocalTime localTimeStart = LocalTime.now();
        LocalTime localTimeEnd = LocalTime.now().plusHours(2);

        Period period = Period.between(localDateStart, localDateEnd);
        Period periodUntil = localDateStart.until(localDateEnd);

        Duration duration = Duration.between(localTimeStart, localTimeEnd);

        System.out.println("\n----- BETWEEN METHODS -----");
        System.out.println("Period: " + period);
        System.out.println("Period Until: " + periodUntil);
        System.out.println("Duration: " + duration);
    }

    private static void ofMethods() {
        LocalDate localDate = LocalDate.of(2022, Month.MARCH, 3);
        LocalTime localTime = LocalTime.of(12, 30, 24, 1000);
        Instant instantMili = Instant.ofEpochMilli(1699999900000L);
        Instant instantSec = Instant.ofEpochSecond(1705030924);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        Period period = Period.of(1, 5, 3);
        Duration durationDays = Duration.ofDays(2);
        Duration durationMinutes = Duration.ofMinutes(220);

        System.out.println("\n----- OF METHODS -----");
        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalTime: " + localTime);
        System.out.println("Instant mili: " + instantMili);
        System.out.println("Instant sec: " + instantSec);
        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("Period: " + period);
        System.out.println("Duration days: " + durationDays);
        System.out.println("Duration minutes: " + durationMinutes);
    }

    private static void nowMethods() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Instant instant = Instant.now();
        Long epoch = Instant.now().getEpochSecond();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println("\n----- NOW METHODS -----");
        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalTime: " + localTime);
        System.out.println("Instant: " + instant);
        System.out.println("Epoch: " + epoch);
        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("ZonedDateTime: " + zonedDateTime);
    }

    private static void dateTimeFormatter() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter isoTime = DateTimeFormatter.ISO_TIME;
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;

        DateTimeFormatter formatterStyleDateShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter formatterStyleDateMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter formatterStyleDateLong = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter formatterStyleDateFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter myPattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("\n----- FORMATTER METHODS -----");
        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("LocalDateTime isoDate: " + isoDate.format(localDateTime));
        System.out.println("LocalDateTime isoTime: " + isoTime.format(localDateTime));
        System.out.println("LocalDateTime isoDateTime: " + isoDateTime.format(localDateTime));
        System.out.println();
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("ZonedDateTime isoDate: " + isoDate.format(zonedDateTime));
        System.out.println("ZonedDateTime isoTime: " + isoTime.format(zonedDateTime));
        System.out.println("ZonedDateTime isoDateTime: " + isoDateTime.format(zonedDateTime));
        System.out.println();
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("ZonedDateTime StyleDateShort: " + formatterStyleDateShort.format(zonedDateTime));
        System.out.println("ZonedDateTime StyleDateMedium: " + formatterStyleDateMedium.format(zonedDateTime));
        System.out.println("ZonedDateTime StyleDateLong: " + formatterStyleDateLong.format(zonedDateTime));
        System.out.println("ZonedDateTime StyleDateFull: " + formatterStyleDateFull.format(zonedDateTime));
        System.out.println();
        System.out.println("ZonedDateTime MyPattern: " + myPattern.format(zonedDateTime));

    }

}
