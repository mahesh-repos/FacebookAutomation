package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement friendPageLinks;
	
//	@FindBy(xpath = "//span[contains(text(),'Groups')]")
//	WebElement groupsPageLinks;
//	
//	@FindBy(xpath = "//span[contains(text(),'Events')]")
//	WebElement eventsPageLinks;
	
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M15 35.8C6')]")
	WebElement homePageFbLogo;
	
	@FindBy(xpath = "//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'][normalize-space()='Aditya']")
	WebElement userNameLable;
	
	
//	@FindBy(xpath = "//span[contains(text(),'Marketplace')]")
//	WebElement marketPlacePageLinks;
//	
//	@FindBy(xpath = "//input[@placeholder='Search Facebook']")
//	WebElement searchBox;
	
	@FindBy(xpath = "//span[contains(text(),'Sujit Gaikwad')]")
	WebElement nameClick;
	
	
	//Initializing the Page Object
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
		//Actions
		public String verifyHomePageTitle() {
		return	driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() {
			return userNameLable.isDisplayed();
		}
		
		public boolean validateHomePageLogoImage() {
			return homePageFbLogo.isDisplayed();
			}
	
		public FriendsPage clickOnFriendsPageLinks()  {
			friendPageLinks.click();
//			nameClick.click();
			return new FriendsPage();
			
		}
	
//		public GroupsPage clickOnGroupsPageLinks() {
//			groupsPageLinks.click();
//			return new GroupsPage();
//		}
		
//		public EventsPage clickOnEventsPageLinks() {
//			eventsPageLinks.click();
//			return new EventsPage();
//		}
//	
//		public MarketPlacePage clickOnMarketPlacePageLinks() {
//			marketPlacePageLinks.click();
//			return new MarketPlacePage();
//		}
//	
	
	
}
