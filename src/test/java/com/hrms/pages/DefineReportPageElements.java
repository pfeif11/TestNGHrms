package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class DefineReportPageElements {
	
	@FindBy(id="report_report_name")
	public WebElement reportName;
	
	@FindBy(id="report_criteria_list")
	public WebElement selectionCriteriaDD;
	
	@FindBy(id="report_include_comparision")
	public WebElement includeDD;
	
	@FindBy(id="report_display_groups")
	public WebElement displayFieldGroupsDD;
	
	@FindBy(id="report_display_field_list")
	public WebElement displayFieldsDD;
	
	@FindBy (id="btnSave")
	public WebElement saveButton;
	
	@FindBy (id="btnCancel")
	public WebElement cancelButton;
	
	@FindBy (id="btnAddConstraint")
	public WebElement selectionCriteriaAddButton;
	
	@FindBy (id="btnAddDisplayGroup")
	public WebElement displayFieldGroupsAddButton;
	
	@FindBy (id="btnAddDisplayField")
	public WebElement displayFieldsAddButton;
	
	@FindBy (id="report_language")
	public WebElement languageDD;
	
	
	
	
	
	
	
public DefineReportPageElements() {
	PageFactory.initElements(BaseClass.driver, this);
}

}
