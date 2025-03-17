package com.hrm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.hrm.generic.FileUtility.DataBaseUtility;
import com.hrm.generic.FileUtility.ExcelFileUtility;
import com.hrm.generic.FileUtility.PropertiesFileUtility;
import com.hrm.objectrepositoryUtility.HomePage;
import com.hrm.objectrepositoryUtility.LoginPage;
import com.hrm.webdriverUtility.JavaUtility;
import com.hrm.webdriverUtility.WebDriverUtility;

public class BaseClass {

	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public PropertiesFileUtility putil = new PropertiesFileUtility();
	public DataBaseUtility dbutil=new DataBaseUtility();
	
	
	   public WebDriver driver=null; // declared globally
	   public static WebDriver sdriver=null;  // for parallel execution static driver is required
	   
	   
		
		@BeforeSuite(groups= {"smokeTest","regressionTest"})
		public void configBS() throws SQLException {
			System.out.println("======Connect to DB and Report Config=======");
			dbutil.getDbconnection();
		
			
		}
		
		@Parameters("BROWSER")          // for cross browsing we have to declare @parameters   
		@BeforeClass(groups= {"smokeTest","regressionTest"})
		public void configBC(@Optional("Chrome")String browser) throws Throwable {
			System.out.println("=======Launch the browser========");
			String BROWSER = browser;  // as we are using the system.property method
					//fLib.getDataFromPropertiesFile("browser");  // instead of reading data from property  file we will declare
			
				if (BROWSER.equalsIgnoreCase("chrome")) {
					driver=new ChromeDriver();  // initialization , decision of initialization is taken at run time
					
				}else if(BROWSER.equalsIgnoreCase("firefox")){    // instead of using variable as browser we will use  variable as BROWSER
					driver=new FirefoxDriver();
					
				}else if(BROWSER.equalsIgnoreCase("edge")) {
					driver=new EdgeDriver();
					
				} else {
					driver= new ChromeDriver();  // by default if not given then it will execute chrome 
				}	
			
			sdriver= driver;
			//  once the browser launching is done 
			//UtilityClassObject.setdriver(driver);
			
		}
		@BeforeMethod(groups= {"smokeTest","regressionTest"})
		public void configBM() throws Throwable {
			System.out.println("========Login======");
			String URL = putil.getDataFromPropertiesFile("url");    // reading data from cmd line by using system.getProperty
			String USERNAME = putil.getDataFromPropertiesFile("username");
			String PASSWORD = putil.getDataFromPropertiesFile("password");
			//String URL = System.getProperty("url");
			//String USERNAME = System.getProperty("username");
			//String PASSWORD = System.getProperty("password");
			
			LoginPage lp = new LoginPage(driver);
			lp.toLoginToApp(URL, USERNAME, PASSWORD);
			
			
		}
		
		@AfterMethod(groups= {"smokeTest","regressionTest"})
		public void configAM() {
			System.out.println("===========Logout========");
			HomePage hp= new HomePage(driver);
			hp.getLogoutBtn().click();
			
		}
		@AfterClass(groups= {"smokeTest","regressionTest"})
		public void configAC() {
			System.out.println("========close the browser===============");
			
			driver.quit();
		}
		
		
		@AfterSuite(groups= {"smokeTest","regressionTest"})
		public void configAS() throws SQLException {
			System.out.println("=======close the DB and Report BackUP=====");
			
			dbutil.closeDbconnection();
			
		}
		
		
		
	}



