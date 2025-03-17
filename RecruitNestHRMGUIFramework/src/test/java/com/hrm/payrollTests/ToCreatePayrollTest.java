package com.hrm.payrollTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.hrm.basetest.BaseClass;
import com.hrm.generic.FileUtility.ExcelFileUtility;
import com.hrm.objectrepositoryUtility.EmployeeInfoPage;
import com.hrm.objectrepositoryUtility.HomePage;
import com.hrm.objectrepositoryUtility.PayrollInfoPage;
import com.hrm.objectrepositoryUtility.SettingsPage;

public class ToCreatePayrollTest extends BaseClass {

	@Test(groups = "regressionTest")
	public void ToCreatePayrollWithEmployee_001() throws Throwable {
		// Navigate to Employee Module

		HomePage hp = new HomePage(driver);

		hp.getEmployeePageLink().click();

		Thread.sleep(3000);

		// Click on create employee

		EmployeeInfoPage eip = new EmployeeInfoPage(driver);
		eip.getAddEmployee().click();

		ExcelFileUtility eutil = new ExcelFileUtility();
		String empName = eutil.getDataFromExcelFile("Employees", 1, 2) + jutil.getRandomNumber(5000);
		String empEmail = eutil.getDataFromExcelFile("Employees", 1, 3) + jutil.getRandomNumber(5000) + "@gmail.com";
		String empPhone = eutil.getDataFromExcelFile("Employees", 1, 4) + jutil.getRandomNumber(9); // change in excel
																									// sheat according
																									// to the number
		String empUsername = eutil.getDataFromExcelFile("Employees", 1, 5) + jutil.getRandomNumber(5000);
		String empDesignation = eutil.getDataFromExcelFile("Employees", 1, 6) + jutil.getRandomNumber(5000);
		String empExperience = eutil.getDataFromExcelFile("Employees", 1, 7);
		String empProject = eutil.getDataFromExcelFile("Employees", 1, 8) + jutil.getRandomNumber(5000);
		// take input from Excel

		eip.getEmpNameEdit().sendKeys(empName);
		eip.getEmailEdit().sendKeys(empEmail);
		eip.getPhoneEdit().sendKeys(empPhone);
		eip.getUsernameEdit().sendKeys(empUsername);
		eip.getDesignationEdit().sendKeys(empDesignation);
		eip.getExperienceEdit().sendKeys(empExperience);
		eip.getProjectDropDown().sendKeys(empProject);
		eip.getProjectDropDown().sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);

		// Navigate to the payroll page
		// HomePage hp = new HomePage(driver);
		hp.getPayrollPageLink().click();

		PayrollInfoPage piap = new PayrollInfoPage(driver);
		piap.getHRAedit().sendKeys("500");
		piap.getStatbonusEdit().sendKeys("200");

		WebElement stat = piap.getStatusdropdwnEdit();
		wutil.toHandelDropdown(stat, 1);

		Actions action = new Actions(driver);

		action.scrollToElement(stat);
		String netearning = piap.getNetEarningSta().getText();
		String netpay = piap.getNetPaySta().getText();

		if (netearning.equals(netpay)) {
			System.out.println("employee payroll get updated");
		} else {
			System.out.println("payroll not updated");
		}

	}
	
	
	@Test(groups = "regressionTest")
	public void ToGenerateAuthTokenWithPayroll_002() throws Throwable {
		
		//navigate to settings page
		    HomePage hp = new HomePage(driver);
		    hp.getSettingsPageLink().click();
		    SettingsPage sp= new  SettingsPage(driver);
			
			  WebElement lifespan = sp.getSettingsDropDwn();
			  wutil.toHandelDropdown(lifespan, 0);
			  //  click on check box of payroll on read authorisation.
			  
			  sp.getPayrollcheckbox().click();
			  
			  // click on generate new token
			  sp.getTokenbutton().click();
			  String readbearerid = sp.getBearerId().getText();
			  
			  sp.getPayrollcreatecheckbox().click();
			  sp.getTokenbutton().click();
			     String createbearerid = sp.getBearerId().getText();
			     
			     if(!readbearerid.equals(createbearerid)) {
			    	 System.out.println("unique token id generated");
			    	 
			     }else {
			    	 System.out.println("Id is duplicate");
			     }	
		    
	}	

}
