package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "ul.klever-header-menu")
    WebElement headerMenu;
    @FindBy(id = "button-menu-icon")
    WebElement drawerMenu;
    @FindBy(linkText = "Markets")
    WebElement marketsLink;
    @FindBy(linkText = "NFT")
    WebElement nftLink;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(URI);
    }

    public Boolean headerMenuIsDisplayed() {
        return headerMenu.isDisplayed();
    }

    public void clickHeaderMenuIfDisplayed() {
        if (!headerMenuIsDisplayed()) {
            clickElementHandleStale(drawerMenu);
        }
    }

    public MarketsPage clickOnMarkets() {
        clickHeaderMenuIfDisplayed();
        clickElementHandleStale(marketsLink);
        return new MarketsPage(driver);
    }

    public NFTPage clickOnNFT() {
        clickHeaderMenuIfDisplayed();
        clickElementHandleStale(nftLink);
        return new NFTPage(driver);
    }

}
