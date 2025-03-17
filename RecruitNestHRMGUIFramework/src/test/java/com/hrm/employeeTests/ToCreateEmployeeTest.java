package com.hrm.employeeTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hrm.basetest.BaseClass;
import com.hrm.generic.FileUtility.ExcelFileUtility;
import com.hrm.objectrepositoryUtility.EmployeeInfoPage;
import com.hrm.objectrepositoryUtility.HomePage;
import com.hrm.objectrepositoryUtility.PayrollInfoPage;
import com.hrm.objectrepositoryUtility.SettingsPage;
import com.hrm.webdriverUtility.WebDriverUtility;

public class ToCreateEmployeeTest extends BaseClass {

	@Test(groups = "smoke")
	public void ToCreateEmployeeTest_001() throws Throwable {

		// Navigate to Employee Module
		HomePage hp = new HomePage(driver);
		hp.getEmployeePageLink().click();

		Thread.sleep(3000);

		// Click on create employee

		EmployeeInfoPage eip = new EmployeeInfoPage(driver);
		System.out.println("Execute");
		eip.getAddEmployee().click();
		// To read from excel
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

		WebElement email = eip.getSearchbyDropdown();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toHandelDropdown(email, 1);

		eip.getSearchEmpEdt().sendKeys(empEmail);

		WebElement phone = eip.getSearchbyDropdown();
		wutil.toHandelDropdown(phone, 2);

		eip.getSearchEmpEdt().sendKeys(empPhone);

		String Phone = eip.getSearchEmpEdt().getText();

		String Email = eip.getSearchEmpEdt().getText();

		/*
		 * if(Email.contains(empEmail)) { System.out.println(empName
		 * +"---------verified"); } else { System.out.println(empName+
		 * "--------NotVerified"); } if(Phone.contains(empPhone)) {
		 * System.out.println(empPhone + "---------verified"); } else {
		 * System.out.println(empPhone+ "--------NotVerified"); }
		 */
		// To verify email
		Assert.assertTrue(Email.contains(empEmail));

		// To verify Phone
		Assert.assertTrue(Phone.contains(empPhone));

	}

	@Test(groups = "regressionTest")
	public void ToCreateEmployeePayrollTest_002() throws Throwable {
		// Navigate to Employee Module
		HomePage hp = new HomePage(driver);
		hp.getEmployeePageLink().click();

		Thread.sleep(3000);

		// Click on create employee

		EmployeeInfoPage eip = new EmployeeInfoPage(driver);
		eip.getAddEmployee().click();

		// To read from excel
		ExcelFileUtility eutil = new ExcelFileUtility();
		String empName = eutil.getDataFromExcelFile("Employees", 1, 2) + jutil.getRandomNumber(5000);
		String empEmail = eutil.getDataFromExcelFile("Employees", 1, 3) + jutil.getRandomNumber(5000) + "@gmail.com";
		String empPhone = eutil.getDataFromExcelFile("Employees", 1, 4) + jutil.getRandomNumber(9);
		String empUsername = eutil.getDataFromExcelFile("Employees", 1, 5) + jutil.getRandomNumber(5000);
		String empDesignation = eutil.getDataFromExcelFile("Employees", 1, 6) + jutil.getRandomNumber(5000);
		String empExperience = eutil.getDataFromExcelFile("Employees", 1, 7);
		String empProject = eutil.getDataFromExcelFile("Employees", 1, 8) + jutil.getRandomNumber(5000);

		eip.getEmpNameEdit().sendKeys(empName);
		eip.getEmailEdit().sendKeys(empEmail);
		eip.getPhoneEdit().sendKeys(empPhone);
		eip.getUsernameEdit().sendKeys(empUsername);
		eip.getDesignationEdit().sendKeys(empDesignation);
		eip.getExperienceEdit().sendKeys(empExperience);
		eip.getProjectDropDown().sendKeys(empProject);
		eip.getAddButton().click();

		// To navigate to payroll page
		// HomePage hp = new HomePage(driver);
		hp.getPayrollPageLink().click();

		// Select search employee by name

		PayrollInfoPage pip = new PayrollInfoPage(driver);
		WebElement name = pip.getPayrollsearchdrpdwn();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toHandelDropdown(name, 1);
		pip.getPayrollsearchdrpdwn().click();

		pip.getPayrollsearchbyName().sendKeys(empName);

		// verify

		String Name = pip.getPayrollsearchbyName().getText();

		// To verify the name in payroll page
		Assert.assertTrue(Name.contains(empName));

	}

	@Test(groups = "regressionTest")
	public void ToGenerateAuthTokenWithEmployee_003() throws Throwable {

		// Navigate to Settings Module
				HomePage hp = new HomePage(driver);
				hp.getSettingsPageLink().click();
			  Thread.sleep(2000);
			  SettingsPage sp = new SettingsPage(driver);
			  WebElement lifespan = sp.getSettingsDropDwn();
			  wutil.toHandelDropdown(lifespan, 0);
			  //  click on check box of employee on read authorisation.
			  
			  sp.getEmpreadcheckbox().click();
			  
			  // click on generate new token
			  sp.getTokenbutton().click();
			  String readbearerid = sp.getBearerId().getText();
			  
			  sp.getEmpcreatecheckbox().click();
			  sp.getTokenbutton().click();
			     String createbearerid = sp.getBearerId().getText();
			     
			     if(!readbearerid.equals(createbearerid)) {
			    	 System.out.println("unique token id generated");
			    	 
			     }else {
			    	 System.out.println("Id is duplicate");
			     }
			 
			  
			  
	

}
}
