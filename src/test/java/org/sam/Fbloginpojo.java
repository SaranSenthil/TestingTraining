package org.sam;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fbloginpojo extends BaseClass{
	public  Fbloginpojo(){
		PageFactory.initElements(driver,this);
	}
	//2.Private web elements
	/*
	 * @FindAll({
	 * 
	 * @FindBy(xpath="//input[@id='email']"),
	 * 
	 * @FindBy(xpath="//input[@name='email']"),
	 * 
	 * @FindBy(xpath="//input[@data-testid='royal-email']") })
	 * 
	 * private WebElement varRef;
	 */
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;

		@FindBy(xpath="//input[@aria-label='Password']")
		private WebElement password;
		
		@FindBy(name="login")
		private WebElement login;
		//3.Getters to access webelement outside the class

		
		/*
		 * public WebElement getVarRef() { return varRef; }
		 */
		public WebElement getEmail() {
			return email;
		}
		public WebElement getPassword() {
			return password;
		}

		public WebElement getLogin() {
			return login;
		}

}
