package mx.com.amazon.sites;

import mx.com.amazon.pages.*;
import org.openqa.selenium.WebDriver;

public class AmazonSite
{
    private HomePage home;
    private LoginPage login;
    private CartPage cart;
    private ProductPage product;
    private ResultsPage results;
    private WishlistPage wishlist;
    private WebDriver driver;

    public AmazonSite(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage home()
    {
        if(home == null)
        {
            return new HomePage(driver);
        }
        return home;
    }

    public LoginPage login()
    {
        if(login == null)
        {
            return new LoginPage(driver);
        }
        return login;
    }

    public CartPage cart()
    {
        if(cart == null)
        {
            return new CartPage(driver);
        }
        return cart;
    }

    public ProductPage product()
    {
        if(product == null)
        {
            return new ProductPage(driver);
        }
        return product;
    }

    public ResultsPage results()
    {
        if(results == null)
        {
            return new ResultsPage(driver);
        }
        return results;
    }

    public WishlistPage wishlist()
    {
        if(wishlist == null)
        {
            return new WishlistPage(driver);
        }
        return wishlist;
    }
}
