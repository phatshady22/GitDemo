package shady.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shady.TestComponents.BaseTest;
import shady.pageobjects.CartPage;
import shady.pageobjects.CheckOutPage;
import shady.pageobjects.LandingPage;
import shady.pageobjects.OrderPage;
import shady.pageobjects.ProductCataloguePage;

public class SubmitOrderTests extends BaseTest {
	String productName = "ADIDAS ORIGINAL";		

	@Test(dataProvider="getData",groups = {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
		
					
		ProductCataloguePage productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));		
		List<WebElement> products = productCatalogue.getProductList();
		WebElement productNameElement = productCatalogue.getProductByName(input.get("product"));
		CartPage cartPage = productCatalogue.addProductToCart(productNameElement);
		CheckOutPage checkOutPage = productCatalogue.goToCartPage();		
		Assert.assertTrue(cartPage.cartCheck(input.get("product")));		
		cartPage.goToCheckOut();
		checkOutPage.countrySelect();
		checkOutPage.goToConfirmation();            
        Assert.assertTrue(checkOutPage.getConfirmationText().
        		equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCataloguePage productCatalogue = landingPage.loginApplication("me@me.com", "Mememe2@");
		OrderPage ordersPage = productCatalogue.goToOrders();	
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
		
	}
	
	@DataProvider
	public Object[][] getData() throws Exception
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/shady/data/PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};


	}
	
	
}
