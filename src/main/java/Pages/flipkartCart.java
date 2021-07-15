package Pages;

import Util.readProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartCart {
    WebDriver driver;

    public flipkartCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='_23FHuj'][2]")
    WebElement increaseCount;

    @FindBy(xpath = "//div[@class='_3LxTgx']//child::div//child::div//child::span")
    WebElement price;

    public void incCount(){
        increaseCount.click();
    }

    public int getPrice(){
        String p = price.getText();
        String p1 = p.substring(1);
        return Integer.valueOf(p1);
    }

    public WebElement getBtn(){
        return increaseCount;
    }
}
