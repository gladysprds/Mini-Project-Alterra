package com.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.com.example.app.driver.AndroidDriverInit;

public class AndroidHooks {

    @Before
    public void before(){
        AndroidDriverInit.initialize();
    }


    @After
    public void afterDriver(Scenario scenario) {
        if (scenario.isFailed()){
            TakesScreenshot screenshot = AndroidDriverInit.driver;
            byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(imageByte, "image/png", scenario.getId());
        }
        AndroidDriverInit.quit();
    }
}
