package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ResultsPage;

import java.util.Collections;
import java.util.List;

public class SortSteps {
    ResultsPage resultsPage = new ResultsPage();

    List<Double> priceBeforeFilter;
    List<String> namesBeforeFilter;

    @And("I choose a sort option {string}")
    public void i_choose_a_sort_option(String sortOption) {
        if(sortOption.contains("Price")){
            priceBeforeFilter = resultsPage.getPricesForAllTheProducts();
            resultsPage.selectASortOption(sortOption);
        } else if(sortOption.contains("Name")){
            namesBeforeFilter = resultsPage.getNamesForAllTheProducts();
            resultsPage.selectASortOption(sortOption);
        }
    }

    @Then("I should see only the relevant product according to the sort {string}")
    public void iShouldSeeOnlyTheRelevantProductAccordingToTheSort(String sort) {
        List<Double> priceAfterFilter = resultsPage.getPricesForAllTheProducts();
        List<String> namesAfterFilter = resultsPage.getNamesForAllTheProducts();
        switch(sort){
            case"Price - Low to High":
                Collections.sort(priceBeforeFilter);
                break;
            case"Price - High to Low":
               Collections.sort(priceBeforeFilter,Collections.reverseOrder());
                break;
            case"Name - A-Z":
                Collections.sort(namesBeforeFilter);
                break;
            case"Name - Z-A":
                Collections.sort(namesBeforeFilter,Collections.reverseOrder());
                break;
        }
        if(sort.contains("Price")){
            Assert.assertEquals(priceBeforeFilter,priceAfterFilter);
        } else if(sort.contains("Name")){
            Assert.assertEquals(namesBeforeFilter,namesAfterFilter);
        }
    }
}
