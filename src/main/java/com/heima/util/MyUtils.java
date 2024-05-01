package com.heima.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyUtils {

    /**
     * 獲取現在時間: yyyy-MM-dd HH:mm:ss格式字串
     * @return
     */
    public static String getNow(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(formatter);
    }
}
