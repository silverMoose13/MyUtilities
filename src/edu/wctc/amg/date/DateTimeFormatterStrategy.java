package edu.wctc.amg.date;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Aaron
 */
public interface DateTimeFormatterStrategy {
    
    public abstract DateTimeFormatter getFormattedNumericMonthDayYearDateTime();
    
    public abstract DateTimeFormatter getFormattedNumericDayMonthYearDateTime();
}
