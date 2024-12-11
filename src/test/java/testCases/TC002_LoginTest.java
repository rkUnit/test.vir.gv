package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test
	public void verify_Login()
	{
		logger.info("*****Starting TC002_LoginTest*****");
		try {
		//homepage
		HomePage hp= new HomePage(driver);
		hp.clickmyaccount();
		hp.clickLogin();
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//myaccount
		MyAccountPage macc=new MyAccountPage(driver);
		Boolean target=macc.isMyAccountPageExist();
		
        //Assert.assertEquals(target,true,"login failed");
		Assert.assertTrue(target);
				}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC002_LoginTest*****");

	}
	
	

}
