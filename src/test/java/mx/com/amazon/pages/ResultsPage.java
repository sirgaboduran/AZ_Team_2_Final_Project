package mx.com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends BasePage
{
    public ResultsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "(//a[@class='a-link-normal a-text-normal'])[1]")
    WebElement product;

    public boolean isAtResultsPage()
    {
        return product.isDisplayed();
    }

    public void selectProduct()
    {
        product.click();
    }
}
