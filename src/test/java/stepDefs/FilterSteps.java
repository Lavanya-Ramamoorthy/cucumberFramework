package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.ResultsPage;

import java.util.List;

public class FilterSteps {
    HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();

    @And("I apply a filter by price {string}")
    public void iApplyAFilterByPrice(String price) throws InterruptedException {
        resultsPage.selectFilter(price);
    }

    @Then("I should see only the relevant product by {string}")
    public void i_should_see_only_the_relevant_product_by(String filter) {
        Assert.assertTrue(homePage.getUrl().contains(filter));
    }

    @Then("I should see only the relevant product by price {string}")
    public void iShouldSeeOnlyTheRelevantProductByPrice(String priceFilter) {
        resultsPage.getPricesForAllTheProducts();
        String[] priceInArray = priceFilter.split("-");
        Double min = Double.parseDouble(priceInArray[0].replace("£", ""));
        Double max = Double.parseDouble(priceInArray[1].replaceAll("£", ""));
        for (Double price : resultsPage.priceList) {
            Assert.assertTrue((price > min) && (price < max));
        }
    }
}
