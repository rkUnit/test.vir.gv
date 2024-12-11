package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass{
	@Test
	public void verify_account_registration() {
		logger.info("*** starting TC001_AccountRegistration***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		logger.info("*** Clicked on my account link***");
		hp.clickRegister();
		logger.info("*** Clicked on Register ***");
		AccountRegistrationPage ap=new AccountRegistrationPage(driver);
		logger.info("*** Providing input details***");

		ap.setFirstName(randomeString().toUpperCase());
		ap.setLastName(randomeString().toUpperCase());
		ap.setEmail(randomeString()+"@gmail.com"); //randomly generated
		ap.setTelephone(randomeNumber());

		String Password=randomeAlphaNumeric();

		ap.setPassword(Password);
		ap.setConfirmPassword(Password);

		ap.setPrivacyPolicy();
		ap.clickContinue();
		logger.info("*** validating expexted msg***");
		String confmsg=ap.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}catch(Exception e)
		{
		logger.error("Test Failed");
		logger.debug("debug logs--**");
		Assert.fail();
		}
		logger.info("TC001_AccountRegistartionPassed");
	}


}
