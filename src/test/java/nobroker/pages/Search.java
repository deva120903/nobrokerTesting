package nobroker.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import nobroker.objectRepository.Locators;

public class Search {
    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public Search(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }

    // Select city (Mumbai or Chennai)
    public void selectCity(String cityName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.cityDropdown)).click();

            WebElement menu = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'nb-select__menu')]"))
            );

            WebElement cityOption = menu.findElement(By.xpath(".//div[text()='" + cityName + "']"));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityOption);

            cityOption.click();

            extTest.log(Status.PASS, "City selected: " + cityName);
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to select city: " + cityName + ". Error: " + e.getMessage());
        }
    }

    // Enter landmark with arrow down + Enter
    public void enterLocality(String locality) {
        try {
            WebElement localityInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.landmarkInput));
            localityInput.click();
            localityInput.clear();
            localityInput.sendKeys(locality);
            Thread.sleep(1000);

            localityInput.sendKeys(Keys.ARROW_DOWN);
            localityInput.sendKeys(Keys.ENTER);

            extTest.log(Status.PASS, "Locality selected: " + locality);
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to select locality: " + e.getMessage());
        }
    }

    // Leave landmark blank
    public void leaveLandmarkBlank() {
        try {
            WebElement localityInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.landmarkInput));
            localityInput.click();
            localityInput.clear();
            extTest.log(Status.PASS, "Landmark left blank");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to clear landmark field: " + e.getMessage());
        }
    }

    // Click search button
    public void clickSearchButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.searchButton)).click();
            extTest.log(Status.PASS, "Clicked on search button");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
        }
    }

    // Check if alert is displayed
    public boolean isAlertPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.alertMessageBox));
            extTest.log(Status.PASS, "Alert message displayed");
            return true;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Alert not displayed: " + e.getMessage());
            return false;
        }
    }

    // Get alert text
    public String getAlertMessage() {
        try {
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.alertMessageBox));
            String msg = alert.getText();
            extTest.log(Status.INFO, "Alert message: " + msg);
            return msg;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to read alert message: " + e.getMessage());
            return "";
        }
    }

    // Verify properties page loaded
    public boolean isPropertiesPageLoaded() {
        try {
            WebElement pageHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='listPageContainer']/div[1]/div[1]/div[1]") // ✅ fixed
                )
            );

            boolean isDisplayed = pageHeader.isDisplayed();
            extTest.log(Status.PASS, "Properties page loaded successfully");
            return isDisplayed;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Properties page not loaded: " + e.getMessage());
            return false;
        }
    }

}
