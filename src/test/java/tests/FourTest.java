package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import resources.Base;

public class FourTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void fourTest() throws IOException, InterruptedException {
		
		System.out.println("Karan has updated this code wih this statement");
		System.out.println("Updated by Karan");
		
		System.out.println("Four test");
		driver = initializeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
				
	}
	
	@AfterMethod
	public void closingBrowser() {
		driver.close();
	}

}
