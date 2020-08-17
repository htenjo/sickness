package co.zero.sickness.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }
    
    public static LocalDate getLastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }
    
    public static long getMonthsCountBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }
    
    public static boolean isSameMonth(LocalDate startDate, LocalDate endDate) {
        return (startDate.getYear() == endDate.getYear()) && (startDate.getMonth() == endDate.getMonth());
    }
    
    public static long getDaysCountBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
}
