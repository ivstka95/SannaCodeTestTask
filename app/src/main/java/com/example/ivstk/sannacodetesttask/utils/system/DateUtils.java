package com.example.ivstk.sannacodetesttask.utils.system;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Created by Ivan on 28-Nov-17.
 */

public class DateUtils {
    public static final String TIME_STAMP_FORMAT = "dd.MM.yyyy HH:mm:ss";

    public static final String TIME_FORMAT = "HH:mm";

    public static final String DAY_FORMAT = "dd.MM";


    public static String getLocalDateStamp() {
        String local;
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_STAMP_FORMAT);
        Calendar calendar1 = new GregorianCalendar();
        //Correct! need formatter
        local = sdf.format(calendar1.getTime());
        return local;
    }

    public static String getDateFromTimestamp(DateTime dateTime) {
        return dateTime.toString(DateTimeFormat.forPattern(DAY_FORMAT));
    }

    public static String formatTimestamp(DateTime dateTime, String format) {
        return dateTime.toString(DateTimeFormat.forPattern(format));
    }

    public static String getTimeFromTimestamp(DateTime dateTime) {
        return dateTime.toString(DateTimeFormat.forPattern(TIME_FORMAT));
    }
}
