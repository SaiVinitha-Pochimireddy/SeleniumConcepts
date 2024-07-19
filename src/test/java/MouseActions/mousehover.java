package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mousehover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement dsktp=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement PC=driver.findElement(By.xpath("//a[normalize-space()='PC (0)']"));
		
		//creating actions object
		Actions act=new Actions(driver);
		//moveToElement(element) to hover on element
		act.moveToElement(dsktp).moveToElement(PC).click().perform(); //perform is mandatory for act var
		
		driver.close();

	}

}
