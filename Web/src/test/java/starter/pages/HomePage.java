package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    private By homePageText(){
        return By.className("v-toolbar__title");
    }

    @Step
    public boolean homePageAppear(){
        return $(homePageText()).isDisplayed();
    }
}
