package mx.com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "a-row sc-list-item sc-list-item-border sc-java-remote-feature")
    WebElement carItems;

    @FindBy(className = "a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold")
    WebElement validateProductPrice;

    @FindBy(css = "a-size-medium sc-product-title a-text-bold")
    WebElement validateProductName;

    @FindBy(css = "div [data-name='Active Items']")
    WebElement totalItemsInCart;

    public boolean isAtCartPage()
    {
        wait.until(ExpectedConditions.visibilityOf(validateProductName));
        return validateProductPrice.isDisplayed() && validateProductName.isDisplayed();
    }

    public void verifyProduct()
    {
        String productPrice = validateProductPrice.getText();
        String productName = validateProductName.getText();
    }

}
