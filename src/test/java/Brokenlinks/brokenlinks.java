package Brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenlinks {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=WebDriverManager.chromedriver().create();
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement>  links=driver.findElements(By.tagName("a"));
		int brokenlinks=0;
		for(WebElement link:links)
		{
			String hrefattr= link.getAttribute("href");
			if(hrefattr.equals(null) || hrefattr.isEmpty())
			{
				System.out.println("tag don't contain href value");
				continue;
			}
			
			URL linkurl=new URL(hrefattr); //converting string to url
			
			HttpURLConnection conn=(HttpURLConnection) linkurl.openConnection();
			
			conn.connect();
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefattr+ "  " +" is broken link");
				brokenlinks++;
			}
			else
			{
				System.out.println(hrefattr+ "  " +" is not a broken link");
			}
		}
		System.out.println("no.of broken links are: "+brokenlinks);

	}

}
