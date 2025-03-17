package com.hrm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayrollInfoPage {
	
	
	
	WebDriver driver;
	
	 public PayrollInfoPage(WebDriver driver)	{
		 this.driver=driver;
			PageFactory.initElements( driver,this);
		 
	 }
	
	@FindBy(xpath="(//i[@class='material-icons'])[2]")
	
	private WebElement EditButton;
	
     @FindBy(xpath="//div[@class='table-title']//select[@class='form-control']")
	
	   private WebElement payrollsearchdrpdwn;
     
     @FindBy(xpath="//div[@class='table-title']//div[1]//div[4]//input[@type='text']")
 	
	   private WebElement payrollsearchbyName;
     
     @FindBy(xpath="//form//div[2]//div[2]//div[2]//input[@class='form-control']")
  	
	   private WebElement HRAedit;
     
     @FindBy(xpath="(//div[@class='form-group']//input[@class='form-control'])[3]")
     
     private WebElement StatbonusEdit;
     
       @FindBy(xpath="//select[@name='status']")
     
     private WebElement StatusdropdwnEdit;
       @FindBy(xpath=" //input[@value='Save']")
       
       private WebElement SaveBtn;
      @FindBy(xpath="//th[text()='Net Pay']")
       
       private WebElement netPaySta;
      
      @FindBy(xpath="//th[text()='Deductions']")
      
      private WebElement netDeductionSta;
      
      @FindBy(xpath="//th[text()='Earnings']")
      
      private WebElement netEarningSta;
     
    
     

	public WebElement getNetPaySta() {
		return netPaySta;
	}


	public WebElement getNetDeductionSta() {
		return netDeductionSta;
	}


	public WebElement getNetEarningSta() {
		return netEarningSta;
	}


	public WebElement getHRAedit() {
		return HRAedit;
	}


	public WebElement getStatbonusEdit() {
		return StatbonusEdit;
	}


	public WebElement getStatusdropdwnEdit() {
		return StatusdropdwnEdit;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}


	public WebElement getEditButton() {
		return EditButton;
		
	}


	public WebElement getPayrollsearchdrpdwn() {
		return payrollsearchdrpdwn;
	}


	public WebElement getPayrollsearchbyName() {
		return payrollsearchbyName;
	}
	
	
	

}
