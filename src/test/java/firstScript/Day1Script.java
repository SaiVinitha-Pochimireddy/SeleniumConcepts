package firstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1Script {

	public static void main(String[] args) throws InterruptedException {
		//1.launch/open browser
		//WebDriverManager.chromedriver().setup();
		
		//ChromeDriver driver=new ChromeDriver();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//2.open URL on the browser
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		//3.provide Username - admin@yourstore.com
		
		WebElement un=driver.findElement(By.name("Email"));
		un.clear();
		un.sendKeys("admin@yourstore.com");
		
		//4. provide password - admin
		
		WebElement up=driver.findElement(By.name("Password"));
		up.clear();
		up.sendKeys("admin");
		
		//5. click on login button
		
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		Thread.sleep(3000);
		
		//6. Verify title of dashboardpage
		
		String Act=driver.getTitle();
		//If we have same title for login and dashboard pages use below code
		/*String Act="";
		try
		{
			Act=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
		}
		catch(NoSuchElementException e)
		{
			
		}*/
		String exp="Dashboard";
		if(Act.equals(exp))
		{
			System.out.println("test  passed");
		}
		else
		{
			System.out.println("test failed");
		}
		
		//7. close the browser
		
		//driver.close(); //SocketException
		try
		{
			driver.quit();
		}
		catch(Exception e)
		{}
		

	}

}
