package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page factory - OR:
	@FindBy(name  ="email")
	WebElement  username;
	
	@FindBy(name  ="pass")
	WebElement  password;
	
	@FindBy(name  ="login")
	WebElement  loginbtn;
	
	@FindBy(xpath  ="//a[@id='u_0_2']")
	WebElement  signUp;
	
	@FindBy(xpath  ="//a[contains(text(),'Forgotten password?')]")
	WebElement  forgotPass;
	
	@FindBy(xpath  ="//div[@class='_8ice']//img[1]")
	WebElement  fbLogo;

	//Initializing the Page Object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatefbImage() {
	return fbLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
}
