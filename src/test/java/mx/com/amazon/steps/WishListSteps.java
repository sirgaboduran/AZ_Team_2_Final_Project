package mx.com.amazon.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mx.com.amazon.hooks.Hooks;
import mx.com.amazon.sites.AmazonSite;
import mx.com.amazon.utils.Properties;

import static org.junit.Assert.assertTrue;

public class WishListSteps
{
    AmazonSite amazonSite;

    public WishListSteps(Hooks hooksClass)
    {
        this.amazonSite = hooksClass.getAmazonSite();
    }

    @When("I click the link to create a wish list")
    public void clickWishListLink()
    {
        amazonSite.home().clickWishList();
    }

    @Then("I will create a wish list")
    public void createWishList()
    {
        amazonSite.home().createWishList(Properties.WISH_LIST);
        assertTrue("User is at Wish List Page",amazonSite.wishlist().isAtWishListPage());
    }
    
    @And("Verify it was created")
    public void verifyItWasCreated()
    {
        assertTrue("Verified product was added to cart successfully",amazonSite.wishlist().verifyWishListCreated(Properties.WISH_LIST));
    }
}
