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
    
    
    //3.  Helpcenter locators
    public static By helpCenterBtn = By.xpath("//*[@id='app']/div/div/div[1]/button");
    public static By serviceOption = By.xpath("//*[@id='app']/div/div/div[1]/div/div[1]/div[3]/div[2]/div/div[4]");
    public static By InvoiceOption = By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div[7]/div[1]");
    public static By closeBtn = By.xpath("//*[@id='app']/div/div/div[2]/button");
    
  //*[@id="app"]/div/div/div[1]/button/img
    //4.  History locators
    public static final By historyPageHeader = By.xpath("//*[@id='app']/div/div/div[1]/button");

    // Tab/button to open History
    public static final By historyTab = By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div[2]/button[2]/img");

    // Any service option in the history list (first one for simplicity)
    public static final By historyServiceExit = By.xpath("/html/body/div/div/div/div/div/div[1]/div/div[1]");

    // Details section of selected service
    public static final By serviceButtonClose = By.xpath("//*[@id='app']/div/div/div[2]/button");
    
    
    
    //5.  Painting & Cleaning locators
    
    public static final By menuBtn=By.xpath("//*[@id=\"main-menu\"]/div[1]/img");
    public static final By paintcleanIcon= By.xpath("//*[@id=\"main-menu\"]/div[2]/a[3]");
    public static final By cityIconChennai=By.xpath("//*[@id=\"modalContent\"]/div[2]/div/div[3]/img");
    public static final By homecleanIcon= By.xpath("//*[@id=\"hs_cleaning\"]/div[1]/div[1]/div");
    public static final By fullHomeCleanIcon= By.xpath("//*[@id=\"app\"]/div/div/main/div/div/div[2]/div/div/div/div[1]/div[2]");
    public static final By furnishedIcon=By.xpath("(//*[@id='hs_fhc']/div[1]/div[1]/div)[1]");
    public static final By furnishedItem1=By.xpath("//*[@id=\"FURNISHED_ESSENTIAL_APARTMENT_CLEANING_BHKTYPE\"]/div[1]/div/div[2]/button");
    public static final By furnishedItemAdd1BHK=By.xpath("//*[@id=\"bhk-selection-container\"]/div[1]/div/button");
    public static final By furnishedItemAdd2BHK=By.xpath("//*[@id=\"bhk-selection-container\"]/div[2]/div/button");
    public static final By closeItemSelect=By.xpath("//*[@id=\"modalContent\"]/div[1]/div/img");
    public static final By removeItemfromAdd= By.xpath("//*[@id=\"FURNISHED_ESSENTIAL_APARTMENT_CLEANING_BHKTYPE\"]/div[1]/div/div[2]/button");
    
    //painting locators
    public static final By paintingIcon=By.xpath("//*[@id=\"hs_painting\"]/div[1]/div[1]/div");
    public static final By interiorPaintingIcon=By.xpath("//*[@id=\"INTERIOR_PAINTING\"]/div[1]/div[1]/div");
    public static final By exteriorPaintingIcon=By.xpath("//*[@id=\"EXTERIOR_PAINTING\"]/div[1]/div[1]/div");
    
    
    //6.  packers and movers locators
    public static final By menuIcon = By.xpath("//*[@id=\"main-menu\"]/div[1]/img"); 
    public static final By packersMoversService = By.xpath("//*[@id=\"main-menu\"]/div[2]/a[4]");
    public static final By withinCityOption = By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div/div/div/div[1]/div/div[3]/div/div[1]");
   // public static final By cityInput = By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div/div/div/div[1]/div/div[4]/p");
    public static final By pickupInput = By.xpath("//*[@id=\"pnmLandingPageFromRelocationFormLocalitySearch\"]");
    public static final By dropInput = By.xpath("//*[@id=\"pnmLandingPageToRelocationLocalitySearch\"]");
    public static final By checkPriceBtn = By.id("checkPrice");
    public static final By errorMessage = By.xpath("//div[@class='error']");
    public static final By addInventoryBtn = By.id("addInventory");
    public static final By continueBtn = By.id("continue");
    public static final By alertMessage = By.xpath("//div[@class='alert']");
    public static final By dropdownItem = By.xpath("//select[@id='roomDropdown']");
    public static final By selectedItems = By.id("selectedItems");
}

