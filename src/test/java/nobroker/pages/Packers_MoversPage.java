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

  public boolean clickContinueWithoutAdd() {
  	try {
  		WebElement clickContinueWithoutAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content-wrapper\"]/div/div[1]/div/div/div/div[1]/div[2]/div/div/div[1]")));
        clickContinueWithoutAdd.click();
       
        return true;
    } catch (TimeoutException te) {
        System.out.println(" click continue without add selectable: " + te.getMessage());
        return false;
    }
  }
	
//Check if alert is displayed
  public boolean isAlertPresent() {
      try {
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='alertMessageBox']")));
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
          WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='alertMessageBox']")));
          String msg = alert.getText();
          extTest.log(Status.INFO, "Alert message: " + msg);
          return msg;
      } catch (Exception e) {
          extTest.log(Status.FAIL, "Failed to read alert message: " + e.getMessage());
          return "";
      }
  }
}
/*
 * public boolean addItems() { try { driver.findElement(addItemBtn).click();
 * return driver.findElement(addedItemsSection).isDisplayed(); } catch
 * (Exception e) { return false; } } }
 */