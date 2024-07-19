package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//1. using self node
		String txt=driver.findElement(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/self::a")).getText();
		System.out.println(txt); //Indiabulls Housing F
		
		//2. getting parent with the help of self node
		//if we don't have have any text for parent then it will return child text only  "Indiabulls Housing F"
		txt=driver.findElement(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/parent::td")).getText();
		System.out.println(txt); //Indiabulls Housing F
		
		//3. getting child
		//we don't have child for<a> so we go to ancestor(parent of parent) of <a> i.e <tr> then <td> will become child
		List<WebElement> clds=driver.findElements(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/ancestor::tr/child::td"));
		System.out.println("no.of child nodes are "+clds.size()); //5
		
		//4. getting ancestor form self
		//if we don't have have any text for parent then it will return text of all child nodes of it
		txt=driver.findElement(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/ancestor::tr")).getText();
		System.out.println(txt); //Indiabulls Housing F A 116.10 123.30 + 6.20

		
		//5. getting descendant
		//here also we go to ancestor i.e <tr> then descendant <a>
		//if we specify tag name it will return only that tags, for * it will return all the descendants.
		List<WebElement> des=driver.findElements(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/ancestor::tr/descendant::*"));
		System.out.println("no.of descendant nodes are "+des.size()); //7
		
		//6. getting following nodes
		// go to ancestor i.e <tr> then we get all trs below that tr. for * we will get all tags below tr
		List<WebElement> flw=driver.findElements(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/ancestor::tr/following::tr"));
		System.out.println("no.of following tr nodes for tr are "+flw.size()); //402
		
		List<WebElement> flwall=driver.findElements(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/ancestor::tr/following::*"));
		System.out.println("no.of all following nodes for tr are "+flwall.size()); //3343
		
		//7. getting following-sibling (no plural)
		// go to ancestor i.e <tr> then we get all tr siblings for tr. for * we will get all siblings of tr
		List<WebElement> flwsbl=driver.findElements(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/ancestor::tr/following-sibling::tr"));
		System.out.println("no.of following tr nodes for tr are "+flwsbl.size()); //400 for * also we get 400
		
		//8. getting preceding nodes
		// go to ancestor i.e <tr> then we get all trs above that tr. for * we will get all tags above tr
		List<WebElement> pre=driver.findElements(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/ancestor::tr/preceding::tr"));
		System.out.println("no.of following tr nodes for tr are "+pre.size()); //15  for * we get 268
		
		//9. getting preceding-sibling (no plural)
		// go to ancestor i.e <tr> then we get all tr siblings above that tr. for * we will get all siblings above that tr
		List<WebElement> presbl=driver.findElements(By.xpath("//a[contains(text(),'Indiabulls Housing F')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("no.of following tr nodes for tr are "+presbl.size()); //14 for * also we get 14
	}

}
