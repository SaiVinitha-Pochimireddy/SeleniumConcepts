package DataDriventesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FixedDepositCalculator {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		
		String file=System.getProperty("user.dir")+"\\xldata\\caldata.xlsx";
		
		int rows=ExcelUtil.getRowCount(file, "Sheet1");
		
		
		for(int i=1;i<=rows;i++)
		{
			//read data from excel
			String princ=ExcelUtil.getCellData(file,"Sheet1",i,0);
			String rateofinterest=ExcelUtil.getCellData(file,"Sheet1",i,1);
			String per1=ExcelUtil.getCellData(file,"Sheet1",i,2);
			String per2=ExcelUtil.getCellData(file,"Sheet1",i,3);
			String fre=ExcelUtil.getCellData(file,"Sheet1",i,4);
			String exp_mvalue=ExcelUtil.getCellData(file,"Sheet1",i,5);
			
				
			//pass data to the app
			driver.findElement(By.id("principal")).sendKeys(princ);
			driver.findElement(By.id("interest")).sendKeys(rateofinterest);
			driver.findElement(By.id("tenure")).sendKeys(per1);
			
			Select perdrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp=new Select(driver.findElement(By.id("frequency")));
			fredrp.selectByVisibleText(fre);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement calculate_btn=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			js.executeScript("arguments[0].click();",calculate_btn);  // clicking on calculate button
						
			//validation & update results in excel
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test Passsed");
				ExcelUtil.setCellData(file, "Sheet1",i,7,"Passed");
				ExcelUtil.fillGreenColor(file, "Sheet1",i,7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtil.setCellData(file, "Sheet1",i,7,"Failed");
				ExcelUtil.fillRedColor(file, "Sheet1",i,7);
			}
			Thread.sleep(3000);
				
			WebElement clear_btn=driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();",clear_btn);  // clicking on clear button
		
		
		}

	}
}
