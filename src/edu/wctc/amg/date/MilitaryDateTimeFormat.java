package edu.wctc.amg.date;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Aaron
 */
public class MilitaryDateTimeFormat implements DateTimeFormatterStrategy {

    private DateTimeFormatter format;

    public MilitaryDateTimeFormat(DateTimeFormatter format) {
        this.format = format;
    }
    
    @Override
    public final DateTimeFormatter getFormattedNumericMonthDayYearDateTime() {
        format = DateTimeFormatter.ofPattern("MM-dd-yyyy HHmm");
        return format;
    }

    @Override
    public final DateTimeFormatter getFormattedNumericDayMonthYearDateTime() {
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a");
        return format;
    }


    
}
