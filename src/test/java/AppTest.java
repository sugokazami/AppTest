import functions.Normal;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import utils.Screenshot;
import init.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;





/**
 * Created by chenxl on 2017/7/27.
 */

public class AppTest {

    private AndroidDriver driver ;

    @BeforeClass
    public void setUp() throws Exception {
            driver = Driver.getAndroidDriver() ;
    }

    @org.testng.annotations.Test
    public void test(){
            Normal.login();
            Normal.gesTure();
            Screenshot.takeScreenshot(driver);
            Assert.assertEquals("failure：not this screen", LoginPage.HOME_ACTIVITY,driver.currentActivity());
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}