package data.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateAndTime {
    public static void main(String[] args) throws ParseException {
        System.out.println("-- BAD PRACTICE: DATES --");
        showBadPracticeDate();

        System.out.println("-- GOOD PRACTICE: DATES --");
        showGoodPracticeDate();

        System.out.println("-- GOOD PRACTICE: TIME --");
        showGoodPracticeTime();

    }

    /**
     * java.util.Date and java.util.Calendar are old classes and we should avoid them
     */

    private static void showBadPracticeDate() throws ParseException {
        //outdated API before Java 8
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(2025, GregorianCalendar.JANUARY, 31);
        Date firstDate = gregorianCalendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        System.out.println(simpleDateFormat.format(firstDate));

        Date secondDate = simpleDateFormat.parse("09 May 2022");
        gregorianCalendar.setTime(secondDate);
        System.out.println("Day of month: " + gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));
    }

    private static void showGoodPracticeDate() {
        //new API from Java 8
        LocalDate firstDate = LocalDate.of(2025, Month.JANUARY, 31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        System.out.println(formatter.format(firstDate));

        LocalDate secondDate = LocalDate.parse("09 May 2022", formatter);
        System.out.println("Day of month: " + secondDate.getDayOfMonth());

    }

    private static void showGoodPracticeTime() {
        //UTC - this does not return the time from your machine if you are not living in UTC
        Instant nowUtc = Instant.now();
        System.out.println("Time now [UTC]: " + nowUtc);

        //local time
        ZonedDateTime nowLocalTimeZone = ZonedDateTime.now();
        System.out.println("Time now [local]: " + nowLocalTimeZone);

        //time in New York
        ZonedDateTime nowNewYork = ZonedDateTime.now(TimeZone.getTimeZone("America/New_York").toZoneId());
        System.out.println("Time now [New York]: " + nowNewYork);

    }
}
