package functions;

import init.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenxl on 2017/8/30.
 */

public class Normal {

    private  static AndroidDriver driver = Driver.getAndroidDriver() ;

    public static void login() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS) ;
        //Thread.sleep(5000);
        //driver.findElement(By.id("tv_view_detail")).click();
        //driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS) ;
        //driver.startActivity("com.tzj.debt",".page.user.auth.LoginActivity");
        driver.findElement(By.id("personal_logo")).click();
        driver.findElement(By.id("enter_account")).click();

        //用户登录
        driver.findElement(By.id("username")).clear() ;
        driver.findElement(By.id("username")).sendKeys("13072759893");
        driver.findElement(By.id("password")).sendKeys("cxl111111");
        driver.findElement(By.id("user_login")).click();

    }

    public static void gesTure() {
//        设置手势密码
        List<WebElement> imageViews = driver.findElements(By.className("android.widget.ImageView")) ;
        TouchAction touchAction = new TouchAction(driver) ;
        touchAction.press(imageViews.get(0)).moveTo(imageViews.get(3)).moveTo(imageViews.get(6)).moveTo(imageViews.get(7)).moveTo(imageViews.get(8)).release().perform() ;
        try {
            Thread.sleep(2000);
            touchAction.press(imageViews.get(0)).moveTo(imageViews.get(3)).moveTo(imageViews.get(6)).moveTo(imageViews.get(7)).moveTo(imageViews.get(8)).release().perform() ;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
