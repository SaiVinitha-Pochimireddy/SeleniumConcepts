package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations {
	
	WebDriver driver;
	//@Test
	@BeforeClass(groups= {"sanity"})
	public void orangedemo()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("before method...");
	}
	
	@Test(priority=2, dataProvider="dp")
	public void login(String un,String pwd)
	{
		String str=driver.getTitle();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		System.out.println(str);
		String exp="OrangeHRM";
		SoftAssert sa= new SoftAssert();
		//Assert.assertEquals(str, exp);   //Hard Assert
		sa.assertEquals(str,exp); //Soft assert
	}
	
	@Test(priority=3, groups = {"reg"})
	public void gotonextpage()
	{
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
	}
	
	@Test(priority=400, groups= {"reg"})
	public void test3()
	{
		System.out.println("test method...");
	}
	
	@Test(priority=1000, groups= {"sanity"})
	public void test4()
	{
		System.out.println("4th test method...");
	}
	@AfterClass
	//@AfterMethod
	public void quit()
	{
		driver.quit();
		System.out.println("after method...");
	}
	
	@DataProvider(name="dp",indices= {0,1})
	String [] [] dataprovider()
	{
		String data[][]= {
					{"Admin","admin@123"},
					{"abc","1234"},
					{"sai","sai123"}
						};
		return data;
	}

}
