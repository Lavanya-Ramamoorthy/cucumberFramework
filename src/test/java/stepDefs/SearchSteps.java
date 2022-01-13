package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.HomePage;
import pages.ResultsPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSteps {

HomePage homePage = new HomePage();
ResultsPage resultsPage = new ResultsPage();

    @Given("I am on homepage")
    public void i_am_on_homepage() {
        assertThat(homePage.getUrl(), Matchers.endsWith("co.uk/"));
    }

    @When("I search for a product {string}")
    public void i_search_for_a_product(String product) {
        homePage.doSearch(product);
    }

    @Then("I should see only the relevant product {string}")
    public void i_should_see_only_the_relevant_product(String product) {
                if (resultsPage.getTitle().contains(product)) {
        }
        }
}





