package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeReportsPageElements {
	
	@FindBy(id="btnAdd")
	public WebElement addButton;
	
	@FindBy (xpath="//div[contains(@class,'success')]")
	public WebElement successMessage;
	
	
	
	
	public EmployeeReportsPageElements( ) {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
