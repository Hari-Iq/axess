package org.webelements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.BaseClass.SuperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults extends SuperClass {

	public SearchResults() {
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//div[@id='brandsRefinements']//li[@aria-labelledby=\"-title\"]//span[text()='"+Mobiles+"']")
	// private WebElement brand ;

	public void selectBrand(String Mobiles) {
		driver.findElement(By.xpath(
		"//div[@id='brandsRefinements']//li[@aria-labelledby=\"-title\"]//span[text()='" + Mobiles + "']"));
	}

	public void selectDisplay(String Display) {
		WebElement display = driver.findElement(By.xpath(
				"//span[contains(text(),'Display Type')]/parent::div/following-sibling::ul//span[@class='a-declarative']//span[text()='"
						+ Display + "']"));
		click(display);
	}

	public void getPrice() {
		List<WebElement> value = driver
				.findElements(By.xpath("//span[@class='a-price']//span[@class='a-price-whole']"));

		List<Integer> Prices = new ArrayList<>();
		for (WebElement priceElement : value) {
			String priceText = priceElement.getText().replace(",", ""); // Remove commas if any
			try {
				int price = Integer.parseInt(priceText); // Convert to integer
				Prices.add(price); // Add to integer list
			} catch (NumberFormatException e) {
				System.out.println("Unable to parse price: " + priceText);
			}
			Collections.sort(Prices);
			System.out.println(Prices);

		}
	}

	@FindBy(xpath="//span[text()='Featured']")
	private WebElement sort;
	public void clickSort() {
		click(sort);
		implicityWait(2);
	}
	
	@FindBy(xpath="//a[text()='Price: Low to High']")
	private WebElement low;
	public void clickLow() {
		click(low);
		
	}
	
	
	
	
	
}
