package Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class testUtil {
        WebDriver driver;

    public testUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void syncWait(WebDriver driver, int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void putImplWaitSeconds(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void putImplWaitMicroSeconds(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.MICROSECONDS);
    }

    public void putExpWait(WebDriver driver, WebElement locator){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void takeScreenShot(WebDriver driver, String name) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/Screenshots/" + name + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }
}
