package CheckBoxandDropdown;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdownpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver= WebDriverManager.edgedriver().create();
        driver.get("http://www.microsoftedge.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='q']")).sendKeys("selenium");
        List<WebElement> opts= driver.findElements(By.xpath("//ul//li[@role='option']"));
        System.out.println("total number of options are: "+ opts.size());
        for(int i=0;i<opts.size();i++)
        {
        	System.out.println(opts.get(i).getText());
        }
        for(WebElement opt:opts)
        {
        	if(opt.getText().contains("java"))
        	{
        		opt.click();
        		break;
        	}
        }
        
	}

}