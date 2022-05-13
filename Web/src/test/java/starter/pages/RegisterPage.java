package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import utils.General;

import java.io.FileWriter;
import java.io.IOException;

public class RegisterPage extends PageObject {
    General general = new General();
    String name;
    String email;

    private By registerAppeared(){
        return By.className("v-card__title");
    }
    private By iconAccount(){
        return By.xpath("//*[@type=\"button\"]/span[@class=\"v-btn__content\"]/i[@class=\"v-icon notranslate fas fa-sign-in theme--dark\"]");
    }

    private By namaLengkapField(){
        return By.xpath("//*[label[text() = 'Nama Lengkap']]/input");
    }

    private By emailField(){
        return By.xpath("//*[label[text() = 'Email']]/input");
    }

    private By passwordField(){
        return By.xpath("//*[label[text() = 'Password']]/input");
    }

    private By registerButton(){
        return By.xpath("//*[span[text()='Register']]");
    }

    private By errorMessage(){
        return By.className("v-alert__content");
    }

    private By iconAlert(){
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div[2]/div[1]/div/i");
    }


    @Step
    public void openUrl(){
        openUrl("https://qa.alta.id/");
    }

    @Step
    public void clickIconAccount(){
        $(iconAccount()).click();
    }

    @Step
    public void openAppregister(){
        openUrl("https://qa.alta.id/auth/register");
    }

    @Step
    public void inputNama(String name){
        if (name.equals("same")){
            this.name = "sonyaprds";
        } else{
            this.name = general.randomUsername();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//name.json")) {
                file.write(this.name);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        $(namaLengkapField()).type(name);
    }

    @Step
    public void inputEmail(String email){
        if (email.equals("same")){
            this.email = "sonyaprds@gmail.com";
        } else{
            this.email = general.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")) {
                file.write(this.email);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        $(emailField()).type(email);
    }

    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);

        $(passwordField()).type(password);
    }

    @Step
    public void clickButtonRegister(){
        $(registerButton()).click();
    }

    @Step
    public void validateRegisFormApp(){
        $(emailField()).isDisplayed();
    }

    @Step
    public void displayErrorMessage(String alert){
        if(alert=="email is required"){
            $(errorMessage()).isDisplayed();
        }
        else if(alert=="Password is required"){
            $(errorMessage()).isDisplayed();
        }
        else if(alert=="fullname is required"){
            $(errorMessage()).isDisplayed();
        }
        else if(alert=="ERROR: duplicate key value violates unique constraint \"users_email_key\" (SQLSTATE 23505)\n"){
            $(errorMessage()).isDisplayed();
        }else{
            $(iconAlert()).isDisplayed();
        }




    }








}
