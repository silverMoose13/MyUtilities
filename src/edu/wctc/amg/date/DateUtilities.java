package edu.wctc.amg.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Aaron
 */
public class DateUtilities {

    private LocalDateTime localDateTimeObject;
    private DateTimeFormatterStrategy formatter;

    public DateUtilities(LocalDateTime localDateTimeObject, DateTimeFormatterStrategy formatter) {
        this.localDateTimeObject = localDateTimeObject;
        this.formatter = formatter;
    }

    //Convert a LocalDateTime object to a formatted string
    //the user passes in a dateTimeEntry object
    public final String getConvertedLocalDateTimeObjectToFormattedString(LocalDateTime localDateTimeObject,
            DateTimeFormatterStrategy formatter) {
        String dateTimeEntryWithFormatting = localDateTimeObject.format(formatter.getFormattedNumericDayMonthYearDateTime());
        return dateTimeEntryWithFormatting;
    }

    //Convert a formatted string to a LocalDateTime object
    //the user passes in the formatted String
    public final LocalDateTime getConvertedFormattedStringToALocalDateTimeObject(String formattedDateTime) {
        localDateTimeObject = LocalDateTime.parse(formattedDateTime);
        return localDateTimeObject;
    }

    //Get the difference in some time unit between two dates, times or both
    public final Duration getDateDifference(LocalDate dateOne, LocalDate dateTwo) {
        Duration dateDifference = Duration.between(dateOne, dateOne);
        return dateDifference;
    }

    public final Duration getTimeDifference(LocalTime timeOne, LocalTime timeTwo) {
        Duration timeDifference = Duration.between(timeOne, timeOne);
        return timeDifference;
    }

    public final Duration getDateAndTimeDifference(LocalDateTime dateTimeOne, LocalDateTime dateTimeTwo) {
        Duration dateAndTimeDifference = Duration.between(dateTimeOne, dateTimeTwo);
        return dateAndTimeDifference;
    }

    //extra method
    public final DateTimeFormatter getNumericMonthDayYearFormat() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return format;
    }

    //Get a LocalDate or LocalDateTime object for a date or time in the
    //future, or in the past
    public final LocalDateTime getFutureOrPastDate(String date, DateTimeFormatterStrategy formatter) {
        //get the current date time and convert it to a String
        LocalDateTime currentDate = LocalDateTime.now();
        String formattedCurrentDate = getConvertedLocalDateTimeObjectToFormattedString(currentDate, formatter);

        //take the passed in date and format and is formatted the same way
        date = formatter.getFormattedNumericMonthDayYearDateTime().toString();

        //the date and now date will need to be compared as Strings for equality
        //if it passes then it will convert String date to an object and return that
        if (date.matches(formattedCurrentDate)) {
            throw new IllegalArgumentException("Error! The date you provided is not of the past of the future.");
        }
        LocalDateTime nonPresentDate = getConvertedFormattedStringToALocalDateTimeObject(date);
        return nonPresentDate;
    }
    /*For all of the above try to make these methods as flexible as
    possible. For example, don’t hard code a format into the method.
    Instead, figure out a way to let the user decide which format they
    want to use. And don’t assume the user knows the technical
    symbols used for formatting. Provide encapsulated options to choose from. */
    //If you can think of other methods that would be useful, create them
    //too. The more you have the better!
}
