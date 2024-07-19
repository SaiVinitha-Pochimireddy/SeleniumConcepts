package DatePickers;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTrial {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement pkpdrp=driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select pdrp= new Select(pkpdrp);
		pdrp.selectByVisibleText("Mexico City");
		
		WebElement dopdrp=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select ddrp= new Select(dopdrp);
		ddrp.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		List<WebElement> cost=driver.findElements(By.xpath("//table[@class='table']//tr//td[6]"));
		System.out.println("total no of rows are: "+cost.size());
		double a[]=new double[cost.size()];
		
		for(int i=0;i<cost.size();i++)
		{
			String str=cost.get(i).getText();
			str=str.replace("$", "");
			//converting string to double
			a[i]=Double.parseDouble(str);
		}
		
		Arrays.sort(a);
		System.out.println("smallest amount is:"+a[0]);
		//converting double to string and adding $
		String smlcst= String.valueOf(a[0]);
		smlcst="$".concat(smlcst);
		System.out.println("small cost:"+smlcst);
		//no need to do all the above process we can just sort string array also and find a[0]
		
		for(int r=1;r<=cost.size();r++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
			if(price.equals(smlcst))
			{
				//here i forgot to give td[1] i gave td[6] so it din't worked
				driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[1]")).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Sai Vinitha");
		
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Pulivendula");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Agraharam");
		
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("AP");
		
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("516454");
		
		WebElement carddrp=driver.findElement(By.xpath("//select[@name='cardType']"));
		Select cdrp= new Select(carddrp);
		cdrp.selectByVisibleText("American Express");
		
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("12345");
		
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("July");
		
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2023");
		
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Sai Vinitha");
		
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		String success=driver.findElement(By.tagName("h1")).getText();
		
		if(success.equals("Thank you for your purchase today!"))
		{
			System.out.println("yay!.. test Passed... ");
		}
		else
		{
			System.out.println("ohno!.. test failed... ");
		}
		
		
		
	}

}
