package WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicOrPagnation {

	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//in our example page we have 4 pages in pagination
		//but no.of pages may be dynamic it may be 0 or 100 so we check if no.of pages are >1 or not
		int pages=4;
		for(int i=1;i<=4;i++)
		{
			if(pages>1)
			{
				//we click on that page
				WebElement prspage=driver.findElement(By.xpath("//ul[@class='pagination']//a[text()="+i+"]"));
				System.out.println("present page is "+prspage.getText());
				prspage.click();
			}
			//finding no.of rows in that page
			int rows=driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
			System.out.println(" Total No Of Rows in present Page : "+rows);
			
			//finding no.of cols in that page
			int cols=driver.findElements(By.xpath("//table[@id='productTable']//th")).size();
			System.out.println(" Total No Of Cols in present Page : "+cols);
			//in this table headings are written in <thead> so we can start from index 1 and rows are giving 6 so do rows-1
			for(int r=1;r<=rows-1;r++)
			{
				for(int c=1;c<=cols;c++)
				{
					String st=driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td["+c+"]")).getText();
					System.out.print(st+"\t");
				}
				System.out.println();
			}
		}

	}

}
