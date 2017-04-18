package edu.wctc.amg.date;

import java.time.format.DateTimeFormatter;

/**
 * The responsibility of this interface is to create the empty methods needed
 * for a date and time formatter strategy object
 *
 * @author Aaron
 * @version 1.0
 */
public interface DateTimeFormatterStrategy {

    /**
     * The purpose of this method is to design a blank template for formatting
     * numeric date and time in the order of month, day and year.
     *
     * @return A DateTimeFormatter object will be returned having a formatted
     * date/time
     */
    public abstract DateTimeFormatter getFormattedNumericMonthDayYearDateTime();

    /**
     * The purpose of this method is to design a blank template for formatting
     * numeric date and time in the order of day, month and year.
     *
     * @return A DateTimeFormatter object will be returned having a formatted
     * date/time
     */
    public abstract DateTimeFormatter getFormattedNumericDayMonthYearDateTime();
}
