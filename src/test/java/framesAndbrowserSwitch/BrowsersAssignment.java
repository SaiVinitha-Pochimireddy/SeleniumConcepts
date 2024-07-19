
package framesAndbrowserSwitch;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowsersAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//opening main page(parent)
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//finding multiple elements to click and open multiple pages
		List<WebElement> links=driver.findElements(By.xpath("//div[contains(@class,'wikipedia-search-results')]//a"));
		
		for(int i=0;i<links.size();i++)
		{
			links.get(i).click();  //clicking all links
		}
		
		//finding ids for all page and storing in set
		Set<String> webidset=driver.getWindowHandles();
		
		//using enhanced for loop to print all pages titles
		for(String id:webidset)
		{
			String title= driver.switchTo().window(id).getTitle();
			System.out.println(title);
			//driver.close();//it will close all pages one by one
		}
		//we can use quit() to close all at a time
		driver.quit();

	}

}
