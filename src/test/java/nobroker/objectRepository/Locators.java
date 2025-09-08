package nobroker.objectRepository;

import org.openqa.selenium.By;

public class Locators {
	
	//1. scenario: login page locator ,otp resend locator
	public static By loginButton=By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div");
	public static By inputNumber=By.id("signUp-phoneNumber");
	public static By continueButton=By.id("signUpSubmit");
	public static By otpInputs = By.xpath("//input[@aria-label='Please enter verification code. Digit 1']");
    public static By resendOtpLink = By.xpath("//div[contains(text(),'Resend OTP')]");
    
    
    //2. search: locators
    public static By cityDropdown = By.id("searchCity");
    public static By landmarkInput = By.id("listPageSearchLocality");
    public static By searchButton = By.xpath("//button[@type='button' and contains(@class,'prop-search-button')]");
    public static By selectedLocalities = By.id("selectedLocalities");
    public static By alertMessageBox = By.id("alertMessageBox");
   // public static By listOfProperties = By.xpath("//*[@id=\"listPageContainer\"]/div[1]/div[1]/div[1]"); // Example: container of property cards
    public static By otpInputs1 = By.xpath("//input[contains(@aria-label,'Please enter verification code')]");

}

