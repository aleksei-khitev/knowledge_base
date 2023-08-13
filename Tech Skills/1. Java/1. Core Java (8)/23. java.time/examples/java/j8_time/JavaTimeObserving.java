package j8_time;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class JavaTimeObserving {
    public static void main(String[] args) {
        //playWithLocalDate();
        //playWithLocalTime();
        //playWithLocalDateTime();
        //playWithDuration();
        playWithPeriod();
    }

    private static void playWithLocalDate() {
        LocalDate localDate = LocalDate.of(2019, 10, 20);
        System.out.println("localDate.getYear() " + localDate.getYear());
        System.out.println("localDate.getMonth() " + localDate.getMonth());
        System.out.println("localDate.getDayOfMonth() " + localDate.getDayOfMonth());
        System.out.println("localDate.getDayOfWeek() " + localDate.getDayOfWeek());
        System.out.println("localDate.getDayOfYear() " + localDate.getDayOfYear());
        System.out.println("localDate.lengthOfMonth() " + localDate.lengthOfMonth());
        System.out.println("localDate.lengthOfYear() " + localDate.lengthOfYear());
        System.out.println("localDate.isLeapYear() " + localDate.isLeapYear());
        localDate = LocalDate.now();
        System.out.println("Now " + localDate);
        int year = localDate.get(ChronoField.YEAR);
        int month = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year + " " + month + " " + day);
        localDate = LocalDate.parse("2018-11-19");
        System.out.println("On last year Gussic burthday " + localDate);
    }

    private static void playWithLocalTime() {
        LocalTime localTime = LocalTime.of(12, 20, 10, 11);
        System.out.println("localTime.getHour() " + localTime.getHour());
        System.out.println("localTime.getMinute() " + localTime.getMinute());
        System.out.println("localTime.getSecond() " + localTime.getSecond());
        System.out.println("localTime.getNano() " + localTime.getNano());
        System.out.println("localTime.get(ChronoField.HOUR_OF_DAY) " + localTime.get(ChronoField.HOUR_OF_DAY));
        localTime = LocalTime.now();
        System.out.println(localTime);
        localTime = LocalTime.parse("15:30");
        System.out.println(localTime);
    }

    private static void playWithLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2016, Month.MAY, 5, 12, 00);
        System.out.println("localDateTime.getYear() " + localDateTime.getYear());
        System.out.println("localDateTime.getMonth() " + localDateTime.getMonth());
        System.out.println("localDateTime.getDayOfMonth() " + localDateTime.getDayOfMonth());
        System.out.println("localDateTime.getDayOfWeek() " + localDateTime.getDayOfWeek());
        System.out.println("localDateTime.getDayOfYear() " + localDateTime.getDayOfYear());
        System.out.println("localDateTime.lengthOfMonth() " + localDateTime.toLocalDate().lengthOfMonth());
        System.out.println("localDateTime.lengthOfYear() " + localDateTime.toLocalDate().lengthOfYear());
        System.out.println("localDateTime.isLeapYear() " + localDateTime.toLocalDate().isLeapYear());
        System.out.println("localTime.getHour() " + localDateTime.getHour());
        System.out.println("localTime.getMinute() " + localDateTime.getMinute());
        System.out.println("localTime.getSecond() " + localDateTime.getSecond());
        System.out.println("localTime.getNano() " + localDateTime.getNano());
        System.out.println("После преобразования к localDate:");
        System.out.println("localDateTime.toLocalDate().lengthOfMonth() " + localDateTime.toLocalDate().lengthOfMonth());
        System.out.println("localDateTime.toLocalDate().lengthOfYear() " + localDateTime.toLocalDate().lengthOfYear());
        System.out.println("localDateTime.toLocalDate().isLeapYear() " + localDateTime.toLocalDate().isLeapYear());
        localDateTime = LocalDateTime.now();
        System.out.println("now " + localDateTime);
        LocalDate localDate = LocalDate.of(2019, 10, 25);
        LocalTime localTime = LocalTime.of(9, 0);
        localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("Jocker registration at " + localDateTime);
        localDateTime = localDate.atTime(10, 0);
        System.out.println("Joker opening " + localDateTime);
    }

    private static void playWithDuration() {
        LocalDateTime nowIs = LocalDateTime.of(2019, Month.OCTOBER, 24, 11, 50);
        LocalDateTime jokerRegistrationAt = LocalDateTime.of(2019, Month.OCTOBER, 25, 9, 0);
        Duration duration = Duration.between(nowIs, jokerRegistrationAt);
        System.out.println("duration.getSeconds() " + duration.getSeconds());
        duration = Duration.ofDays(10);
        System.out.println("10 days " + duration);
        System.out.println("3 weeks " + duration);
    }

    private static void playWithPeriod() {
        Period period = Period.ofWeeks(3);
        System.out.println("period.getDays() " + period.getDays());
    }
}
