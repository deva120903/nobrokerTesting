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

public class Packers_MoversPage {
    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;
    
    public Packers_MoversPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.extTest = extTest;
    }

    public boolean openMenu() {
    	try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(Locators.menuIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);
            menu.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Home menu not clickable: " + te.getMessage());
            return false;
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted, retrying: " + e.getMessage());
            try {
                // Try clicking via JS if Selenium click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(Locators.menuBtn));
                return true;
            } catch (Exception ex) {
                System.out.println("JS click failed: " + ex.getMessage());
                return false;
            }
        }
    }

    public boolean selectPackersMovers() {
    	try {
            WebElement packerMover = wait.until(ExpectedConditions.elementToBeClickable(Locators.packersMoversService));
            packerMover.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Packers and Movers service not selectable: " + te.getMessage());
            return false;
        }
    }

    public boolean clickWithinCity() {
    	try {
            WebElement clickwithinCity = wait.until(ExpectedConditions.elementToBeClickable(Locators.withinCityOption));
            clickwithinCity.click();
           
            return true;
        } catch (TimeoutException te) {
            System.out.println(" select within city option not selectable: " + te.getMessage());
            return false;
        }
    }



    public boolean enterCity() {
        try {
            // 1. Click the city input/select box (generic approach)
            WebElement cityBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div/div/div/div[1]/div/div[4]/div/button")   // looks for dropdown trigger container
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityBox);
            cityBox.click();

            // 2. Wait for dropdown menu to appear
            WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div/div/div/div[1]/div/div[4]/p")   // flexible dropdown container
            ));

            // 3. Find city option by visible text inside dropdown
            WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div/div/div/div[1]/div/div[4]/div/ul/li[4]")));
            
             cityOption.click();

            return true;
        } catch (Exception e) {
            System.out.println("Failed to select city:" + e.getMessage());
            return false;
        }
    }

    

	
    public void enterSource(String source) {
		  try {
	            WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.pickupInput));
	            fromInput.click();
	            fromInput.clear();
	            fromInput.sendKeys(source);
	            Thread.sleep(1000);

	            WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//*[@id='autocomplete-dropdown-container']/div[1]")  // first option in list
	                ));
	                firstOption.click();
	                if (extTest != null) {
	                    extTest.log(Status.PASS, "From location selected: " + source);
	                }	        } catch (Exception e) {
	            extTest.log(Status.FAIL, "Failed to select from location: " + e.getMessage());
	        }
	  }
	  
	  public void enterDestination(String destination) {
		  try {
	            WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.dropInput));
	            toInput.click();
	            toInput.clear();
	            toInput.sendKeys(destination);
	            Thread.sleep(1000);

	            WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//*[@id='autocomplete-dropdown-container']/div[1]")  // first option in list
	                ));
	                firstOption.click();

	                if (extTest != null) {
	                    extTest.log(Status.PASS, "From location selected: " + destination);
	                }	 
	                
	                WebElement clickButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"getRealPriceButtonMobile\"]")));
		            clickButton.click();
		  } catch (Exception e) {
	            extTest.log(Status.FAIL, "Failed to select to location: " + e.getMessage());
	        }
	  }


public boolean navigateToInventoryWithoutAdding() { 
	  try {
		  WebElement verify = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div/div/div/div[1]")  
	            ));
        
       
        return true;
    } catch (TimeoutException te) {
        System.out.println("Navigate without adding is verified: " + te.getMessage());
        return false;
    }
  }

    
	  public boolean removeItemThatAdded() { 
		  try {
				/*
				 * WebElement verify = wait.until(ExpectedConditions.presenceOfElementLocated(
				 * By.xpath("//*[@id=\"serviceDetail\"]/div/div/div[1]/div[1]/svg") ));
				 * WebElement addedElementcheckIcon =
				 * wait.until(ExpectedConditions.elementToBeClickable(Locators.selectedItems));
				 * addedElementcheckIcon.click();
				 * 
				 * WebElement addedElementMinusIcon =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				 * "(//*[@id='decreament']/*[name()='svg'])[1]")));
				 * addedElementMinusIcon.click();
				 * 
				 * WebElement addedElementMinusIcon1 =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				 * "(//*[@id='decreament']/*[name()='svg'])[2]")));
				 * addedElementMinusIcon1.click();
				 */
			  
			    
	            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modalContent\"]/div[4]/div/button[1]")));
	            closeButton.click();
	          return true;
	      } catch (TimeoutException te) {
	          System.out.println("Navigate without adding is verified: " + te.getMessage());
	          return false;
	      }
	    }

		/*
		 * public boolean navigateToInventoryWithoutAdding() { try { WebElement verify =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div/div/div/div[1]") ));
		 * 
		 * 
		 * return true; } catch (TimeoutException te) {
		 * System.out.println("Navigate without adding is verified: " +
		 * te.getMessage()); return false; } }
		 */

  public boolean clickContinueWithoutAdd() {
  	try {
  		WebElement clickContinueWithoutAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"serviceDetail\"]/div/div/div[2]/div/div/button/div/div")));
        clickContinueWithoutAdd.click();
       
        return true;
    } catch (TimeoutException te) {
        System.out.println(" click continue without add selectable: " + te.getMessage());
        return false;
    }
  }
	
//Check if alert is displayed
//Check if alert is present
public boolean isAlertPresent() {
   try {
       WebElement alert = wait.until(ExpectedConditions
               .visibilityOfElementLocated(By.id("alertMessageBox")));
       return alert.isDisplayed();
   } catch (Exception e) {
       return false;
   }
}

//Get alert text
public String getAlertMessage() {
   try {
       WebElement alert = wait.until(ExpectedConditions
               .visibilityOfElementLocated(By.id("alertMessageBox")));
       return alert.getText();
   } catch (Exception e) {
       return "";
   }
}
//*[@id="modalContent"]/div[1]/div/img

//*[@id="67d84a4ae50df484e137daeb"]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]
  public boolean addItems() { 
	  try {
		  
		  WebElement clickdowntoAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"67d84a4ae50df484e137daeb\"]/div[2]/div/div[2]/div")));
	        clickdowntoAdd.click();
		    
	  		WebElement clickAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"67d84a4ae50df484e137daeb\"]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div")));
	        clickAdd.click();
	        WebElement clickContinueWithAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"serviceDetail\"]/div/div/div[2]/div/div/button/div/div")));
	        clickContinueWithAdd.click();
	       
	        WebElement clickCloseIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"serviceDetail\"]/div/div/div[2]/div/div/button/div/div")));
	        clickCloseIcon.click();
	       
	        return true;
	    } catch (TimeoutException te) {
	        System.out.println(" click continue with add selectable: " + te.getMessage());
	        return false;
	    }

  }
 }
 