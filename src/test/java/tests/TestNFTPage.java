package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.NFTPage;

public class TestNFTPage extends BaseTest {

    @Test
    public void testNFTPageFilters() throws InterruptedException {
        HomePage home = new HomePage(driver);
        NFTPage nft = home.clickOnNFT();
        nft.selectPerPageDropdown(0);
        nft.openChooseAndApplyFilter(2, 2);
        nft.selectOrderDropdown(2);
        Thread.sleep(2000);
    }

}
