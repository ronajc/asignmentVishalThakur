package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

    public void switchWindow(String main){

        Set<String> total = driver.getWindowHandles();
        Iterator<String> iterator = total.iterator();

        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!main.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

}
