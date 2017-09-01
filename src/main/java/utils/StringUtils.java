package utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by chenxl on 2017/8/31.
 */

public class StringUtils {

    public static final String extensionName = ".properties" ;

    public static String getPackageName(String file){
        Properties properties = new Properties() ;
        InputStream inputStream = StringUtils.class.getClassLoader().getResourceAsStream(file + extensionName) ;
        try {
            properties.load(inputStream);
            return properties.getProperty("packageName") ;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null ;
    }
}
