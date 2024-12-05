package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {
	
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@Given("^Open any Browser$")
	public void open_any_Browser() throws IOException {
		driver = initializeDriver();
	}
	
	@And("^Navigate to Login page$")
	public void navigat_to_Login_page() {
		
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
		
	}
	
	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_and_password_into_the_fields(String email, String password) {
		
		loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		
	}
	
	@And("^User clicks on Login button$")
	public void user_clicks_on_Login_button() {
		
		loginPage.loginButton().click();
	}
	
	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {
		
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.editAccountInfoOption().isDisplayed());
	}
	
	@After
	public void closingBrowser() {
		driver.close();
	}

}