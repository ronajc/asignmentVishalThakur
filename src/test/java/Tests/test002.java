package Tests;

import Pages.flipkartCart;
import Pages.flipkartHome;
import Pages.flipkartProductHomeAfterSearch;
import Pages.flipkartProductMain;
import Util.readProperty;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test002 extends Base{
    flipkartHome home;
    flipkartProductMain productPage;
    flipkartCart cart;
    flipkartProductHomeAfterSearch productMain;
    readProperty rp;

    @Test
    public void findPrize() throws InterruptedException {
        home = new flipkartHome(driver);
        productPage = new flipkartProductMain(driver);
        productMain = new flipkartProductHomeAfterSearch(driver);
        cart = new flipkartCart(driver);
        rp= new readProperty();
        driver.get(rp.flipkartURL());

        home.cancel();
        home.findItem("Logitech M90 Wired Optical Mouse");
        String main = driver.getWindowHandle();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        productMain.clickItem();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        switchWindow(main);
        productPage.clickAddToCart();
        WebElement btn = cart.getBtn();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(btn));

        Thread.sleep(3000);
        System.out.println("The prize of the item is INR -> "+ cart.getPrice());
    }

}
