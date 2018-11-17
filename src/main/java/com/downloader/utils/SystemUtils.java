package com.downloader.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liukai
 * @time: 2018/11/17
 */
public class SystemUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUtils.class);

    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static String system(){
        return OS;
    }


    public static void main(String[] args) {
        system();
    }
}

