package tests;

import base.BaseTest;
import data.TestDataProvider;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.MarketsPage;

import static org.testng.Assert.assertTrue;

public class TestMarketsPage extends BaseTest {

    @Test(dataProvider = "market_pair", dataProviderClass = TestDataProvider.class)
    public void testTwoCoins(String firstCoin, String secondCoin) {
        HomePage home = new HomePage(driver);
        MarketsPage markets = home.clickOnMarkets();
        markets.searchTwoCoinsHandleStale(firstCoin, secondCoin);
        String result = markets.returnPairOnTableTextWithIndex(0);
        assertTrue(result.contains(String.format("%s/%s", firstCoin, secondCoin)));
    }

}
