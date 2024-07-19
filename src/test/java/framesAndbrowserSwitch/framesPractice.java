package framesAndbrowserSwitch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class framesPractice {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//opening main page(parent)
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//switching to frame1 by passing web element
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.cssSelector("input[name='mytext1']")).sendKeys("abcd");
		
		//switching to defaultcontent(main page)
		driver.switchTo().defaultContent();
		//switching to frame 3 
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		//switching to inner frame and selecting check box which is in iframe of 3rd frame
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("div.uHMk6b")).click();
		
		driver.switchTo().defaultContent();
		
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.cssSelector("input[name='mytext2']")).sendKeys("1234");
		
		

	}

}
