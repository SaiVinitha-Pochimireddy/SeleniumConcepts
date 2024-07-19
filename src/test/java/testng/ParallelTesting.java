package testng;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting {
	
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser","url"})
	void setup(String br,String url)
	{
		if(br.equals("edge"))
		{
			
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void login()
	{
		String str=driver.getTitle();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		System.out.println(str);
		String exp="OrangeHRM";
		SoftAssert sa= new SoftAssert();
		//Assert.assertEquals(str, exp);   //Hard Assert
		sa.assertEquals(str,exp); //Soft assert
	}
}
