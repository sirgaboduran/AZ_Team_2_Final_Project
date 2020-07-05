package mx.com.amazon.pages;

import mx.com.amazon.utils.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id = "priceblock_ourprice")
    WebElement productPrice;

    @FindBy(id = "nav-cart-count")
    WebElement cartCount;

    public boolean isAtProductPage()
    {
        return addToCartButton.isDisplayed() && cart.isDisplayed();
    }

    public void storeProductInformation(Product productSelected)
    {
        productSelected.setName(productName.getText());
        productSelected.setPrice(Double.parseDouble(productPrice.getText().substring(1)));
    }

    public boolean addToCart()
    {
        int cartCounter = Integer.parseInt(cartCount.getText());
        addToCartButton.click();
        return Integer.parseInt(cartCount.getText()) == cartCounter+1;
    }

    public void goToCart()
    {
        cart.click();
    }
}
