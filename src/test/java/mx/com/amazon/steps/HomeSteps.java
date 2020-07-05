package mx.com.amazon.steps;

import cucumber.api.java.en.When;
import mx.com.amazon.hooks.Hooks;
import mx.com.amazon.sites.AmazonSite;
import static org.junit.Assert.assertTrue;

public class HomeSteps
{
    AmazonSite amazonSite;

    public HomeSteps(Hooks hooksClass)
    {
        this.amazonSite = hooksClass.getAmazonSite();
    }

    @When("I navigate to Home Page")
    public void navigateToHomePage()
    {
        amazonSite.home().goToHomePage();
        assertTrue("User is at Home Page",amazonSite.home().isAtHomePage());
    }


}
