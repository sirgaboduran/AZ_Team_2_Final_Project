package mx.com.amazon.hooks;

import java.util.concurrent.TimeUnit;

import mx.com.amazon.sites.AmazonSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static mx.com.amazon.utils.Properties.SHORT_WAIT;

public class Hooks
{

    public WebDriver driver;

    public AmazonSite amazonSite;

    @Before
    public void before()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(SHORT_WAIT, TimeUnit.SECONDS);

        amazonSite = new AmazonSite(driver);
    }

    @After
    public void after()
    {
        driver.quit();
    }

    public WebDriver getWebDriver()
    {
        return driver;
    }

    public AmazonSite getAmazonSite()
    {
        return amazonSite;
    }

}
