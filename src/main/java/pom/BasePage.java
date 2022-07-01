package pom;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    public static final String URI = "https://klever.io";
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void staleElementExceptionHandler(Runnable run) {
        boolean done = false;
        while (!done) {
            try {
                run.run();
                done = true;
            } catch (StaleElementReferenceException ignored) {
            }
        }
    }

    public void clickElementHandleStale(WebElement element) {
        staleElementExceptionHandler(() -> {
            waitElementIsClickable(element);
            element.click();
        });
    }

    public void sendKeysHandleStale(WebElement element, CharSequence... keysToSend) {
        staleElementExceptionHandler(() -> {
            waitElementIsClickable(element);
            element.sendKeys(keysToSend);
        });
    }

    public void waitElementIsClickable(WebElement element) {
        //wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
