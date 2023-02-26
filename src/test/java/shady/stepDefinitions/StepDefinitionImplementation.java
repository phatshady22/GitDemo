package shady.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shady.TestComponents.BaseTest;
import shady.pageobjects.CartPage;
import shady.pageobjects.CheckOutPage;
import shady.pageobjects.LandingPage;
import shady.pageobjects.ProductCataloguePage;

//TidyGherkin is awesome

public class StepDefinitionImplementation extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCataloguePage productCatalogue;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		
		landingPage = launchApplication();
		
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)  {
		productCatalogue = landingPage.
				loginApplication(username, password);	
		
		
	}
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName)  {
		List<WebElement> products = productCatalogue.getProductList();
		WebElement productNameElement = productCatalogue.getProductByName(productName);
		cartPage = productCatalogue.addProductToCart(productNameElement);
		
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)  {
		
		checkOutPage = productCatalogue.goToCartPage();		
		Assert.assertTrue(cartPage.cartCheck(productName));		
		cartPage.goToCheckOut();
		checkOutPage.countrySelect();
		checkOutPage.goToConfirmation();  
	}
	
	@Then("{string} is displayed on confirmation page")
	public void message_displayed_confirmationPage(String string)  {
		           
        Assert.assertTrue(checkOutPage.getConfirmationText().
        		equalsIgnoreCase(string));
        driver.close();
	}

	@Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
		
		Assert.assertEquals(landingPage.getLoginError(), strArg1);		
        driver.close();
    }
	
	

	
	
}
