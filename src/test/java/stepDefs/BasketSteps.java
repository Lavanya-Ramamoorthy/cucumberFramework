package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PageDescriptionPage;
import pages.HomePage;
import pages.ResultsPage;

public class BasketSteps {

    HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();
    PageDescriptionPage basketPage = new PageDescriptionPage();

    String actualProduct;

    @When("select any product from the list")
    public void select_any_product_from_the_list() {
      resultsPage.selectAnyProductFromTheList();
    }

    @And("I add product to basket")
    public void i_add_product_to_basket() throws InterruptedException {
         basketPage.AddToBasket();
    }

    @And("I go to basket")
    public void i_go_to_basket() {
       basketPage.goToBasket();
    }

    @Then("I should see the selected product in the basket")
    public void i_should_see_the_selected_product_in_the_basket() throws InterruptedException {
       String expected = resultsPage.expectedProduct;
        actualProduct = basketPage.getNameOfTheProductFromBasket();
        Assert.assertTrue(expected.equals(actualProduct));
    }

}
