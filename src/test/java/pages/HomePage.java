package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends DriverFactory {

    @FindBy(css = "div[id='searchBoxContainer'] input[placeholder='Search Costco']")
    private WebElement searchTxtBx;

    @FindBy(css = "div[id='searchBoxContainer'] span[class='search-icon']")
    private WebElement searchMagnifyButton;

    public void doSearch(String product) {
        searchTxtBx.sendKeys(product);
        searchMagnifyButton.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

   }
