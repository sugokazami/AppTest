package utils;

import java.io.*;

/**
 * Created by chenxl on 2017/8/31.
 */

public class CommandUtils {
    public static synchronized String runCMD(String[] command){
        StringBuilder result = new StringBuilder() ;
        String line ;
        Process process = null ;
        BufferedReader in = null ;
        BufferedReader err = null ;

        try {
            process = Runtime.getRuntime().exec(command) ;
            in = new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk")) ;
            err = new BufferedReader(new InputStreamReader(process.getErrorStream(),"gbk")) ;
            while ((line=in.readLine())!=null){
                result.append(line).append("\r\n");
            }
            while ((line=err.readLine())!=null){
                result.append(line).append("\r\n") ;
            }
            process.waitFor() ;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != in  && null != err){
                    in.close();
                    err.close();
                    process.destroy();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString() ;
    }

    public static String getDeviceName(){
        String sn = runCMD(new String[]{"adb","devices"}).split("\n")[1].split("\t")[0] ;
        return  sn ;
    }

    public static String getpkgName(){
        String local = StringUtils.getPackageName("package") ;
        String apkInfo = runCMD(new String[]{"aapt","dump","badging",local}) ;
        String pkgStart = "package: name='" ;
        return apkInfo.substring(apkInfo.indexOf("package: name='") + pkgStart.length(),apkInfo.indexOf("' versionCode"));
    }

    public static String getActivityName(){
        String local = StringUtils.getPackageName("package") ;
        String apkInfo = runCMD(new String[]{"aapt","dump","badging",local}) ;
        String activityStart = "launchable-activity: name='" ;
        return apkInfo.substring(apkInfo.indexOf(activityStart) + activityStart.length(),apkInfo.indexOf("'  label=''")) ;
    }
}

