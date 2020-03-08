/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *  
 */
public class Utils {
    public static String getDataDir(Class c) {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");
        
        return dir.toString() + File.separator;
    }

    public static String GetDataDir_AI() {
        File dir = getResourcesDir();
        dir = new File(dir, "AI");

        return dir.toString() + File.separator;
    }

    public static String GetDataDir_PSD() {
        File dir = getResourcesDir();
        dir = new File(dir, "PSD");

        return dir.toString() + File.separator;
    }

    public static String GetDataDir_Output() {
        File dir = getResourcesDir();
        dir = new File(dir, "1_Output");

        return dir.toString() + File.separator;
    }

    public static File getResourcesDir() {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");

        return dir;
    }
    
    public static Date getDateTime() {
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       Date date = new Date();
        
        return date;
    }
}
