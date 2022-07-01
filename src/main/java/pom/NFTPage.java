package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NFTPage extends BasePage {

    @FindBy(css = "button.ant-btn.ant-btn-text.klever-btn-filter")
    WebElement filterButton;
    @FindBy(css = "ul[role=\"menu\"]>div")
    List<WebElement> filterOptions;

    @FindBy(css = "div.ant-tabs-nav div.ant-select-selector")
    WebElement priceOrderDropdownMenu;

    @FindBy(css = "div.ant-select-selector > span[title$=\"/ page\"]")
    WebElement perPageDropdown;

    @FindBy(css = "div.rc-virtual-list-holder-inner>div")
    List<WebElement> openedDropdown;

    public NFTPage(WebDriver driver) {
        super(driver);
    }

    // This approach doesn't work because it's not a select item, it's div
    //public void selectFromDropdown(WebElement element, int option) {
    //    Select dropdownElement = new Select(element);
    //    dropdownElement.selectByIndex(option);
    //}

    public void selectItemFromDropdown(WebElement parent, List<WebElement> list, int option) {
        staleElementExceptionHandler(() -> {
            clickElementHandleStale(parent);
            clickElementHandleStale(list.get(option));
        });

    }


    public void selectOrderDropdown(int option) {
        selectItemFromDropdown(priceOrderDropdownMenu, openedDropdown, option);
    }

    public void selectPerPageDropdown(int option) {
        selectItemFromDropdown(perPageDropdown, openedDropdown, option);
    }

    public WebElement returnButtonWithText(String text) {
        return driver.findElement(By.xpath(String.format("//button[contains(., \"%s\")]", text)));
    }

    public void handleSlider(WebElement element, int option) {

    }

    public void openChooseAndApplyFilter(int filterIndex, int optionIndex) {
        staleElementExceptionHandler(() -> {
            clickElementHandleStale(filterButton);
            selectItemFromDropdown(filterOptions.get(filterIndex), openedDropdown, optionIndex);
            clickElementHandleStale(returnButtonWithText("Apply"));
        });
    }

}
