package shady.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shady.AbstractComponents.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents {
	
	WebDriver driver;
	
	
	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".col-lg-4");
	By addToCart = By.cssSelector("button:nth-child(4)");
	By toastMessage = By.cssSelector("#toast-container");
	By spinner = By.xpath("//ngx-spinner");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = products.stream().filter(product -> 
		product.findElement(By.tagName("b")).getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public CartPage addProductToCart(WebElement prod){
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDissapear(spinner);
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	
	
	
}
