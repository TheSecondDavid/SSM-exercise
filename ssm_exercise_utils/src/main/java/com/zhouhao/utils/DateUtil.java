package com.zhouhao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String DateToStr(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
