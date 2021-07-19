package Tests;

import Pages.flipkartCart;
import Pages.flipkartHome;
import Pages.flipkartProductHomeAfterSearch;
import Pages.flipkartProductMain;
import Util.readProperty;
import Util.testUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test001 extends Base {
    flipkartHome home;
    flipkartProductMain productPage;
    flipkartCart cart;
    flipkartProductHomeAfterSearch productMain;
    readProperty rp;
    testUtil util = new testUtil(driver);

    @Test
    public void findPrize() throws InterruptedException {
        home = new flipkartHome(driver);
        productPage = new flipkartProductMain(driver);
        productMain = new flipkartProductHomeAfterSearch(driver);
        cart = new flipkartCart(driver);
        rp = new readProperty();
        driver.get(rp.flipkartURL());

        home.cancel();
        home.findItem(rp.productToSearch());
        String main = driver.getWindowHandle();

        util.syncWait(driver, 3000);
        productMain.clickItem();
        util.putImplWaitSeconds(driver, 5);
        switchWindow(main);
        productPage.clickAddToCart();
        WebElement btn = cart.getBtn();
        util.putExpWait(driver, btn);

        cart.incCount();
        util.syncWait(driver, 5000);
        System.out.println("The prize of the item on flipkart after increasing the count by one is INR -> " + cart.getPrice());
    }

}
