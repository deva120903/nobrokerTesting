package nobroker.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nobroker.objectRepository.Locators;

public class Painting_CleaningPage {

    WebDriver driver;
    WebDriverWait wait;

    
    public Painting_CleaningPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean openHomeMenu() {
        try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(Locators.menuBtn));
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


    public boolean selectPaintingCleaningService() {
        try {
            WebElement paintClean = wait.until(ExpectedConditions.elementToBeClickable(Locators.paintcleanIcon));
            paintClean.click();
            WebElement cityChennai=wait.until(ExpectedConditions.elementToBeClickable(Locators.cityIconChennai));
            cityChennai.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Painting and Cleaning service not selectable: " + te.getMessage());
            return false;
        }
    }

    public boolean clickHomeCleaning() {
        try {
            WebElement homeClean = wait.until(ExpectedConditions.elementToBeClickable(Locators.homecleanIcon));
            homeClean.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Home Cleaning not clickable: " + te.getMessage());
            return false;
        }
    }

    public boolean selectFullHomeCleaning() {
        try {
            WebElement fullClean = wait.until(ExpectedConditions.elementToBeClickable(Locators.fullHomeCleanIcon));
            fullClean.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Full Home Cleaning not selectable: " + te.getMessage());
            return false;
        }
    }

    public boolean isFullHomeCleaningPageVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[4]/img")));
            return true;
        } catch (TimeoutException te) {
            System.out.println("Full Home Cleaning page not visible: " + te.getMessage());
            return false;
        }
    }

    public boolean selectFurnishedApartment() {
        try {
            WebElement furnished = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.furnishedIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", furnished);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", furnished);

            // Verify that furnished items appear after click
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"FURNISHED_ESSENTIAL_APARTMENT_CLEANING_BHKTYPE\"]/div[1]/div/div[1]/div/div[1]/span")));
            return true;
        } catch (Exception e) {
            System.out.println("Furnished Apartment not selected: " + e.getMessage());
            return false;
        }
    }


    public boolean addAllItems() {
        try {
        	WebElement furnisheddown=wait.until(ExpectedConditions.elementToBeClickable(Locators.furnishedItem1));
        	furnisheddown.click();
        	WebElement item1add = wait.until(ExpectedConditions.elementToBeClickable(Locators.furnishedItemAdd1BHK));
            item1add.click();
            WebElement item2add=wait.until(ExpectedConditions.elementToBeClickable(Locators.furnishedItemAdd2BHK));
            item2add.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Failed to add items: " + te.getMessage());
            return false;
        }
    }

    public boolean removeSomeItems() {
        try {
        	WebElement removeitemFromadd = wait.until(ExpectedConditions.elementToBeClickable(Locators.closeItemSelect));
        	removeitemFromadd.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Failed to remove items: " + te.getMessage());
            return false;
        }
    }

    public boolean verifyItemsAdded() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.removeItemfromAdd));
            return true;
        } catch (TimeoutException te) {
            System.out.println("Items not added properly: " + te.getMessage());
            return false;
        }
    }

    public boolean verifyItemsRemoved() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"FURNISHED_ESSENTIAL_APARTMENT_CLEANING_BHKTYPE\"]/div[1]/div/div[2]/button")));
            return true;
        } catch (TimeoutException te) {
            System.out.println("Items not removed properly: " + te.getMessage());
            return false;
        }
    }
    
    public boolean clickPainting() {
    	try {
            WebElement painting = wait.until(ExpectedConditions.elementToBeClickable(Locators.paintingIcon));
            painting.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("Painting not clickable: " + te.getMessage());
            return false;
        }
    }
    
    public boolean isInteriorPainting() {
    	try {
            WebElement inPainting = wait.until(ExpectedConditions.elementToBeClickable(Locators.interiorPaintingIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",inPainting );
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", inPainting);

            // Verify that furnished items appear after click
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"INTERIOR_PAINTING_CONSULTATION\"]/div/div[1]/div[2]/div[2]/img")));
             
            return true;
        } catch (TimeoutException te) {
            System.out.println("Interior Painting not clickable: " + te.getMessage());
            return false;
        }
    }
    
    public boolean isExteriorPainting() {
    	try {
            WebElement exPainting = wait.until(ExpectedConditions.elementToBeClickable(Locators.exteriorPaintingIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",exPainting );
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", exPainting);
            
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"EXTERIOR_PAINTING_CONSULTATION\"]/div/div[1]/div[2]/div[2]/img")));
            return true;
        } catch (TimeoutException te) {
            System.out.println("Interior Painting not clickable: " + te.getMessage());
            return false;
        }
    }
    
    public boolean verifyPaintingPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"EXTERIOR_PAINTING_CONSULTATION\"]/div/div[2]/div[3]/button")));
            return true;
        } catch (TimeoutException te) {
            System.out.println("Painting page not viewed properly: " + te.getMessage());
            return false;
        }
    }
    
    public void isInvalidData(String inValiddata) {
    	try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/div/div/main/header/nav/div[1]/div/div")));
            WebElement searchItemicon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search-bar\"]/input")));
            searchItemicon.click();
            
            WebElement searchItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search-bar\"]/input")));

            searchItem.sendKeys(inValiddata);
            
        } catch (TimeoutException te) {
            System.out.println("The entered data properly executed: " + te.getMessage());
            
        }
    }
    
    public boolean preventSearch() {
    	try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"search-bar\"]/div[2]/img")));
            WebElement backMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search-bar\"]/div[1]/img")));
            backMenu.click();
            return true;
        } catch (TimeoutException te) {
            System.out.println("System should prevent invalid search action " + te.getMessage());
            return false;
        }
    }
    
    public boolean changeMenu() {
    	try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"main-menu\"]/div[1]")));
            return true;
        } catch (TimeoutException te) {
            System.out.println("System should does not allow to navigate to other menu in one action " + te.getMessage());
            return false;
        }
    }
    
    public boolean validateAccessMenu() {
    	try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/div/div/main/div/div/span[1]/section/div[1]")));
            return true;
        } catch (TimeoutException te) {
            System.out.println("The access denied to navigate to other menu in one action " + te.getMessage());
            return false;
        }
    }
}
