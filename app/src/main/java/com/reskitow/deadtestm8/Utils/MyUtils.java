package com.reskitow.deadtestm8.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyUtils {

    public String modificarVista(String formato, Calendar cal) {
        return (new SimpleDateFormat(formato).format(cal.getTime()));
    }

}
