package shady.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shady.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	
	WebDriver driver;
	
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryEntry;
	
	@FindBy(xpath="//button[@class='ta-item list-group-item ng-star-inserted'][2]")
	WebElement countryName;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement proceed;
	
	
	
	public void countrySelect(){
		Actions a = new Actions(driver);
		a.sendKeys(countryEntry, "India").build().perform();	
		countryName.click();
	}
	
	public void goToConfirmation() {
		proceed.click();				
	}
	
	
	
	
	
	

}

 