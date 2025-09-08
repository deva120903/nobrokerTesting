package nobroker.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpCenterPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By helpCenterBtn = By.xpath("//*[@id='app']/div/div/div[1]/button");
    private By serviceOption = By.xpath("//*[@id='app']/div/div/div[1]/div/div[1]/div[3]/div[2]/div/div[4]");
    private By issueOption = By.xpath("//*[@id='app']/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div[1]");
    private By closeBtn = By.xpath("//*[@id='app']/div/div/div[2]/button");

    public HelpCenterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickHelpCenter() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(helpCenterBtn));
        btn.click();
    }

    public void selectService(String serviceName) {
        // right now using absolute XPath, can improve by text if available
        WebElement service = wait.until(ExpectedConditions.elementToBeClickable(serviceOption));
        service.click();
    }

    public void selectIssue(String issueName) {
        WebElement issue = wait.until(ExpectedConditions.elementToBeClickable(issueOption));
        issue.click();
    }

    public void closeHelpCenterPanel() {
        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
        close.click();
    }
}