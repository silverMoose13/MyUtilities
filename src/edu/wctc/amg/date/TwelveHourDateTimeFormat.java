package edu.wctc.amg.date;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Aaron
 */
public class TwelveHourDateTimeFormat implements DateTimeFormatterStrategy {

    private DateTimeFormatter format;

    public TwelveHourDateTimeFormat(DateTimeFormatter format) {
        this.format = format;
    }

    @Override
    public final DateTimeFormatter getFormattedNumericMonthDayYearDateTime() {
        format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm a");
        return format;
    }

    @Override
    public final DateTimeFormatter getFormattedNumericDayMonthYearDateTime() {
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a");
        return format;
    }

}
