package WdDriverMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getandBrowserMethods {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//we can access driver and browser methods through webdriver instance(obj) only.
		//1. get(url)
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//2. getTitle()
		System.out.println(driver.getTitle());
		
		//3. getCurrentUrl()
		System.out.println(driver.getCurrentUrl());
		
		//4. getPageSource()  we will get all the HTML code
		String ps=driver.getPageSource();
		System.out.println(ps);
		System.out.println(ps.contains("img")); //true/false
		
		//5. getWindowHandle()  gives unique Id which is generated for the current web page while automating
		System.out.println(driver.getWindowHandle());
		
		//opening another tab through automation only
		driver.findElement(By.linkText("nopCommerce")).click();
		
		//6. getWindowHandles()  gives unique Ids which is generated for all the web pages while automating
		Set<String> winhdls=driver.getWindowHandles();
		for(String winid:winhdls)
		{
			System.out.println(winid);
		}
		
		//1. close() it will close only 1 browser window which is opened by driver class
		//driver.close();
		
		//2. quit() it will close all the browser windows which are opened with this automation script.
		driver.quit();
	}

}
