package stepDefs;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
     DriverFactory driverFactory = new DriverFactory();
    @Before
    public void setup(){
        driverFactory.openBrowser();
        driverFactory.navigateToUrl();
        driverFactory.applyImplicitWait();
        driverFactory.maximizeWindow();
        driverFactory.handlePrivacyMessage();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            driverFactory.embedScreenshot(scenario);
        }
      driverFactory.closeBrowser();
    }

}
