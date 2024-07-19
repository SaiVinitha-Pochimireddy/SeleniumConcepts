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

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice2 {
	public static void main(String args[]) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.youtube.com/watch?v=rOAkHQWApmI&t=2167s");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//TakesScreenshot ts=(TakesScreenshot) driver;
		WebElement screen=driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']"));
		File src= screen.getScreenshotAs(OutputType.FILE);
		File dest= new File(System.getProperty("user.dir")+".\\screenshots\\youtube1.png");
		src.renameTo(dest);
		//FileUtils.copyFile(src, dest);
	}

}
