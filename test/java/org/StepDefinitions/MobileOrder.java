package org.StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.BaseClass.SuperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.webelements.AmazonHome;
import org.webelements.SearchResults;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MobileOrder extends SuperClass{
		
	  AmazonHome home;
	  SearchResults sch;
	 
	 @Given("Launch browser and navigate to amazon web page and sign in")
	 public void launch_browser_and_navigate_to_amazon_web_page_and_sign_in() throws InterruptedException {
		 toGetChrome();
		 launchUrl("https://www.amazon.in/");
		 Thread.sleep(2);
		 
	 }
	 

	 
	 @When("Login into amazon")
	 public void login_into_amazon() {
		 home = new AmazonHome();
		 home.clickSignInButton();implicityWait(5);;
		 
		 home.SetEmail();
		 home.clickContinue();implicityWait(2);
		 home.setPassword();
		 home.clickSubmit();implicityWait(5);
	 }
	 
	 @When("Enter Search prompt mobiles in search bar and click search")
	 public void enter_Search_prompt_mobiles_in_search_bar_and_click_search() {
		 home = new AmazonHome();
		 home.setSearchText("mobiles");
		 home.clickSearch();
		 implicityWait(5);
		 
	 }
	 @When("Select any three brands in category")
	 public void select_any_three_brands_in_category(DataTable brands) throws InterruptedException{
		 sch = new SearchResults();
		 
		 List<String> data = brands.asList();
		  
	        for (String brand : data) {
	        	WebElement check = driver.findElement(By.xpath("//div[@id='brandsRefinements']//li[@aria-labelledby=\"-title\"]//span[text()='" + brand + "']"));
	        	
	        	if (!check.isSelected()) {
	                click(check);
	        	}}}
	 

	 @When("Select Display type as {string}")
	 public void select_Display_type_as(String display) {
		 sch = new SearchResults();
		 
		 WebElement type = driver.findElement(By.xpath(
					"//span[contains(text(),'Display Type')]/parent::div/following-sibling::ul//span[@class='a-declarative']//span[text()='"
							+ display + "']"));
		 
		 if (!type.isSelected()) {
             click(type);
		 }}

	 
	/* @When("Click minimum price mobile from search results")
	 public void click_minimum_price_mobile_from_search_results() {
		 /*
		 List<WebElement> value = driver
					.findElements(By.xpath("//span[@class='a-price']//span[@class='a-offscreen']"));
		 
		 
		 int size = value.size();
		 System.out.println(size);
	 
		 
		 /*for (int i=0; i<value.size(); i++) {
			 		
			 WebElement price = value.get(i);
			 String text = price.getText();
			 System.out.println(text);
		 }}
		 
		 
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
			}
			System.out.println(Prices);
	 }*/

	/* @Then("Navigate to products page")
	 public void navigate_to_products_page() {
	 }

	 @When("Click add to Cart")
	 public void click_add_to_Cart() {
	 }

	 @When("Click proceed to checkout from Nav bar")
	 public void click_proceed_to_checkout_from_Nav_bar() {
	 }

	 @When("Click Add new address")
	 public void click_Add_new_address() {
	 }

	 @When("Fill out new address form and click Use address button")
	 public void fill_out_new_address_form_and_click_Use_address_button() {
	 }

	 @Then("Verify Payment method button was visible")
	 public void verify_Payment_method_button_was_visible() {
	 }
}*/
	 
	 
@When("Hover on nav bar in Accounts & Lists")
public void hover_on_nav_bar_in_Accounts_Lists() {
	home = new AmazonHome();
	
	WebElement hoverMenu = home.hoverMenu();
	movetoElement(hoverMenu);
	
	implicityWait(5);
}

/*@When("verify all links under your accounts")
public void verify_all_links_under_your_accounts(DataTable alllinks) {
	
	home = new AmazonHome();
	
	List<String> data = alllinks.asList();
	
	WebElement navi = driver.findElement(By.xpath("//a[@class='nav-link nav-item']"));
	
	for (String link : data) {
		List<WebElement> elements = navi.findElements(By.xpath("//span[text()='"+link+"']"));
	}*/

	@When("verify all links under your accounts")
	public void verify_all_links_under_your_accounts() {
		
		home = new AmazonHome();
		
		List<WebElement> links = driver.findElements(By.xpath("//a[@class='nav-link nav-item']"));
		
		System.out.println("Links Under Nav bar :"+links.size());
		
		for(WebElement link : links) {
			
			String url = link.getAttribute("href");
			
			if (url == null || url.isEmpty()) {
	            System.out.println("Link is empty or missing: " + link.getText());
	            continue;
			}
	            try {
	                // Open a new tab and navigate to the URL
	            	 String originalWindow = driver.getWindowHandle();
	            	 driver.switchTo().newWindow(WindowType.TAB);
	                driver.navigate().to(url);
	                
	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	                wait.until(ExpectedConditions.titleIs(driver.getTitle()));

	                // Check if the page loads successfully
	                String pageTitle = driver.getTitle();

	                // Validate the title or any element to confirm page loaded
	                if (pageTitle != null && !pageTitle.isEmpty()) {
	                    System.out.println("Valid link: " + url + " | Page Title: " + pageTitle);
	                } else {
	                    System.out.println("Broken link: " + url + " | Page title is empty.");
	                }
	                
	                driver.close();
	                driver.switchTo().window(originalWindow);
	                
	            } catch (Exception e) {
	                System.out.println("Error navigating to link: " + url + " | Exception: " + e.getMessage());
	            }}
		
	}}
		
		
		