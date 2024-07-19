package DatePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ticketAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='product_551']")).click();
		
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("Sai vinitha");
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("Pochimireddy");
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
		WebElement month= driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select mon=new Select(month);
		mon.selectByValue("6");
		
		WebElement year= driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select yr=new Select(year);
		yr.selectByVisibleText("2023");
		
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement dt:dates)
		{
			if(dt.getText().equals("20"))
			{
				dt.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
		
		driver.findElement(By.xpath("//input[@id='sex_2']")).click();
		
		driver.findElement(By.xpath("//input[@id='traveltype_1']")).click();

		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Kadapa");
		
		driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("pulivendula");
		
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		
		WebElement month1= driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select mon1=new Select(month1);
		mon1.selectByValue("6");
		
		WebElement year1= driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select yr1=new Select(year1);
		yr1.selectByVisibleText("2023");
		
		List<WebElement> dates1=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement dt:dates1)
		{
			if(dt.getText().equals("20"))
			{
				dt.click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
		
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("12345");
		
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("abcd@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("Kadapa");
		
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Kadapa");
		
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("516454");
		
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Kadapa");
		
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Kadapa");
		
		List<WebElement> countrys= driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		for(WebElement ctr:countrys)
		{
			if(ctr.equals("India"))
			{
				ctr.click();
				break;
			}
		}
		List<WebElement> states= driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		for(WebElement st:states)
		{
			if(st.equals("Andhra Pradesh"))
			{
				st.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[@id='place_order']")).click();
		
	}

}
