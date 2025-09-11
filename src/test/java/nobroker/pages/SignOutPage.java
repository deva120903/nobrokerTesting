package nobroker.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import nobroker.objectRepository.Locators;
public class SignOutPage {

	WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;
    
    public SignOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.extTest = extTest;
    }
	public boolean userFinal() {
		try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-menu\"]/div[1]/img")));
         
           
            return true;
        } catch (TimeoutException te) {
            System.out.println(" Visibility of user in the final stage " + te.getMessage());
            return false;
        }
	}
	
	public boolean clickSignOut() {
		try {
            WebElement touchProfile = wait.until(ExpectedConditions.elementToBeClickable(Locators.touchProfile));
            touchProfile.click();
           
            WebElement signoutBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.signOutBtn));
            signoutBtn.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println(" User not applicable to sign out " + te.getMessage());
            return false;
        }
	}
	
	public boolean verifySignout() {
		try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div")));
         
           
            return true;
        } catch (TimeoutException te) {
            System.out.println(" Verified that user not sign out " + te.getMessage());
            return false;
        }
	}
}
