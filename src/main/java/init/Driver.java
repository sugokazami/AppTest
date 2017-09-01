package init;

import base.AndroidMobileCapabilityType;
import base.MobileCapabilityType;
import utils.CommandUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chenxl on 2017/8/30.
 */

public class Driver {

    private static AndroidDriver androidDriver ;

    static {

        DesiredCapabilities capabilities = new DesiredCapabilities() ;
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium") ;

        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName", CommandUtils.getDeviceName());

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4.4");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,CommandUtils.getpkgName());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,CommandUtils.getActivityName());

        try {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities) ;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver getAndroidDriver() {
        return androidDriver;
    }
}
