package edu.wctc.amg.date;

import java.time.format.DateTimeFormatter;

/**
 * The responsibility of this class is to format date/times using a twelve hour
 * format. This class is an abstraction of the interface
 * DateTimeFormatterStrategy.
 *
 * @author Aaron
 * @version 1.0
 * @since 1.8
 */
public class TwelveHourDateTimeFormat implements DateTimeFormatterStrategy {

    private DateTimeFormatter format;

    public TwelveHourDateTimeFormat(DateTimeFormatter format) {
        this.format = format;
    }

    /**
     * The purpose of this method is to format numeric date and time in the
     * order of month, day and year using AM and PM (12 hour format)
     *
     * @return A DateTimeFormatter object will be returned having a formatted
     * date/time in the twelve hour format
     */
    @Override
    public final DateTimeFormatter getFormattedNumericMonthDayYearDateTime() {
        format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm a");
        return format;
    }

    /**
     * The purpose of this method is to format numeric date and time in the
     * order of day, month and year using AM and PM (12 hour format)
     *
     * @return A DateTimeFormatter object will be returned having a formatted
     * date/time in the twelve hour format
     */
    @Override
    public final DateTimeFormatter getFormattedNumericDayMonthYearDateTime() {
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a");
        return format;
    }

}
