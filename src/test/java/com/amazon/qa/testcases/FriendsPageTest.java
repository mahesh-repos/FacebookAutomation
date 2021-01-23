package com.amazon.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.FriendsPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class FriendsPageTest extends TestBase {

	
	
	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;


	public FriendsPageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		friendsPage = new FriendsPage();
		loginPage = new LoginPage();
		homePage =	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyFriendsPageLableTest() throws InterruptedException {
		homePage.clickOnFriendsPageLinks();
		Assert.assertTrue(friendsPage.verifyfriednsLable(),"Friend lable is missing on the page");
	//	friendsPage.selectFriend();
	}
	
	@Test(priority=2)
	public void selectFriendTest() throws InterruptedException {
	//	homePage.clickOnFriendsPageLinks();
		friendsPage.selectFriend();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
	
}
