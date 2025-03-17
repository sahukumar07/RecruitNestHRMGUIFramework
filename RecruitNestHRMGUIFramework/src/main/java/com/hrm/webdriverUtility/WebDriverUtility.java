package com.hrm.webdriverUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	// Implicitly wait

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	// Explicit wait
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	public void waitForElementclickables(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Switch to window

	public void toSwitchWindow(WebDriver driver, String partialTitle) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			String title = driver.switchTo().window(id).getTitle();
			if (title.contains(partialTitle)) {
				break;
			}
		}
	}

	// To maximize
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();

	}

	// To minimize
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	// To handleDropdown by index
	public void toHandelDropdown(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// To handleDropdown by value
	public void toHandelDropdown(WebElement element, String vlaue) {
		Select select = new Select(element);
		select.selectByValue(vlaue);

	}

	// To handle dropdown by text
	public void toHandelDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// To Handle frame
	public void ToHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void ToHandleFrame(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);

	}

	public void ToHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void ToHandleFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	// To Handle mouse related actions

	public void ToPerformMouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	public void toPerformRightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();

	}

	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	// to handle pop-up

	public void toHandlePopupAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void toHandlePopupAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	// to handle pop-up and return message
	public String toHandlePopupAndCaptureText(WebDriver driver) {
		Alert popup = driver.switchTo().alert();
		String message = popup.getText();
		popup.accept();
		return message;

	}
	//To take ScreenShot
	
	public String ToTakeScreenShot(WebDriver driver, String sreenshotname) throws IOException {
    	TakesScreenshot ts=   (TakesScreenshot) driver;
    	File temp = ts.getScreenshotAs(OutputType.FILE);
    	File src= new File("./errorShot/"+sreenshotname+".png");  // first cretae the folder and then  give the file path
    	FileHandler.copy(temp, src);
    	String path = src.getAbsolutePath();  // to get path of SS .
    	
    	return path;
	}
   
 		
    	 
    
    /**
     * ToZoomOut		
     * @throws InterruptedException 
     * @throws AWTException 
     */
	  /*public void toZoomOut(WebDriver driver) throws InterruptedException, AWTException {
	    	 Robot robot= new Robot();
	 		robot.keyPress(KeyEvent.VK_CONTROL);
	 		robot.keyPress(KeyEvent.VK_SUBTRACT);
	 		robot.keyRelease(KeyEvent.VK_CONTROL);
	 		robot.keyRelease(KeyEvent.VK_SUBTRACT);
	 		Thread.sleep(2000);*/
    		
    	
    	
}

