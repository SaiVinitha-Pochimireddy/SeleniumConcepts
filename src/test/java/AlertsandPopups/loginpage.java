package AlertsandPopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginpage {

	public static void main(String[] args) {
		//http://the-internet.herokuapp.com/basic_auth  -- normal url
		//http://admin:admin@the-internet.herokuapp.com/basic_auth -- url with username and password
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		String str=driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
		
		if(str.contains("Congratulations"))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}

	}

}
