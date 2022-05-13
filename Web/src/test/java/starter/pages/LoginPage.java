package starter.pages;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private By iconLogin(){
        return By.xpath("//*[@type=\"button\"]/span[@class=\"v-btn__content\"]/i[@class=\"v-icon notranslate fas fa-sign-in theme--dark\"]");
    }
    private By fieldUsername(){
        return By.xpath("//*[label[text() = 'Email']]/input");
    }
    private By fieldPassword(){
        return By.xpath("//*[label[text() = 'Password']]/input");
    }

    private By buttonLogin(){
        return By.xpath("//*[span[text()='Login']]");
    }

    private By loginAppeared(){
        return By.className("v-card__title");
    }

    private By errorMessageAlert(){
        return By.className("v-alert__content");
    }

    @Step
    public void openUrl(){
        openUrl("https://qa.alta.id/");
    }
    @Step
    public void clickIconLogin(){
        $(iconLogin()).click();
    }

    @Step
    public void inputUsername(String username){
        $(fieldUsername()).type(username);
    }

    @Step
    public void inputPassword(String password){
        $(fieldPassword()).type(password);
    }

    @Step
    public void clickLogin(){
        $(buttonLogin()).click();
    }

    @Step
    public void validateLoginApp(){
        $(loginAppeared()).isDisplayed();
    }


    @Step
    public void displayErrorMessage(String alert){
        if(alert=="email is required"){
            $(errorMessageAlert()).isDisplayed();
        }
        else if(alert=="password is required"){
            $(errorMessageAlert()).isDisplayed();
        }
        else if(alert=="record not found"){
            $(errorMessageAlert()).isDisplayed();
        }

    }
}
