package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageDescriptionPage extends DriverFactory {

    @FindBy(css="#chkoutBtn")
    private WebElement checkOutBtn;

    @FindBy(css = ".name")
    private WebElement nameContainerInBasket;

    @FindBy(css = "#addToCartPopupCheckoutBtn")
    private WebElement viewBasketBtn;

    @FindBy(css="button[id*=addToCartButton]")
    private WebElement addToBasketBtn;

    public String getNameOfTheProductFromBasket(){
       return nameContainerInBasket.getText();
    }

    public void goToBasket(){
            viewBasketBtn.click();
    }

    public void AddToBasket() {
        addToBasketBtn.click();
    }
}
