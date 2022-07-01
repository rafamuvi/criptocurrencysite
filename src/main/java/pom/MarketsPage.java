package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MarketsPage extends BasePage {

    @FindBy(css = "input.ant-input")
    WebElement searchInput;
    @FindBy(css = "div table tr.ant-table-row")
    List<WebElement> currencyTable;

    public MarketsPage(WebDriver driver) {
        super(driver);
    }

    public void searchTwoCoinsHandleStale(String coin1, String coin2) {
        staleElementExceptionHandler(() -> {
            clickElementHandleStale(searchInput);
            sendKeysHandleStale(searchInput, coin1, Keys.SUBTRACT, coin2);
        });
    }

    public String returnPairOnTableTextWithIndex(int index) {
        return currencyTable.get(index).getText();
    }

}
