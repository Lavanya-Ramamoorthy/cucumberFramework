package drivers;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;
    public String browser = System.getProperty("browser");

    public String url = System.getProperty("url");

   public static WebDriverWait wait;

   public DriverFactory() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser name");
        }
    }

    public void navigateToUrl() {
         driver.get(url);
    }

    public void applyImplicitWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.quit();
    }


    public void embedScreenshot(Scenario scenario) {
        try {
            String screenshotName = scenario.getName();
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        } catch (WebDriverException e) {
            System.out.println("Error taking screenshot");
        }
    }

    public WebElement waitForElementToBeClickable(WebElement element){
       wait= new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.elementToBeClickable(element));
       return element;
    }

    public List<WebElement> waitForElementsToBeVisible(List<WebElement> element){
       wait = new WebDriverWait(driver,30);
       wait.until(ExpectedConditions.visibilityOfAllElements(element));
       return element;
    }

    public void handlePrivacyMessage() {
        if (driver.findElement(By.cssSelector("#gdprMessage")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"gdprMessage\"]/div/div[2]/button[1]")).click();
        }
    }

    public void scrollPage(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,100)");
    }

    public void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}