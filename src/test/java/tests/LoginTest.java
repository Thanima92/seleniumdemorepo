package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	WebDriver driver;
	Logger log;
	
	@Test(dataProvider ="getLoginData")
	public void login(String email, String password,String expectedResult) throws IOException {
		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");
		
		AccountPage accountPage = new AccountPage(driver);
		//Assert.assertTrue(accountPage.editAccountInfoOption().isDisplayed());
		
		String actualResult= null;
		try {
			if(accountPage.editAccountInfoOption().isDisplayed()) {
				log.debug("User got logged in");
				actualResult= "success";
			}
		}catch(Exception e) {
			log.debug("User didn't log in");
			actualResult="failure";
			}
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider 
	public Object[][] getLoginData() {
		Object[][] data = {{"selenium.tom2@gmail.com","qwerty", "success"},{"dummy@gmail.com","1234","failure"}};
		return data;
	}

}
