package java.com.example.app.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverInit {
    public static AndroidDriver<AndroidElement> driver;

    public static void initialize(){

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("AutomationName", "UIAutomator2");
        caps.setCapability("unicodeKeyboard",true);
        caps.setCapability("app", "C:\\Users\\ASUS\\Downloads\\alta-online-shop.apk");

        try{
            driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void quit(){
        driver.quit();//hapus session

    }

}

