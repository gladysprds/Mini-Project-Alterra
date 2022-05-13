package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class TransactionPage extends PageObject {

    private By buttonBayar(){
        return By.xpath("//*[span[text()=' Bayar ']]");
    }

    private By transPageHeader(){
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/h1");
    }


    @Step
    public void openUrl(){
        openUrl("https://qa.alta.id/");
    }

    @Step
    public void clickButtonBayar(){
        $(buttonBayar()).click();
    }

    @Step
    public void validateTransHeader(){
        $(transPageHeader()).isDisplayed();
    }




}
