package mx.com.amazon.pages;

import mx.com.amazon.utils.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage
{
    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    Actions action = new Actions(driver);

    @FindBy(css = "[href='/ref=nav_logo']")
    WebElement logoAmazon;

    @FindBy(css = "#nav-link-accountList div span")
    WebElement holaIdentificate;

    @FindBy(id = "twotabsearchtextbox")
    WebElement campoBusqueda;

    @FindBy(id = "nav-link-accountList")
    WebElement iniciarSesion;

    @FindBy(xpath = "//span[contains(text(),'Crear una Wish List')]")
    WebElement createWishList;

    @FindBy(id = "list-name")
    WebElement wishListName;

    @FindBy(css = "[data-action='create-list-submit'] span span input")
    WebElement createList;

    @FindBy(css = "#nav-search form div.nav-right div input")
    WebElement clickSearch;

    public void goToHomePage()

    {
        driver.get(Properties.URL);
        driver.manage().window().maximize();
    }

    public boolean isAtHomePage()
    {
        new WebDriverWait(driver, Properties.LONG_WAIT).until(ExpectedConditions.visibilityOf(campoBusqueda));
        return logoAmazon.isDisplayed() &&
                holaIdentificate.isDisplayed() &&
                campoBusqueda.isDisplayed();
    }

    public void clickLogin()
    {
        iniciarSesion.click();
    }

    public void clickWishList()
    {
        action.moveToElement(iniciarSesion).build().perform();
        createWishList.click();

    }

    public void createWishList(String wishList)
    {
        wishListName.clear();
        wishListName.sendKeys(wishList);
        createList.click();
    }

    public void typeInSearchBox(String product)
    {
        campoBusqueda.sendKeys(product);
    }

    public void clickSearch()
    {
        clickSearch.click();
    }
}
