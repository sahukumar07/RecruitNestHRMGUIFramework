package com.hrm.projectTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.basetest.BaseClass;
import com.hrm.generic.FileUtility.ExcelFileUtility;
import com.hrm.objectrepositoryUtility.HomePage;
import com.hrm.objectrepositoryUtility.ProjectInfoPage;
import com.hrm.objectrepositoryUtility.SettingsPage;
import com.hrm.webdriverUtility.WebDriverUtility;

public class ToCreateProjectTest extends BaseClass {

	@Test(groups = "smoke")

	public void ToCreateProjectTest_001() throws Throwable {

		// Navigate to Project Module
		HomePage hp = new HomePage(driver);
		hp.getProjectPageLink().click();

		// Click on create project

		ProjectInfoPage pip = new ProjectInfoPage(driver);
		pip.getCreateProjectPage().click();

		// To read from excel
		ExcelFileUtility eutil = new ExcelFileUtility();
		String projectName = eutil.getDataFromExcelFile("Projects", 1, 2) + jutil.getRandomNumber(576);
		String projectManager = eutil.getDataFromExcelFile("Projects", 1, 3) + jutil.getRandomNumber(456);

		WebElement status = pip.getStatusDropDown();
		wutil.toHandelDropdown(status, 0);

		pip.getSubmitbtn().click();

		// verify by projectName
		WebElement proname = pip.getProsearchbydrpdown();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toHandelDropdown(proname, 1);

		pip.getProsearchbynameedt().sendKeys(projectName);

		WebElement proMang = pip.getProsearchbydrpdown();

		wutil.toHandelDropdown(proMang, 2);
		
		pip.getProsearchbynameedt().sendKeys(projectManager);
		
		//verify by Project name


		String projName = pip.getProsearchbynameedt().getText();

		Assert.assertTrue(projName.contains(projectName));
		
		// verify by ProjectManagger
		
		String proMng = pip.getProsearchbynameedt().getText();
		Assert.assertTrue(proMng.contains(projectManager));
	
	}
	@Test(groups = "regressionTest")
	public void ToGenerateAuthTokenWithProject_002() throws Throwable {
		
		//navigate to settings page
		    HomePage hp = new HomePage(driver);
		    hp.getSettingsPageLink().click();
		
		 SettingsPage sp= new  SettingsPage(driver);
	
		  WebElement lifespan = sp.getSettingsDropDwn();
		  wutil.toHandelDropdown(lifespan, 0);
		  //  click on check box of project on read authorisation.
		  
		  sp.getProreadcheckbox().click();
		  
		  // click on generate new token
		  sp.getTokenbutton().click();
		  String readbearerid = sp.getBearerId().getText();
		  
		  sp.getProcreatecheckbox().click();
		  sp.getTokenbutton().click();
		     String createbearerid = sp.getBearerId().getText();
		     
		     if(!readbearerid.equals(createbearerid)) {
		    	 System.out.println("unique token id generated");
		    	 
		     }else {
		    	 System.out.println("Id is duplicate");
		     }
		 
		  
		 
		
	
	
	
	

}
}

