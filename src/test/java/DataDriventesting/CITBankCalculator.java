package DataDriventesting;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CITBankCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		String file=System.getProperty("user.dir")+"\\xldata\\caldata2.xlsx";
		
		int rows=ExcelUtil.getRowCount(file, "Sheet1");
		
		for( int i=0;i<=rows;i++)
		{
			//read data from XL
			String depamt = ExcelUtil.getCellData(file, "Sheet1", i, 0);
			String interest = ExcelUtil.getCellData(file, "Sheet1", i, 1);
			String months = ExcelUtil.getCellData(file, "Sheet1", i, 2);
			String Compound = ExcelUtil.getCellData(file, "Sheet1", i, 3);
			String Exp_Total = ExcelUtil.getCellData(file, "Sheet1", i, 4);
			
			//clearing all fields
			driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
			driver.findElement(By.xpath("//input[@id='mat-input-1']")).clear();
			driver.findElement(By.xpath("//input[@id='mat-input-2']")).clear();
			
			driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c109-4']")).clear();
			
			//passing XL data to UI
			driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(depamt);
			driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(months);
			driver.findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(interest);
			
			driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c109-4']")).click();
			
			List<WebElement> allopt= driver.findElements(By.xpath("//div[@role='listbox']//mat-option"));
			
			for(WebElement opt:allopt)
			{
				if(opt.getText().equals(Compound))
				{
					opt.click();
				}
			}
			
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']")).click();
			
			//validation & update results in excel
			String act_Total=driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			if(Exp_Total.equals(act_Total))
			{
				System.out.println("Test Passsed");
				ExcelUtil.setCellData(file, "Sheet1",i,6,"Passed");
				ExcelUtil.fillGreenColor(file, "Sheet1",i,6);
			}
			
			else
			{
				System.out.println("Test Failed");
				ExcelUtil.setCellData(file, "Sheet1",i,6,"Failed");
				ExcelUtil.fillRedColor(file, "Sheet1",i,6);
			}
			Thread.sleep(3000);
			
			
			
		}

	}

}
