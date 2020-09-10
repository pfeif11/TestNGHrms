package com.hrms.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddReportTest extends CommonMethods{
	
	@Test(groups= {"regression"})
	public void addReport() {
		
	test.info("Logging into Hrms");
	login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	
	test.info("navigating to Reports");
	dashboard.navigateToReports();
	wait(1);
	
	test.info("Click add button");
	click(empReports.addButton);
	
	test.info("enter Report name");
	String reportName="TTTest";
	sendText(defineReport.reportName,reportName );
	
	test.info("select Language in drop down");
	selectDdValue(defineReport.selectionCriteriaDD, "Language");
	click(defineReport.selectionCriteriaAddButton);
	
	test.info("select English in drop down");
	selectDdValue(defineReport.languageDD, "English");
	
	test.info("add personal and language in display field groups");
	
	
	selectDdValue(defineReport.displayFieldGroupsDD,"Personal");
	click(defineReport.displayFieldGroupsAddButton);
	selectDdValue(defineReport.displayFieldGroupsDD,"Languages");
	click(defineReport.displayFieldGroupsAddButton);
	test.info("click save");
	click(defineReport.saveButton);
	test.info("Verify Success Message is Displayed");
	empReports.successMessage.isDisplayed();
	takeScreenshot(reportName);
	String actualReportName=driver.findElement(By.xpath("//td[text()='"+reportName+"']")).getText();
	scrollToElement(driver.findElement(By.xpath("//td[text()='"+reportName+"']")));
	test.info("Taking screenshot");
	takeScreenshot(reportName);
	test.info("Verify Report name is present in list");
	Assert.assertEquals(reportName, actualReportName,"Could not find report!");
	
	}
	

}
