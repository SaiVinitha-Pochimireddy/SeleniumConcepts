import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToastMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-4']")).click();
		String actmsg = driver.findElement(By.xpath("//p[@class='content']")).getText();
		System.out.println(actmsg);
		String expmsg="The prod uct has been added to your ";
		Assert.assertEquals(actmsg, expmsg);
		driver.close();
	}

}
