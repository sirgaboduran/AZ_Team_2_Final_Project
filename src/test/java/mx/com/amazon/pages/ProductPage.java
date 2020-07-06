package mx.com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage
{
    public ProductPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "input[id='add-to-cart-button']")
    WebElement addToCartButton;

    @FindBy(id = "nav-cart")
    WebElement cart;

    @FindBy(id = "productTitle")
    WebElement productName;

    @FindBy(id = "price_inside_buybox")
    WebElement productPrice;

    @FindBy(id = "nav-cart-count")
    WebElement cartCount;
    
    @FindBy(css = ".a-size-medium.a-text-bold")
    WebElement addedToCart;

    public boolean isAtProductPage()
    {
        return addToCartButton.isDisplayed() && cart.isDisplayed();
    }
    

    public boolean addToCart()
    {
        int cartCounter = Integer.parseInt(cartCount.getText());
        addToCartButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addedToCart));
        return Integer.parseInt(cartCount.getText()) == cartCounter+1;
    }

    public void goToCart()
    {
        cart.click();
    }
}
