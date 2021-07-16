package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productHome {
    WebDriver driver;

    public productHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    @FindBy(id = "nav-cart-count-container")
    WebElement cartBtn;

    public void clickAddToCart(){
        addToCartBtn.click();
    }

    public void goToCart(){
        cartBtn.click();
    }
}
