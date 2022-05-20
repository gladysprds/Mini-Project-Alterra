package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage extends BasePageObject {
    By homePageText(){
        return By.xpath("//android.view.View[@content-desc=\"Products\"]");
    }

    By iconAccount(){
        return By.xpath("//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }
    public void validateHomePageAppear()throws Exception{
        Assertions.assertTrue(isDisplayed(homePageText()));
        click(homePageText());
        Thread.sleep(3000);
    }


    public void clickIconAccount(){
        click(iconAccount());
    }
}
