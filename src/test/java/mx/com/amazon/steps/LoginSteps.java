package mx.com.amazon.steps;

import cucumber.api.java.en.And;
import mx.com.amazon.hooks.Hooks;
import mx.com.amazon.sites.AmazonSite;
import mx.com.amazon.utils.Properties;

import static org.junit.Assert.assertTrue;

public class LoginSteps
{
    AmazonSite amazonSite;

    public LoginSteps(Hooks hooksClass)
    {
        this.amazonSite = hooksClass.getAmazonSite();
    }

    @And("I login to the Amazon site")
    public void loginToAmazon()
    {
        amazonSite.home().clickLogin();

        amazonSite.login().isAtLoginPage();
        amazonSite.login().enterUserName(Properties.EMAIL);
        amazonSite.login().clickContinue();
        amazonSite.login().enterPassword(Properties.PASSWORD);
        amazonSite.login().clickSignIn();

        assertTrue("User has logged in successfully",amazonSite.home().isAtHomePage());
    }
}
