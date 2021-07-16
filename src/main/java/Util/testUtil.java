package Util;

import org.openqa.selenium.WebDriver;

public class testUtil {
        WebDriver driver;

    public testUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void syncWait(WebDriver driver, int time) throws InterruptedException {
        Thread.sleep(time);
    }
}
