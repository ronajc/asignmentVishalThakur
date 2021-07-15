package Pages;

import Util.readProperty;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartProductMain {
    WebDriver driver;

    public flipkartProductMain(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
    WebElement addToCartBtn;

    public void clickAddToCart(){
        addToCartBtn.click();

//        JavascriptExecutor js = ((JavascriptExecutor)driver);
//        js.executeScript("arguments[0].click()", addToCartBtn);
    }
}
