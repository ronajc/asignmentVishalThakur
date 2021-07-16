package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonHome {
    WebDriver driver;

    public amazonHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;


    public void findItem(String item){
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }
}
