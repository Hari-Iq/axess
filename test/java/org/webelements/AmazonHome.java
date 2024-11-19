
package org.webelements;

import org.BaseClass.SuperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHome extends SuperClass {
	
	  public AmazonHome(){
		  
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[text()='Hello, sign in']")
	private WebElement SignIn;
	public void clickSignInButton() {
		click(SignIn);}
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement Email;
	public void SetEmail() {fillTextBox(Email,"hari5262@gmail.com");}
	
	@FindBy(xpath="//span[@id='continue']")
	private WebElement Continue;
	public void clickContinue() {click(Continue);}
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement password;
	public void setPassword() {fillTextBox(password,"Hari@2019");}
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement submit;
	public void clickSubmit() {click(submit);;}
	
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchbox;
	public void setSearchText(String searchtext) {fillTextBox(searchbox, searchtext);}

	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchbtn;
	public void clickSearch() {click(searchbtn);}
	
	
	@FindBy(xpath="//span[text()='Hello, hariharan']")
	private WebElement hover;
	public WebElement hoverMenu() {
		return hover;
	}
	
	
	
	
}
