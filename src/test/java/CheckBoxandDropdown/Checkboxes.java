package CheckBoxandDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		
		//selecting single checkbox
		driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//selecting multiple checkboxes - we can use normal and enhanced for loops
		List<WebElement> opt= driver.findElements(By.xpath("//label[@class='form-check-label']//input[@type='checkbox']"));
		System.out.println("total no.of options are "+opt.size());
		
		for(int i=0;i<opt.size();i++)
		{
			opt.get(i).click();
		}
		Thread.sleep(3000);
		//unselecting all checkboxes
		for(WebElement op:opt)
		{
			op.click();
		}
		Thread.sleep(3000);
		//selecting even no.of checkboxes - we can't use enhanced for loop as it is based on indexes
		for(int i=2;i<opt.size();i+=2)
		{
			opt.get(i).click();
		}
		Thread.sleep(3000);
		//unselecting only selected checkboxes - we can do with enhanced for loop also
		
		for(WebElement op:opt)
		{
			if(op.isSelected())
			{
				op.click();
			}
		}
		Thread.sleep(3000);
	}

}
