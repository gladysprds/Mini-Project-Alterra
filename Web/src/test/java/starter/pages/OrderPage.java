package starter.pages;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class OrderPage extends PageObject {


    private By iconCart(){
        return By.xpath("//*[@type=\"button\"]/span[@class=\"v-btn__content\"]/span[@class=\"v-badge v-badge--bottom v-badge--left v-badge--overlap theme--dark\"]/i[@class=\"v-icon notranslate fas fa-shopping-cart theme--dark\"]");
    }

    private By buttonBeli(){
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6'][1]//span[text() = 'Beli']");
    }

    private By product(){
        return By.xpath("//*[@class = 'v-list-item__icon']//*[@id='label-total-quantity']/text()");
    }

    private By addButton(){
        return By.xpath("//*[span[text()='+']]");
    }

    private By minusButton(){
        return By.xpath("//*[span[text()='-']]");
    }

    private By qtyProduct(){
        return By.id("label-total-quantity");
    }

    private By errorMessageEmpty(){
        return By.className("v-alert__content");
    }


    @Step
    public void openUrl(){
        openUrl("https://qa.alta.id/");
    }

    @Step
    public void clickButtonBeli(){
        $(buttonBeli()).click();
    }

    @Step
    public void clickIconCart(){
        $(iconCart()).click();
    }

    @Step
    public void validateProduct(){
        $(product()).equals("1");
    }

    @Step
    public void clickButtonAdd(){
        $(addButton()).click();
    }

    @Step
    public boolean validateQtyProduct(String text) {
        return $(qtyProduct()).getText().equals(text);
    }

    @Step
    public void clickButtonMinus(){
        $(minusButton()).click();
    }

    @Step
    public boolean errorMessageDisplayed(String errorAlert){
        return $(errorMessageEmpty()).getText().equals(errorAlert);
    }




}
