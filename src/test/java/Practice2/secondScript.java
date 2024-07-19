package Practice2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class secondScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.ae/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//driver.findElement(By.xpath("//*//div[@classname='a-section aok-relative s-image-square-aspect']//img")).click();
		List<WebElement> images = driver.findElements(By.tagName("img"));
		Thread.sleep(3000);
		System.out.println("number of pens in this page are "+images.size());
		driver.close();

	}

}
