package org.sam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sa.BaseClass;

public class SignINPojo extends BaseClass {

	//constructor
	public SignINPojo() {
		PageFactory.initElements(driver, this);
	}
	
	//create new account
	@FindBy(xpath = "//a[text()='Create new account']")
	private WebElement createNewAcc;
	
	//First Name
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement firstnameTxtBox;
	
	//Second Name
	@FindBy(name = "lastname")
	private WebElement secondnameTxtBox;
	
	//email
	@FindBy(name = "reg_email__")
	private WebElement emailTxtBox;
	
	//password
	@FindBy(name="reg_passwd__")
	private WebElement pwdTxtBox;

	public WebElement getCreateNewAcc() {
		return createNewAcc;
	}

	public WebElement getFirstnameTxtBox() {
		return firstnameTxtBox;
	}	

	public WebElement getSecondnameTxtBox() {
		return secondnameTxtBox;
	}

	public WebElement getEmailTxtBox() {
		return emailTxtBox;
	}

	
	
}
