package mx.com.amazon.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mx.com.amazon.hooks.Hooks;
import mx.com.amazon.sites.AmazonSite;
import mx.com.amazon.utils.Properties;

import static org.junit.Assert.assertTrue;

public class AddToCartSteps
{
    AmazonSite amazonSite;

    public AddToCartSteps(Hooks hooksClass)
    {
        this.amazonSite = hooksClass.getAmazonSite();
    }

    @When("I search for an product")
    public void searchArticle()
    {
        amazonSite.home().typeInSearchBox(Properties.PRODUCT);
        amazonSite.home().clickSearch();

        assertTrue("User is at Results Page",amazonSite.results().isAtResultsPage());
    }

    @And("I select the product")
    public void selectArticle()
    {
        amazonSite.results().selectProduct();

        assertTrue("User is at Product Page",amazonSite.product().isAtProductPage());
    }

    @Then("I will add the product to the cart")
    public void addToCart()
    {
        amazonSite.product().isAtProductPage();
        assertTrue("Product has been added to cart",amazonSite.product().addToCart());
    }
    
}
