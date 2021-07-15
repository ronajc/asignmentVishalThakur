package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartProductHomeAfterSearch {

    WebDriver driver;

    public flipkartProductHomeAfterSearch(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='Logitech M90 Wired Optical Mouse']")
    WebElement item;

    public void clickItem(){
        item.click();
    }
}
