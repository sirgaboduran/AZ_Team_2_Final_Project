package mx.com.amazon.pages;

import mx.com.amazon.utils.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage
{
    public CartPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    
    @FindBy(className = "sc-list-item-content")
    List<WebElement> cartProducts;
    
    String productNameLocator = "a-size-medium sc-product-title a-text-bold";

    String productPriceLocator = "a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign sc-product-price a-text-bold";
    
    
    public boolean isAtCartPage()
    {
        return cartProducts.size() > 0;
    }
    
    public boolean verifyProduct(Product productSelected)
    {
        for(WebElement cartProduct : cartProducts )
        {
            if (cartProduct.findElement(By.className(productNameLocator)).getText().equals(productSelected.getName())
                    && Double.parseDouble(cartProduct.findElement(By.className(productPriceLocator)).getText().substring(1)) == productSelected.getPrice())
                return true;
        }
        return false;
    }
}
