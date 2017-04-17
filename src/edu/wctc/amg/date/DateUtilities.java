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
    private DateTimeFormatter format;

    public DateUtilities(LocalDateTime localDateTimeObject, DateTimeFormatter format) {
        this.localDateTimeObject = localDateTimeObject;
        this.format = format;
    }

    //Convert a LocalDateTime object to a formatted string
    //the user passes in a dateTimeEntry object
    public final void convertLocalDateTimeObjectToFormattedString(LocalDateTime localDateTimeObject) {
        String dateTimeEntryWithFormatting = localDateTimeObject.format(getNumericMonthDayYearWithTwelveHourTimeFormat());
    }

    //Convert a formatted string to a LocalDateTime object
    //the user passes in the formatted String
    public final void convertFormattedStringToALocalDateTimeObject(String formattedDateTime) {
        localDateTimeObject = LocalDateTime.parse(formattedDateTime);
    }

    //create an interface and an abstraction of each with one of these? That
    //way the user can call in the abstraction?
    public final DateTimeFormatter getNumericMonthDayYearWithTwelveHourTimeFormat() {
        format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm a");
        return format;
    }

    public final DateTimeFormatter getNumericDayMonthYearWithTwelveHourTimeFormat() {
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a");
        return format;
    }

    public final DateTimeFormatter getNumericMonthDayYearWithMilitaryTimeFormat() {
        format = DateTimeFormatter.ofPattern("MM-dd-yyyy HHmm");
        return format;
    }

    public final DateTimeFormatter getNumericDayMonthYearWithMilitaryTimeFormat() {
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
        return format;
    }
    
    public final DateTimeFormatter getNumericMonthDayYearFormat() {
        format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return format;
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

    //Get a LocalDate or LocalDateTime object for a date or time in the
    //future, or in the past
//    public final LocalDateTime getDate(String date) {
//        
//        //this will want to take the String date and format it
//        date = getNumericMonthDayYearFormat().toString();
//        LocalDate currentDate = LocalDate.now();
//        //localDateTime will need to be formatted the same way
//        //the date and now date will need to be compared as Strings for equality
//        //if it passes then it will convert String date to an object and return that
//        if (date != currentDateTime)
//        convertFormattedStringToALocalDateTimeObject(date);
//        return nonPresentTime;
//    }
    
    /*For all of the above try to make these methods as flexible as
    possible. For example, don’t hard code a format into the method.
    Instead, figure out a way to let the user decide which format they
    want to use. And don’t assume the user knows the technical
    symbols used for formatting. Provide encapsulated options to choose from. */
    //If you can think of other methods that would be useful, create them
    //too. The more you have the better!
}
