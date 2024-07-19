package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slidermoving {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement min_scrl=driver.findElement(By.xpath("//span[1]"));
		WebElement max_scrl=driver.findElement(By.xpath("//span[@style='left: 100%;']"));
		System.out.println(min_scrl.getAttribute("class"));
		
		System.out.println("min locator point:"+min_scrl.getLocation()); //(59, 250)
		System.out.println("max locator point:"+max_scrl.getLocation());//(612, 250)
		
		//creating actions object
		Actions act=new Actions(driver);
		
		//dragAndDropBy(element,x-axis,y-axis) to darg the slider to pint(x,y)
		act.dragAndDropBy(min_scrl,100,250).perform();
		System.out.println("min locator point after drag:"+min_scrl.getLocation());//(158, 250)
		
		//we give -value for x axis to drag from right to left
		act.dragAndDropBy(max_scrl,-100,250).perform();
		System.out.println("max locator point after drag:"+max_scrl.getLocation());//(512, 250)

	}

}
