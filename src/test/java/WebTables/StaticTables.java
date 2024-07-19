package WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTables {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//finding no.of rows
		int rows= driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("total nof rows in book table are "+rows);
		
		//finding no.of cols
		int cols= driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("total nof cols in book table are "+cols);
		
		//finding 4th row 2nd col data(specific data)
		String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[2]")).getText();
		System.out.println(data);
		
		//printing all data in a table
		//here we start from 2 because we don't want headings and our xpath will identify only tr and td but 1st row contains th 
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String st=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(st+"\t");
			}
			System.out.println();
		}
		
		//finding total cost of all books written by amit
		int sum=0;
		for(int r=2;r<=rows;r++)
		{
			String auth=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(auth.equalsIgnoreCase("amit"))
			{
				String cost=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
				sum=sum+Integer.parseInt(cost);
				System.out.println(auth+"\t"+cost);
			}
		}
		System.out.println("Total cost of books written by amit is "+sum);
		

	}

}
