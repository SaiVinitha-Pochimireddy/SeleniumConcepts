package WdDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//we can access condition methods only through webElement variables.
		//it will return only true or false values
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//1. isDisplayed()
		WebElement img=driver.findElement(By.xpath("//img[contains(@alt,'Picture for category Electronics')]"));
		System.out.println(img.isDisplayed());
		
		//2. isEnabled()
		WebElement sb=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println(sb.isEnabled());
		
		//3. isSelected() used only for radio buttons,checkboxes and dropdowns
		WebElement excb=driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
		System.out.println("Before selecting excellent checkbox");
		System.out.println(excb.isSelected());
		
		//select checkbox automatically
		excb.click();
		
		System.out.println("After selecting excellent checkbox");
		System.out.println(excb.isSelected());
		

	}

}
