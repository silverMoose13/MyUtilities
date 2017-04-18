package edu.wctc.amg.date;

import java.time.format.DateTimeFormatter;

/**
 * The responsibility of this class is to format date/times using a military
 * (24) hour format. This class is an abstraction of the interface
 * DateTimeFormatterStrategy.
 *
 * @author Aaron
 * @version 1.0
 */
public class MilitaryDateTimeFormat implements DateTimeFormatterStrategy {

    private DateTimeFormatter format;

    public MilitaryDateTimeFormat(DateTimeFormatter format) {
        this.format = format;
    }

    /**
     * The purpose of this method is to format numeric date and time in the
     * order of month, day and year using military time (24 hour format)
     *
     * @return A DateTimeFormatter object will be returned having a formatted
     * date/time in the 24 hour format
     */
    @Override
    public final DateTimeFormatter getFormattedNumericMonthDayYearDateTime() {
        format = DateTimeFormatter.ofPattern("MM-dd-yyyy HHmm");
        return format;
    }

    /**
     * The purpose of this method is to format numeric date and time in the
     * order of day, month and year using military time (24 hour format)
     *
     * @return A DateTimeFormatter object will be returned having a formatted
     * date/time in the 24 hour format
     */
    @Override
    public final DateTimeFormatter getFormattedNumericDayMonthYearDateTime() {
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a");
        return format;
    }

}
