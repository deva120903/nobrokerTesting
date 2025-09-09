package nobroker.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import nobroker.objectRepository.Locators;

public class HistoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean clickHistoryTab() {
        try {
            WebElement historyTab = wait.until(ExpectedConditions.elementToBeClickable(Locators.historyPageHeader));
            historyTab.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("History tab not clickable: " + te.getMessage());
            return false;
        }
    }

    public boolean selectServiceFromHistory() {
        try {
            WebElement service = wait.until(ExpectedConditions.elementToBeClickable(Locators.historyTab));
            service.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Service in history not selectable: " + te.getMessage());
            return false;
        }
    }

    public boolean areServiceDetailsVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.historyServiceExit));
            return true;
        } catch (TimeoutException te) {
            System.out.println("Service details not visible: " + te.getMessage());
            return false;
        }
    }

    public boolean closeHistoryView() {
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.serviceButtonClose));
            closeBtn.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Failed to close history view: " + te.getMessage());
            return false;
        }
    }
}
