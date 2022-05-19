package java.com.example.app.pages;
import java.com.example.app.base.BasePageObject;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static java.com.example.app.driver.AndroidDriverInit.driver;


public class LoginPage extends BasePageObject{

    By homePageText(){
        return By.xpath("//android.view.View[@content-desc=\"Products\"]");
    }

    By iconAccount(){
        return By.xpath("//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }

    By loginText(){
        return By.xpath("//android.view.View[@content-desc=\"Login\"]");
    }

    By fieldEmail(){
        return By.xpath("//android.widget.EditText[1]");
    }

    By fieldPassword(){
        return By.xpath("//android.widget.EditText[2]");
    }

    By buttonLogin(){
        return By.xpath("//android.widget.Button[@content-desc=\"Login\"]");
    }

    public void validateHomePageAppear(){
        Assertions.assertTrue(isDisplayed(homePageText()));
    }

    public void clickIconAccount(){
        click(iconAccount());
    }

    public void validateloginTextAppeared(){
        Assertions.assertTrue(isDisplayed(loginText()));
    }

    public void inputEmail(String input)throws Exception{
        Thread.sleep(3000);
        sendKeys(fieldEmail(),input);
    }

    public void inputPassword(String input)throws Exception{
        Thread.sleep(3000);
        sendKeys(fieldPassword(),input);
    }

    public void clickButtonLogin(){
        AndroidElement buttonLogin = driver.findElement(buttonLogin());
        buttonLogin.click();
    }


}
