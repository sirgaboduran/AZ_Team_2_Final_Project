package mx.com.amazon.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WishlistPage extends BasePage
{
    public WishlistPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    
    @FindBy(id = "profile-list-name")
    List<WebElement> listNames;
    
    public boolean isAtWishListPage()
    {
        return listNames.size() > 0;
    }
    
    public boolean verifyWishListCreated(String wishList)
    {
        for(WebElement listName : listNames )
        {
            if (listName.getText().equals(wishList))
                return true;
        }
        return false;
    }
}
