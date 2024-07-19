package Practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//open browser
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("small-searchterms")).sendKeys("Apple");
		//Thread.sleep(5000);
		driver.findElement(By.className("button-1 search-box-button")).click();
		String exp= driver.findElement(By.className("no-result")).getText();
		String Act_Res="No products were found that matched your criteria.";
		if(exp.equals(Act_Res))
	          System.out.println("testcase Passed");
		else
			System.out.println("testcase Failed");

	}

}
