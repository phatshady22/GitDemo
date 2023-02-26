package shady.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shady.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='cart']/ul/li/div/div/h3")
	List<WebElement> cartProducts;
	
	@FindBy(css="div ul li:nth-child(3) .btn.btn-primary")
	WebElement checkout;
	
	
	
	public Boolean cartCheck(String productName){
		return cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText()
				.equals(productName));		
	}
	
	public void goToCheckOut() {
		checkout.click();	
		//CheckOutPage checkoutPage = new CheckOutPage(driver);
		//return checkoutPage;
	}
	
	

}

 