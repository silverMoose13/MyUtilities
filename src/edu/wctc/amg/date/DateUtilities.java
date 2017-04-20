package edu.wctc.amg.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * The responsibility of this class is to provide various DateUtilities methods
 * so that other classes can use them without having to re-write new code. This
 * ensures consistency and reliability is achieved.
 *
 * @author Aaron
 * @version 1.0
 * @since 1.8
 */
public class DateUtilities {

    private LocalDateTime localDateTimeObject;
    private DateTimeFormatterStrategy formatter;

    public DateUtilities(LocalDateTime localDateTimeObject, DateTimeFormatterStrategy formatter) {
        this.localDateTimeObject = localDateTimeObject;
        this.formatter = formatter;
    }

    /**
     * This method converts a LocalDateTime object into a formatted string using
     * pattern passed in from the user.
     *
     * @param localDateTimeObject This object derives from the LocalDateTime
     * class
     * @param formatter This object derives from the DateTimeFormatterStrategy
     * interface which provides the user provided format
     * @return A formatted String containing a date and time
     * @throws IllegalArgumentException is thrown if any of the objects passed
     * in are null
     */
    public final String getFormattedStringFromALocalDateTimeObject(LocalDateTime localDateTimeObject,
            DateTimeFormatterStrategy formatter) throws IllegalArgumentException {
        if (localDateTimeObject == null || formatter == null) {
            throw new IllegalArgumentException("Error! Objects passed in must not be null.");
        }
        String dateTimeEntryWithFormatting = localDateTimeObject.format(formatter.getFormattedNumericDayMonthYearDateTime());
        return dateTimeEntryWithFormatting;
    }

    /**
     * This method takes a formatted String value containing a date and time and
     * converts it to a LocalDateTime object
     *
     * @param formattedDateTime The user passes in a formatted String that
     * contains a date and time
     * @return A LocalDateTime object is returned
     * @throws IllegalArgumentException is thrown is the String value passed in
     * is null or empty
     */
    public final LocalDateTime getLocalDateTimeObjectFromAFormattedString(String formattedDateTime)
            throws IllegalArgumentException {
        if (formattedDateTime == null || formattedDateTime.isEmpty()) {
            throw new IllegalArgumentException("Error! Value must not be null or empty.");
        }
        localDateTimeObject = LocalDateTime.parse(formattedDateTime);
        return localDateTimeObject;
    }

    /**
     * This method gets the date difference in days between two LocalDate
     * objects
     *
     * @param dateOne A LocalDate object
     * @param dateTwo A LocalDate object
     * @return A long value in days will be returned. This value will contain
     * the date difference between two LocalDate objects
     * @throws IllegalArgumentException is thrown if either of the objects
     * passed in are null
     */
    public final long getTimeDifferenceInDaysBetweenTwoLocalDateObjects(LocalDate dateOne, LocalDate dateTwo)
            throws IllegalArgumentException {
        if (dateOne == null || dateTwo == null) {
            throw new IllegalArgumentException("Error! Objects passed in must not be null.");
        }
        Duration dateDifference = Duration.between(dateOne, dateOne);
        long dateDifferenceInDays = dateDifference.toDays();
        return dateDifferenceInDays;
    }

    /**
     * This method gets the time difference in hours between two LocalTime
     * objects
     *
     * @param timeOne A LocalTime object
     * @param timeTwo A LocalTime object
     * @return The time difference between two times is returned as a long value
     * in hours.
     * @throws IllegalArgumentException is thrown if either of the objects
     * passed in are null
     */
    public final long getTimeDifferenceInHoursBetweenTwoLocalTimeObjects(LocalTime timeOne, LocalTime timeTwo) throws IllegalArgumentException {
        if (timeOne == null || timeTwo == null) {
            throw new IllegalArgumentException("Error! Objects passed in must not be null.");
        }
        Duration timeDifference = Duration.between(timeOne, timeOne);
        long timeDifferenceInHours = timeDifference.toHours();
        return timeDifferenceInHours;
    }

    /**
     * This method gets the overall between time difference in minutes between
     * two LocalDateTime objects
     *
     * @param dateTimeOne A LocalDateTime object
     * @param dateTimeTwo A LocalDateTime object
     * @return The time difference between two LocalDateTimeObjects are returned
     * as a long
     * @throws IllegalArgumentException is thrown if either of the objects
     * passed in are null
     */
    public final long getTimeDifferenceInMinutesUsingLocalDateTimeObjects(LocalDateTime dateTimeOne,
            LocalDateTime dateTimeTwo) throws IllegalArgumentException {
        if (dateTimeOne == null || dateTimeTwo == null) {
            throw new IllegalArgumentException("Error! Objects passed in must not be null.");
        }
        Duration timeDifference = Duration.between(dateTimeOne, dateTimeTwo);
        long timeDifferenceInMinutes = timeDifference.toMinutes();
        return timeDifferenceInMinutes;
    }

    /**
     * This method formats the date using a numeric month day year format:
     * MM-dd-yyyy
     *
     * @return A DateTimeFormatter object is returned with a formatted date
     */
    public final DateTimeFormatter getNumericMonthDayYearFormat() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return format;
    }

    /**
     * This method gets a future or past date
     *
     * @param date Contains a String date
     * @param formatter Abstraction of a DateTimeFormatterStrategy object
     * @return A LocalDateTime object containing a past or future date
     * @throws IllegalArgumentException is thrown if String date value is null
     * or empty
     * @throws IllegalArgumentException is thrown if the object passed in is
     * null or empty
     */
    public final LocalDateTime getFutureOrPastDate(String date, DateTimeFormatterStrategy formatter)
            throws IllegalArgumentException {
        if (date == null || formatter == null || date.isEmpty()) {
            throw new IllegalArgumentException("Error! Value must not be null or empty.");
        }
        //get the current date time and convert it to a String
        LocalDateTime currentDate = LocalDateTime.now();
        String formattedCurrentDate = getFormattedStringFromALocalDateTimeObject(currentDate, formatter);

        //take the passed in date and format and is formatted the same way
        date = formatter.getFormattedNumericMonthDayYearDateTime().toString();

        //the date and now date will need to be compared as Strings for equality
        //if it passes then it will convert String date to an object and return that
        if (date.matches(formattedCurrentDate)) {
            throw new IllegalArgumentException("Error! The date you provided is not of the past of the future.");
        }
        LocalDateTime nonPresentDate = getLocalDateTimeObjectFromAFormattedString(date);
        return nonPresentDate;
    }
}
