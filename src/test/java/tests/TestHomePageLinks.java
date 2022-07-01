package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pom.BasePage;
import pom.HomePage;

import static org.testng.Assert.*;

public class TestHomePageLinks extends BaseTest {

    @Test
    public void testOpenHomePage() {
        driver.get(BasePage.URI);
    }

    @Test
    public void testMarketsLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMarkets();
        assertEquals(driver.getCurrentUrl(), BasePage.URI + "/markets");
    }

    @Test
    public void testNFTLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnNFT();
        assertEquals(driver.getCurrentUrl(), BasePage.URI + "/nft/collection/Devikins");
    }

}
