package pages;

import drivers.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.UtilsHelper;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverFactory {

    public List<Double> priceList;

    public List<String> nameList;

    public String filterOption;
    public String expectedProduct;

    @FindBy(xpath = "/html/body/main/div[4]/sip-product-listing/div[2]/div/sip-product-search-results/div")
    private WebElement titleTxt;

    @FindBy(css = ".facet-text")
    private List<WebElement> filtersWebElement;

    @FindBy(css = ".product-price-amount")
    private List<WebElement> priceContainer;

    @FindBy(css = ".js-lister-name .notranslate")
    private List<WebElement> nameContainer;

    @FindBy(css = ".costco-select")
    private WebElement selectSort;

    public String getTitle() {
        return titleTxt.getText();
    }

    public void selectFilter(String filterOption) {
        this.filterOption = filterOption;
        for (WebElement filter : filtersWebElement) {
            if (filter.getText().equals(filterOption)) {
                filter.click();
                sleep(3000);
                break;
            }
        }
    }

    public List<Double> getPricesForAllTheProducts() {
        priceList = new ArrayList<Double>();
            for (WebElement price : priceContainer) {
                Double priceInDouble = Double.parseDouble(price.getText().replaceAll("[£,]", ""));
                priceList.add(priceInDouble);
            }
        return priceList;
    }

    public List<String> getNamesForAllTheProducts(){
        nameList = new ArrayList<String>();
        waitForElementsToBeVisible(nameContainer);
            for(WebElement name:nameContainer){
            nameList.add(name.getText());
        }
        return nameList;
    }

 public void selectASortOption(String option) {
        Select sort = new Select(selectSort);
        sort.selectByVisibleText(option);
          sleep(3000);
 }

 public String selectAnyProductFromTheList(){
        int randomNumber = new UtilsHelper().generateRandomNumber(getNamesForAllTheProducts().size());
       WebElement selectedProduct = nameContainer.get(randomNumber);
        expectedProduct = selectedProduct.getText();
        selectedProduct.click();
        return expectedProduct;
 }
}
