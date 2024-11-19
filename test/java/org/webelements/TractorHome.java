package org.webelements;

import org.BaseClass.SuperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TractorHome extends SuperClass{
	
	public  TractorHome() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@aria-label='search'])[1]")
	private WebElement search  ;
	
	public WebElement getSearch() {
		return search;
	}

	@FindBy(xpath="(//button[@aria-label='Search'])[1]")
	private WebElement Searchbtn;
	
	public WebElement getSearchbtn() {
		return Searchbtn;
	}
	

}
