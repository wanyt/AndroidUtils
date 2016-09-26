package com.wanyt.androidutils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2016/9/24 13:54
 * <p>
 * author wang
 * <p>
 * Description:
 */

public class UtilsDate {

    /**
     * 获取格式化的时间，如果传入的date为null，那么获取的是当前时间
     *
     * @param date   时间
     * @param format 想要获取的时间格式
     *               "yyyy-MM-dd"
     *               "yyyy-MM-dd HH:mm"
     *               "yyyy-MM-dd HH:mmZ"
     *               "yyyy-MM-dd HH:mm:ss.SSSZ"
     *               "yyyy-MM-dd 'T' HH:mm:ss.SSSZ"
     * @return 格式化的时间
     */
    public static String getFormattedDateYMD(Date date, String format) {
        if (date == null) {
            date = new Date();
        }
        String currentDate = new SimpleDateFormat(format).format(date.getTime());
        return currentDate;
    }

    /**
     * 把字符串转化成时间
     *
     * @param strdate 时间字符串
     * @param formate 时间格式
     * @return Date
     */
    public static Date stringToDate(String strdate, String formate) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formate);
        try {
            date = simpleDateFormat.parse(strdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
