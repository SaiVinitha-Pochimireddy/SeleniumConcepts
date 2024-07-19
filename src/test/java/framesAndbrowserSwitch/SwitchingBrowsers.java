package framesAndbrowserSwitch;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingBrowsers {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//opening main page(parent)
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//navigating to another page (child)
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> webidset= driver.getWindowHandles();
		
		//approach 1 - used only for 2 pages(par,chld)
		//converting set to list to get parent and child ids separately
		List<String> webidl = new ArrayList(webidset);
		
		String pid= webidl.get(0); //0 gives parent id
		String cid= webidl.get(1); //1 gives child id
		
		//switching to parent 
		driver.switchTo().window(pid);
		//now we can perform any action on main page
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("sai123");
		Thread.sleep(3000);
		//switching to child
		driver.switchTo().window(cid);
		//now we can perform any action on child page
		driver.findElement(By.xpath("//a[@href='/en/contact-sales/']//button[@class='btn btn-ohrm btn-free-demo'][normalize-space()='Contact Sales']")).click();
		
		//approach - used when we have multiple pages opened(see in assignment script)
	}

}
