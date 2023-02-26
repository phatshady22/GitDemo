package shady.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shady.pageobjects.CheckOutPage;
import shady.pageobjects.OrderPage;

public class AbstractComponents {

	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractComponents(WebDriver driver2) {
		this.driver = driver2;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		PageFactory.initElements(driver,this);
	// TODO Auto-generated constructor stub
}


	@FindBy(css="li:nth-child(4) .btn.btn-custom")
	WebElement cartButton;
	@FindBy(css=".hero-primary")
	WebElement confirmationText;
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/myorders']")
	WebElement ordersButton;

	public void waitForElementToAppear(By findBy) {		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
public void waitForWebElementToAppear(WebElement findBy) {		
		
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	public void waitForElementToDissapear(By findBy){
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((findBy)));
		
	}
	
	public CheckOutPage goToCartPage() {
		cartButton.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
	
	public String getConfirmationText() {
		return confirmationText.getText();
		
	}
	
	public OrderPage goToOrders() {
		ordersButton.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	

}
