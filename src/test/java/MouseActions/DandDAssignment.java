package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DandDAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		WebElement bank=driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement bankacc=driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		
		act.dragAndDrop(bank, bankacc).perform();
		
		WebElement bank1=driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a"));
		WebElement bankamt=driver.findElement(By.xpath("//ol[@id='amt7']"));
		
		act.dragAndDrop(bank1, bankamt).perform();
		
		WebElement Sales=driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
		WebElement Salesacc=driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));
		
		act.dragAndDrop(Sales, Salesacc).perform();
		
		WebElement Sales1=driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a"));
		WebElement Salesacc1=driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));
		
		act.dragAndDrop(Sales1, Salesacc1).perform();
		
		String actual=driver.findElement(By.xpath("//a[normalize-space()='Perfect!']")).getText();
		
		if(actual.equals("Perfect!"))
		{
			System.out.println(" Success... yay....");
		}
		else
		{
			System.out.println(" failed..");
		}
		
		driver.quit();

	}

}
