package com.hrms.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test(groups="smoke")
	public void validAdminLogin() {
		test.info("Entering valid admin credentials");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		// DashboardPageElements dashboard = new DashboardPageElements();
		test.info("Verifying valid username shows with welcome text");
		String expectedUser = "Welcome Admin";
		String actualUser = dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}

	@Test(groups="regression")
	public void invalidPasswordLogin() {
		test.info("Entering valid username and invalid password");
		// LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.loginBtn);
		test.info("Validating Invalid credentials error message");

		String expected = "Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}

	@Test(groups="regression")
	public void emptyUsernameLogin() {
		// LoginPageElements login = new LoginPageElements();
		test.info("Empty username and entering valid password");
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		test.info("Validating username cannot be empty error message");
		String expected = "Username cannot be empty";

		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	
	@Test
	public void timeStamp() {
		Date d=new Date();
		d.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		sdf.format(d.getTime());
	}
	
	
	
}