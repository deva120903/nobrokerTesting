package nobroker.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nobroker.objectRepository.Locators;

public class HelpCenterPage {

    WebDriver driver;
    WebDriverWait wait;

    public HelpCenterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean clickHelpCenter() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(Locators.helpCenterBtn));
            btn.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Help Center button not found: " + te.getMessage());
            return false;
        }
    }

    public boolean selectService() {
        try {
            WebElement service = wait.until(ExpectedConditions.elementToBeClickable(Locators.serviceOption));
            service.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Service option not found: " + te.getMessage());
            return false;
        }
    }

    public boolean selectIssue() {
        try {
            WebElement issue = wait.until(ExpectedConditions.elementToBeClickable(Locators.InvoiceOption));
            issue.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Issue option not found: " + te.getMessage());
            return false;
        }
    }

    public boolean closeHelpCenterPanel() {
        try {
            WebElement close = wait.until(ExpectedConditions.elementToBeClickable(Locators.closeBtn));
            close.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Close button not found: " + te.getMessage());
            return false;
        }
    }
    public boolean isHelpCenterVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.helpCenterBtn));
            return true;
        } catch (TimeoutException te) {
            System.out.println("Help Center button not visible: " + te.getMessage());
            return false;
        }
    }

}
