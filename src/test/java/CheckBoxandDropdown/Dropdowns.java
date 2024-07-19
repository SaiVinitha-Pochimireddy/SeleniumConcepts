package CheckBoxandDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		/*
		//1. dropdown contains select tag
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		WebElement drpele=driver.findElement(By.xpath("//select[@id='country-list']"));
		Select drp=new Select(drpele);
		
		drp.selectByVisibleText("India");
		drp.selectByIndex(3); //france
		drp.selectByValue("5"); //its a text so include it in double quotes. USA
		
		List<WebElement> ctr=drp.getOptions();
		System.out.println("total no.of options under country are "+ctr.size());
		
		for(int i=0;i<ctr.size();i++)
		{
			System.out.println(ctr.get(i).getText());
		}
		
		
		//2. dropdown without select tag (bootstrap dropdown)
		driver.get("http://jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		//clicking on dropdown
		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		
		//finding all elements and storing in a list
		List<WebElement> allopt= driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("total no.of options under country are "+allopt.size());
		
		for(int i=0;i<allopt.size();i++)
		{
			System.out.println(allopt.get(i).getText());
		}
		//selecting only java
		for(WebElement opt:allopt)
		{
			if(opt.getText().equals("Java"))
			{
				opt.click();
				break;
			}
		}
		//unselecting java and Html,css(these 2 selected by default)
		for(WebElement opt:allopt)
		{
			String str=opt.getText();
			if(str.equals("Java")|| str.equals("HTML") || str.equals("CSS"))
			{
				opt.click();
			}
		}
		*/
		
		//3. dynamic dropdown ex:while searching in search bar we get multiple suggestions
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		//passing value to center search bar in google.com page
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("java");
		Thread.sleep(3000);
		
		//finding all autosuggested options and storing in a list
		List<WebElement> autopt= driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		System.out.println("total no.of autosuggested options are "+autopt.size());
		
		for(int i=0;i<autopt.size();i++)
		{
			System.out.println(autopt.get(i).getText());
		}
		//selecting only java
		for(WebElement opt:autopt)
		{
			if(opt.getText().contains("compiler"))
			{
				opt.click();
				break;
			}
		}
		
		

	}

}
