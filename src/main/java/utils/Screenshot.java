package utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenxl on 2017/8/30.
 */

public class Screenshot {

    public static void takeScreenshot(AndroidDriver driver){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS") ;
        String date = simpleDateFormat.format(new Date()) ;
        String currentDir = System.getProperty("user.dir") ;
        File currentFile = new File(currentDir) ;
        File screenShot = driver.getScreenshotAs(OutputType.FILE) ;
        try {
            FileUtils.copyFile(screenShot,new File(currentFile,date + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}