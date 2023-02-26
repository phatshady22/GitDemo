package shady.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import shady.TestComponents.BaseTest;
import shady.TestComponents.Retry;
import shady.pageobjects.CartPage;
import shady.pageobjects.CheckOutPage;
import shady.pageobjects.ProductCataloguePage;

public class ErrorValidationTests extends BaseTest {
	
	
	//lalalanddddddddd
	
		@Test(groups= {"errorValidation"}, retryAnalyzer=Retry.class)
		public void LoginErrorValidation() throws IOException {
			
							
			landingPage.loginApplication("meow@me.com", "Meowmeme2@");
			Assert.assertEquals(landingPage.getLoginError(), "Incorrect emailll or password.");		
			
		}	

} 
