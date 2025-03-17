package com.hrm.objectrepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.webdriverUtility.WebDriverUtility;

public class EmployeeInfoPage extends WebDriverUtility {
	WebDriver driver;
	
	 public EmployeeInfoPage(WebDriver driver)	{
		 this.driver=driver;
			PageFactory.initElements( driver,this);
		 
	 }
	
	@FindBy(xpath = "(//i[@class='material-icons'])[1]")

	private WebElement AddEmployee;
	
	@FindBy(xpath ="//div[@role='dialog']//form//div[2]//div[1]//input[@type='text']")
	
	 private WebElement EmpNameEdit;
	
	@FindBy(xpath="//div[@role='dialog']//form//div[2]//div[2]//input[@type='email']")
	 private WebElement EmailEdit;
	
	@FindBy(xpath="(//div[@class='modal-body'])[3]//div[3]//input[@type='text']")
	 private WebElement phoneEdit;
	
	@FindBy(xpath="//div[@role='dialog']//form//div[2]//div[4]//input[@type='text']")
	 private WebElement usernameEdit;
	
	@FindBy(xpath="//div[@role='dialog']//form//div[2]//div[5]//input[@type='text']")
	 private WebElement DesignationEdit;
	
	@FindBy(xpath="//div[@role='dialog']//form//div[2]//div[6]//input[@type='text']")
	 private WebElement ExperienceEdit;
	
	@FindBy(xpath="//select[@name='project']")
	 private WebElement ProjectDropDown;
	
	@FindBy(xpath="//span[text()='Delete']")
	 private WebElement SelectedDeleteButton;
	
	@FindBy(xpath ="//input[@value='Add' and @class='btn btn-success']")
	 private WebElement AddButton;
	
	@FindBy(xpath ="//select[@class='form-control']")
	 private WebElement SearchbyDropdown;
	
	@FindBy(xpath ="//input[@placeholder='Search by Email']")
	 private WebElement SearchEmpEdt;
	
	@FindBy(xpath ="//i[@title='Edit'][1]")
	 private WebElement EmpEditButton;
	
	@FindBy(xpath ="(//i[@title='Delete'])[1]")
	 private WebElement DeleteEmpBtn;
	
	
	
	
	
	public WebElement getSelectedDeleteButton() {
		return SelectedDeleteButton;
	}

	

	public WebElement getEmpEditButton() {
		return EmpEditButton;
	}


	public WebElement getDeleteEmpBtn() {
		return DeleteEmpBtn;
	}


	public WebElement getAddEmployee() {
		return AddEmployee;
	}

	public WebElement getEmpNameEdit() {
		return EmpNameEdit;
	}

	public WebElement getEmailEdit() {
		return EmailEdit;
	}

	public WebElement getPhoneEdit() {
		return phoneEdit;
	}

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getDesignationEdit() {
		return DesignationEdit;
	}

	public WebElement getExperienceEdit() {
		return ExperienceEdit;
	}

	public WebElement getProjectDropDown() {
		return ProjectDropDown;
	}

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getAddButton() {
		return AddButton;
	}

	public WebElement getSearchbyDropdown() {
		return SearchbyDropdown;
	}

	public WebElement getSearchEmpEdt() {
		return SearchEmpEdt;
	}
	
	
	
	public void scrooldown(WebDriver driver) {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		for(;;) {
			try {
			  driver.findElement(By.xpath("//input[@value='Add']")).click();
				//driver.findElement(By.xpath("//input[@value='Add']/../../div[3]/input[2]"));
				break;
			}catch(Exception e) {
				
				js.executeScript("window.scrollBy(0,300)");
			}
		}
		
		
	}

	
}
