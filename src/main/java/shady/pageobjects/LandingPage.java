package shady.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shady.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordElement;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement loginError;
	
	public ProductCataloguePage loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordElement.sendKeys(password);
		submit.click();
		ProductCataloguePage productCatalogue = new ProductCataloguePage(driver);
		return productCatalogue;
	}
	
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getLoginError() {
		waitForWebElementToAppear(loginError);
		return loginError.getText();
	}
	
}
