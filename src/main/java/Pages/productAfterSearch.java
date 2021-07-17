package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productAfterSearch {
    WebDriver driver;

    public productAfterSearch(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[1]/div/div")
    @FindBy(xpath = "//span[contains(text(), 'Logitech M90 Wired USB Mouse, 1000 DPI Optical Tracking, Ambidextrous PC/Mac/Laptop - Black')]")
    WebElement item;

    public void clickOnItem(){
        item.click();
    }

}
