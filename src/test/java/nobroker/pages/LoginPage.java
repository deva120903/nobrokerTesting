package nobroker.pages;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import nobroker.objectRepository.Locators;



public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public LoginPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}

	public void clickLogin() {
		driver.findElement(Locators.loginButton).click();
	}

	//the user is on the login page
	public void enterMobileNumber(String number) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement phoneInput = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.id("signUp-phoneNumber"))
	    );
	    phoneInput.clear();
	    phoneInput.sendKeys(number);
	}


    public void clickContinue() {
        driver.findElement(Locators.continueButton).click();
    }

	public void enterOtp(String otp) {
		WebElement otpField = driver.findElement(Locators.otpInputs);
		otpField.sendKeys(otp);
	}
	
	private static final Scanner CONSOLE_SCANNER = new Scanner(System.in);

	public void enterOtpManually(WebDriver driver) {
	    try {
	        System.out.print("Enter OTP received in mobile SMS : ");
	        String otp = CONSOLE_SCANNER.nextLine().trim();

	        List<WebElement> otpFields = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.otpInputs)
	        );

	        if (otpFields.size() == 1) {
	            otpFields.get(0).clear();
	            otpFields.get(0).sendKeys(otp);
	        } else {
	            for (int i = 0; i < Math.min(otpFields.size(), otp.length()); i++) {
	                otpFields.get(i).clear();
	                otpFields.get(i).sendKeys(Character.toString(otp.charAt(i)));
	            }
	        }

	        extTest.log(Status.INFO, "Entered OTP manually");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to enter OTP: " + e.getMessage());
	    }
	}

//
//    public void clickVerifyOtp() {
//        driver.findElement(verifyOtpButton).click();
//    }
//
//    public void clickResendOtp() {
//        driver.findElement(resendOtpLink).click();
//    }

	public boolean getNumErrorMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter valid phone number')]")));
			return true;
		}
		catch(TimeoutException te) {
			return false;
		}
	}

    //the user enters a invalid phone number
	public boolean getOtpErrorMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter valid OTP')]")));
			return true;
		}
		catch(TimeoutException te) {
			return false;
		}
	}
	
	public boolean loginsuccessful() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-icon")));
			return true;
		}
		catch(TimeoutException te) {
			return false;
		}
	}
    public void clickResendOtp() {
        driver.findElement(Locators.resendOtpLink).click();
    }

    //the login page should be loaded successfully
    public boolean pageLoadedSuccessfully() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginButton));
            return true;
        } catch (TimeoutException te) {
            return false;
        }
    }

	
}

