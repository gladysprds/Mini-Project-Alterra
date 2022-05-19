package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utils.General;

import java.io.FileWriter;
import java.io.IOException;


public class RegisterPage extends BasePageObject {
    General general = new General();
    String input;

    By registerLink(){
        return By.xpath("//android.widget.Button[@content-desc=\"Register\"]");
    }

    By registerText(){
        return By.xpath("//android.view.View[@content-desc=\"Register\"]");
    }

    By fieldFullName(){
        return By.xpath("//android.widget.EditText[1]");
    }

    By fieldEmail(){
        return By.xpath("//android.widget.EditText[2]");
    }

    By fieldPassword(){
        return By.xpath("//android.widget.EditText[3]");
    }

    By registerButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Register\"]");
    }

    public void validateRegisterFormAppeared() throws InterruptedException {
        Assertions.assertTrue(isDisplayed(registerText()));
        Thread.sleep(3000);
    }

    public void clickRegisterLink() throws InterruptedException {
       Thread.sleep(3000);
       click(registerLink());
    }


    public void inputFullname(String input) throws InterruptedException {
        click(fieldFullName());
        Thread.sleep(3000);
        sendKeys(fieldFullName(),input);

    }

    public void inputEmail(String input) throws InterruptedException {
        click(fieldEmail());
        if (input.equals("same")){
            this.input = "sonyaprds@gmail.com";
        } else{
            this.input = general.randomEmail();
            try (FileWriter file = new FileWriter("src//main//resources//filejson//email.json")) {
                file.write(this.input);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(5000);
        sendKeys(fieldEmail(),this.input);
    }

    public void inputPassword(String input) throws InterruptedException {
        click(fieldPassword());
        Thread.sleep(3000);
        sendKeys(fieldPassword(),input);
    }

    public void clickButtonRegister(){
        click(registerButton());
    }













}
