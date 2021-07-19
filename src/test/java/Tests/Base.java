package Tests;

import Util.readProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import resources.webEventListener;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    static int flipkartPrize;
    static int amazonPrize;
    readProperty prop = new readProperty();

    public  static EventFiringWebDriver e_driver;
    public static webEventListener eventListener;

    @BeforeMethod
    public void setup() {
        if (prop.browserToUse().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver();
        } else if (prop.browserToUse().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (prop.browserToUse().equals("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

//        unComment if need clearer logs for debugging
//        e_driver = new EventFiringWebDriver(driver);
//        eventListener = new webEventListener();
//        e_driver.register(eventListener);
//        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public void switchWindow(String main) {

        Set<String> total = driver.getWindowHandles();
        Iterator<String> iterator = total.iterator();

        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!main.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    @AfterTest
    public void finalVerdict() {
        System.out.println("Flipkart : " + flipkartPrize + " || " + "Amazon : " + amazonPrize);
        //System.out.println(flipkartPrize>amazonPrize?"Amazon is providing cheaper prize":"Flipkart is providing cheaper prize");
        if (flipkartPrize > amazonPrize) {
            System.out.println("Amazon is providing cheaper prize");
        } else if (flipkartPrize < amazonPrize) {
            System.out.println("Flipkart is providing cheaper prize");
        } else if (flipkartPrize == amazonPrize) {
            System.out.println("Both platforms are selling items at same prize");
        } else {
            System.out.println("No comparison available !!");
        }
    }

}
