package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartHome{
    WebDriver driver;

    public flipkartHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='_3704LK']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
    WebElement cancelLogin;

    public void findItem(String item){
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }
    public void cancel(){
        cancelLogin.sendKeys(Keys.ESCAPE);
    }
}
