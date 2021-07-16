package Tests;

import Pages.*;
import Util.readProperty;
import Util.testUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test002 extends Base {
    flipkartHome home;
    flipkartProductMain productPage;
    flipkartCart cart;
    flipkartProductHomeAfterSearch productMain;
    readProperty rp = new readProperty();
    testUtil util = new testUtil(driver);
    amazonHome amazon;
    productAfterSearch pas;
    productHome ph;
    amazonCart ac;

    @Test
    public void findPrizeFLIP() throws InterruptedException {
        home = new flipkartHome(driver);
        productPage = new flipkartProductMain(driver);
        productMain = new flipkartProductHomeAfterSearch(driver);
        cart = new flipkartCart(driver);
        driver.get(rp.flipkartURL());

        home.cancel();
        home.findItem(rp.productToSearch());
        String main = driver.getWindowHandle();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        productMain.clickItem();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        switchWindow(main);
        System.out.println("The prize of the item on flipkart main page is INR -> " + productPage.getPrizeFromMainPage());
        productPage.clickAddToCart();
        WebElement btn = cart.getBtn();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(btn));

        util.syncWait(driver, 3000);

        System.out.println("The prize of the item on the flipkart checkout page is INR -> " + cart.getPrice());
        flipkartPrize = cart.getPrice();
    }

    @Test
    public void findPrizeAMA() throws InterruptedException {
        amazon = new amazonHome(driver);
        pas = new productAfterSearch(driver);
        ph = new productHome(driver);
        ac = new amazonCart(driver);

        driver.get(rp.amazonURL());
        amazon.findItem(rp.productToSearch());
        String main = driver.getWindowHandle();
        JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
        jsExecutor.executeScript("window.scrollBy(0,600)", "");
        util.syncWait(driver, 3000);
        System.out.println("The prize of the item on amazon main page is INR -> " + pas.getPrize());
        pas.clickOnItem();

        switchWindow(main);
        ph.clickAddToCart();
        util.syncWait(driver, 3000);
        ph.goToCart();

        System.out.println("The prize of the item on the amazon checkout page is INR ->" + ac.getPrize());
        double d = Double.valueOf(ac.getPrize());
        amazonPrize = (int) d;
    }

}
