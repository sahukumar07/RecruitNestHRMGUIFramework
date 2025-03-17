package com.hrm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.webdriverUtility.WebDriverUtility;

public class ProjectInfoPage {
	WebDriverUtility wutil= new WebDriverUtility();
	
	WebDriver driver;
	 public ProjectInfoPage(WebDriver driver)	{
		 this.driver=driver;
			PageFactory.initElements( driver,this);
		 
	 }
	
	
	@FindBy(xpath="(//i[@class='material-icons'])[1]")
	 private WebElement CreateProjectPage;
	
	@FindBy(partialLinkText ="Export Projects")
	private WebElement ExportProjectPage;
	
	@FindBy(xpath="//div[@role='dialog']//form//div[2]//div[1]//input[@type='text']")
	private WebElement ProjectNameEdt ;
	
	@FindBy(xpath="//div[@role='dialog']//form//div[2]//div[3]//input[@type='text']")
	private WebElement CreatedByEdt ;
	
	@FindBy(xpath="//div[@role='dialog']//form//div[2]//div[4]//select[@name='status']")
	
	//div[@class='ReactModal__Content ReactModal__Content--after-open']//form//div[2]//div[4]//select[@name='status']

	private WebElement StatusDropDown;
	
	@FindBy(xpath="//input[@type='submit']")
	
	private WebElement submitbtn;
	
    @FindBy(xpath="//div[@class='table-title']//div[1]//div[3]//select[@class='form-control']")
	
	private WebElement prosearchbydrpdown;
    
   @FindBy(xpath="//div[@class='table-title']//div[1]//div[4]//input[@type='text']")
	
	private WebElement prosearchbynameedt;
    
    

	public WebElement getCreateProjectPage() {
		return CreateProjectPage;
	}

	public WebElement getExportProjectPage() {
		return ExportProjectPage;
	}

	public WebElement getProjectNameEdt() {
		return ProjectNameEdt;
	}

	public WebElement getCreatedByEdt() {
		return CreatedByEdt;
	}

	public WebElement getStatusDropDown() {
		return StatusDropDown;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	
	public WebElement getProsearchbydrpdown() {
		return prosearchbydrpdown;
	}

	

	public WebElement getProsearchbynameedt() {
		return prosearchbynameedt;
	}


	public void createProjectInfo(String projectname, String projectmanager) {
		ProjectNameEdt.sendKeys(projectname);
		CreatedByEdt.sendKeys(projectmanager);
		submitbtn.click();
		
	}
	
	

}
