package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {

	WebDriver driver;
	PageObjectClass poc;
	@BeforeClass
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Login()
	{
		poc.SetUsername("Admin");
		poc.SetPassword("admin123");
		poc.Login();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority=1)
	public void Logo()
	{
		poc=new PageObjectClass(driver);
		Assert.assertEquals(poc.CheckLogoPresence(),true);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
