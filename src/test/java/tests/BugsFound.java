package tests;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.MarketsPage;

import java.io.File;
import java.io.IOException;

public class BugsFound extends BaseTest {

    @Test
    public void trendingMarketsSliderBug() throws InterruptedException, IOException {
        System.out.println("If you load the page maximized, minimize and then maximize again the slider 'goes away'");
        HomePage home = new HomePage(driver);
        home.clickOnMarkets();
        Thread.sleep(6000);
        driver.manage().window().setSize(
                new Dimension(
                        driver.manage().window().getSize().width / 2, driver.manage().window().getSize().height / 2));
        Thread.sleep(6000);
        driver.manage().window().maximize();
        Thread.sleep(6000);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/java/screenshots/slider_bug.png"));
    }

    @Test
    public void endlessSearch() throws InterruptedException, IOException {
        System.out.println("If you search for something that doesn't exists, page will look like infinite loading");
        HomePage home = new HomePage(driver);
        MarketsPage markets = home.clickOnMarkets();
        markets.searchTwoCoinsHandleStale("bla", "bla");
        Thread.sleep(6000);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/java/screenshots/loading_bug.png"));
    }

    @Test
    public void noNumPadNoSearch() throws InterruptedException, IOException {
        System.out.println("If you try to use the search bar on /markets without numpad, you can't. It only recognizes" +
                " SUBTRACT symbol in NUMPAD");
        HomePage home = new HomePage(driver);
        MarketsPage markets = home.clickOnMarkets();
        WebElement inputField = driver.findElement(By.cssSelector("input[data-testid='search']"));
        inputField.sendKeys("%s-------------------------------%s");
        Thread.sleep(4000);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/java/screenshots/input_bug.png"));
    }
}
