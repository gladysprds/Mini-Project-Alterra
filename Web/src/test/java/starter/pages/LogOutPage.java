package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LogOutPage extends PageObject {

    private By iconLogout(){
            return By.xpath("//*[@type=\"button\"]/span[@class=\"v-btn__content\"]/i[@class=\"v-icon notranslate fas fa-user theme--dark\"]");
    }

    private By loginForm(){
        return By.className("v-card__title");
    }

    public void clickIconLogOut(){
        $(iconLogout()).click();
    }


    public boolean loginFormAppeared(){
        return $(loginForm()).isDisplayed();
    }


}
