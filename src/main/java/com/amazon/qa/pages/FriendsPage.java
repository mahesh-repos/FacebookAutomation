package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class FriendsPage extends TestBase {

	
	//Page Factory
	@FindBy(xpath = "//*[name()='path' and contains(@class,'p361ku9c')]")
	WebElement friendsLable;
	
	@FindBy(xpath = "//span[contains(text(),'Karan Chavan')]")
	WebElement friendsName;
	
	
	//Initializing the Page Object
			public FriendsPage() {
				PageFactory.initElements(driver, this);
			}
		
			//Action
			public boolean verifyfriednsLable() {
			return	friendsLable.isDisplayed();
			
			}
			
			public void selectFriend() {
			
			friendsName.click();
	//	return new FriendsPage();
			}
			
	
	
}
