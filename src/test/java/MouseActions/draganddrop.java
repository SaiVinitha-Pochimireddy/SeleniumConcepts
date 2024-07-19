package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class draganddrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		WebElement source=driver.findElement(By.xpath("//div[@id='box2']"));
		WebElement destination=driver.findElement(By.xpath("//div[@id='box106']"));
		
		//creating actions object
		Actions act=new Actions(driver);
		
		//dragAndDrop(source, destination) to drag from source and drop in destination
		act.dragAndDrop(source, destination).perform();
		
		WebElement washington=driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement unitedstates=driver.findElement(By.xpath("//div[@id='box103']"));
		
		act.dragAndDrop(washington,unitedstates).perform();

	}

}
