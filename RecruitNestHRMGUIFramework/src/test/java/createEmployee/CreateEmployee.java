package createEmployee;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CreateEmployee {
	public static void main(String[] args) throws InterruptedException {
		
	//Launch the browser and maximize
	     WebDriver driver= new ChromeDriver();
	     driver.manage().window().maximize();
	 //implicit wait
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//enter the url
	     driver.get("http://49.249.28.218:8091/");
	     Thread.sleep(2000);
	 //Enter the credetials
	     driver.findElement(By.id("username")).sendKeys("rmgyantra");
	     driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	//Click on employee module
	     
	     driver.findElement(By.xpath("//a[text()='Employees']")).click();
	     driver.findElement(By.xpath("//span[text()='Add New Employee']")).click();	
	 // enter the employee details
	     driver.findElement(By.xpath("//div[@role='dialog']//form//div[2]//div[1]//input[@type='text']")).sendKeys("arun");
	     
	    
	    driver.findElement(By.xpath("//div[@role='dialog']//form//div[2]//div[2]//input[@type='email']")).sendKeys("arun@gmail.com");
	     driver.findElement(By.xpath("(//div[@class='modal-body'])[3]//div[3]//input[@type='text']")).sendKeys("67543297844");
	    driver.findElement(By.xpath("//div[@role='dialog']//form//div[2]//div[4]//input[@type='text']")).sendKeys("arun@");
	    driver.findElement(By.xpath("//div[@role='dialog']//form//div[2]//div[5]//input[@type='text']")).sendKeys("HR");
	    driver.findElement(By.xpath("//div[@role='dialog']//form//div[2]//div[6]//input[@type='text']")).sendKeys("10");
	    
	     
	     WebElement projectdrop = driver.findElement(By.xpath("//select[@name='project']"));
	      Select sel= new Select(projectdrop);
	      sel.selectByVisibleText("PMGSY");
	      
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      for(;;) {
	    	  try {
	    		  driver.findElement(By.xpath("//input[@value='Add' and @class='btn btn-success']"));
	    		  break;
	    	  }catch(Exception e){
	    		  js.executeScript("window.scrollBy(0,250)");
	    	  } 
	    		  
	    	  }
	    driver.findElement(By.xpath("//input[@value='Add']")).click();
	      
	         
	      
	}
}


