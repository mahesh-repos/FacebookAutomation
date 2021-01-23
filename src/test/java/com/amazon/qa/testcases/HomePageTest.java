package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.FriendsPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;


	public HomePageTest() {
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
	public void verifyHomePageTitleTest() {
		String homePagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle,"Facebook – log in or sign up", "Home Page title is not matched");
	}

	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority=3)
	public void verifyHomePageLogoTest() {
		Assert.assertTrue(homePage.validateHomePageLogoImage());
	}

	@Test(priority=4)
	public void clickfriendsPageLinkTest() {
		friendsPage = homePage.clickOnFriendsPageLinks();
	}




	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
}
