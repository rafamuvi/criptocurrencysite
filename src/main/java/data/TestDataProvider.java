package data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "market_pair")
    public static Object[][] marketPairs(){
        return new Object[][] {
                {"KLV", "USDT"},
                {"KLV", "ETH"},
                {"KLV", "BTC"}
        };
    }

}
