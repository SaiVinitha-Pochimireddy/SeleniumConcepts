package firstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//img[@alt='ACs']")).click();
		String Act="Results";
		String Exp=driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base a-text-bold']")).getText();
		if(Exp.equals(Act))
		{
			System.out.println("test Passed");
		}
		else
		{
			System.out.println("test failed");
		}
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getWindowHandle());
		driver.quit();
	}

}
