package mx.com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "ap_email")
    WebElement userNameTextBox;

    @FindBy(id = "ap_password")
    WebElement passwordTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "signInSubmit")
    WebElement signInButton;

    public boolean isAtLoginPage()
    {
        wait.until(ExpectedConditions.visibilityOf(userNameTextBox));
        return userNameTextBox.isDisplayed() &&
                continueButton.isDisplayed();
    }

    public void enterUserName(String email)
    {
        userNameTextBox.sendKeys(email);
    }

    public void clickContinue()
    {
        continueButton.click();
    }

    public void enterPassword(String password)
    {
        passwordTextBox.sendKeys(password);
    }

    public void clickSignIn()
    {
        signInButton.click();
        
    }
}
