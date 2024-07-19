package ScreenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	private static final String Fileutils = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.get("https://www.apple.com/in/store");
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//taking full screen
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(System.getProperty("User.dir")+"\\screenshots\\fullscreen1.png");
		//FileUtils.copyFile(src, dest);
		src.renameTo(dest);
		
		//particular section of elements or element
		/*WebElement items= driver.findElement(By.xpath("//div[@id='shelf-1']"));
		File source=items.getScreenshotAs(OutputType.FILE);
		File destination = new File(".//screenshots//setofitems.png");
	    FileUtils.copyFile(source, destination);*/

	}

}
