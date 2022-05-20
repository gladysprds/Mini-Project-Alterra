package com.example.app.pages;

import com.example.app.base.BasePageObject;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.example.app.driver.AndroidDriverInit.driver;


public class LoginPage extends BasePageObject {


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

    By errorMessagePasswordNull(){
        return By.xpath("//android.view.View[@content-desc=\"password can not empty\"]");
    }

    By errorMessageEmailNull() {
        return By.xpath("//android.view.View[@content-desc=\"email can not empty\"]");
    }


    public void validateloginTextAppeared(){
        Assertions.assertTrue(isDisplayed(loginText()));
    }

    public void inputEmail(String input)throws Exception{
        click(fieldEmail());
        Thread.sleep(3000);
        sendKeys(fieldEmail(),input);
    }

    public void inputPassword(String input)throws Exception{
        click(fieldPassword());
        Thread.sleep(3000);
        sendKeys(fieldPassword(),input);
    }

    public void clickButtonLogin(){
        AndroidElement buttonLogin = driver.findElement(buttonLogin());
        buttonLogin.click();

    }


    public void displayErrorEmailNull(){
        Assertions.assertTrue(isDisplayed(errorMessageEmailNull()));
    }

    public void displayErrorPasswordNull(){
        Assertions.assertTrue(isDisplayed(errorMessagePasswordNull()));
    }

    public void displayErrorBothEmailAndPassword(){
        Assertions.assertTrue(isDisplayed(errorMessageEmailNull()));
        Assertions.assertTrue(isDisplayed(errorMessagePasswordNull()));
    }

    }



