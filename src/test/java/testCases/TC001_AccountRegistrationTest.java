package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.TestBaseClass;

public class TC001_AccountRegistrationTest extends TestBaseClass {	
	
	@Test
	public void verify_Account_Registration() {
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
		HomePage homePage= new HomePage(driver);
		homePage.clickAccount();
		logger.info("Clicked on MyAccount Link.. ");
		homePage.clickRegister();
		logger.info("Clicked on Register Link.. ");
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		logger.info("Providing customer details...");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		String password=randomAlphaNumeric();
		regPage.setTelephone(randomNumeric());
		regPage.setPassword(password);
		regPage.setCnfPassword(password);
		regPage.setPolicy();
		regPage.clickSubmit();
		logger.info("Validating expected message..");
		String cnfMsg=regPage.getConfirmationMessage();
		Assert.assertEquals(cnfMsg, "Your Account Has Been Created!");
		logger.info("Test passed");
	    }
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
		
	}
	

}
