package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rightclick {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement btn=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		//creating actions object
		Actions act=new Actions(driver);
		
		//contextClick() to right on element
		act.contextClick(btn).perform();
		WebElement edit=driver.findElement(By.xpath("//span[normalize-space()='Edit']"));
		edit.click();
		driver.switchTo().alert().accept();
	}

}
