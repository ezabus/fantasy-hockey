package org.zabus.fantasy.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 21.09.2015.
 */
public class DateUtils {

    public static void main(String argsp[])
    {
       System.out.println(getTimestampValue("2015/10/19"));

    }

    public static String getYesterdayDate()
    {
        Date date = new Date();
        DateTime dt = new DateTime(date);
        dt = dt.minusDays(1);
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        return dateFormatter.print(dt);
    }

    public static String getTodayDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        //System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }

    public static String getLastMonday()
    {
        LocalDate now = new LocalDate();
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        return dateFormatter.print(now.withDayOfWeek(DateTimeConstants.MONDAY));
    }

    public static Set<String> getMondaySet()
    {
        DateTime startDate = new DateTime(2015, 9, 28, 0, 0);
        Date date = new Date();
        DateTime endDate = new DateTime(date);
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        HashSet<String> mondaySet = new HashSet<String>();
        while (startDate.isBefore(endDate)) {
            mondaySet.add(dateFormatter.print(startDate));
            startDate = startDate.plusWeeks(1);
        }
        return mondaySet;
    }

    public static int getYear()
    {
        //LocalDateTime now = LocalDateTime.now();
        DateTime dt = new DateTime();
        return dt.getYear();
    }

    public static void getMonthDateRange(int month)
    {
        LocalDate endOfLastMonth = new LocalDate(getYear(),month,1);
        endOfLastMonth = endOfLastMonth.minusDays(1);
        LocalDate startOfNextMonth = new LocalDate(getYear(),month,1);
        startOfNextMonth = startOfNextMonth.plusMonths(1);
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        System.out.println(dateFormatter.print(endOfLastMonth));
        System.out.println(dateFormatter.print(startOfNextMonth));
    }

    public static String getFirstDayOfMonth(int month)
    {
        LocalDate startOfMonth = new LocalDate(getYear(), month, 1);
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        return dateFormatter.print(startOfMonth);
    }

    public static String getLastDayOfMounth(int month)
    {
        LocalDate startOfNextMonth = new LocalDate(getYear(),month,1);
        startOfNextMonth = startOfNextMonth.dayOfMonth().withMaximumValue();
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        //System.out.println(dateFormatter.print(startOfNextMonth));
        return dateFormatter.print(startOfNextMonth);
    }

    public static String getLastDayOfLastMonth(int month)
    {
        LocalDate endOfLastMonth = new LocalDate(getYear(),month,1);
        endOfLastMonth = endOfLastMonth.minusDays(1);
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        //System.out.println(dateFormatter.print(endOfLastMonth));
        return dateFormatter.print(endOfLastMonth);
    }

    public static String getWeekRange(String dateCode)
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        DateTimeFormatter outformatter = DateTimeFormat.forPattern("dd.MM");
        DateTime endWeek = formatter.parseDateTime(dateCode);
        DateTime startWeek = endWeek.minusDays(6);
        return outformatter.print(startWeek) + "-" + outformatter.print(endWeek);
    }

    public static long getTimestampValue(String dateCode)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateCode);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return ts.getTime();
    }
}
