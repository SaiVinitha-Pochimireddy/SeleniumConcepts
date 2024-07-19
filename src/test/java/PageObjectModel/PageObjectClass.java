package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass {
	WebDriver driver;
	
	//Constructor
	PageObjectClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElements without findelement
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement Password;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btn_login;
	//locators
	By img_logo_loc = By.xpath("//img[@alt='company-branding']");
	
	//Action Methods
	public void SetUsername(String name)
	{
		username.sendKeys(name);
	}
	public void SetPassword(String password)
	{
		Password.sendKeys(password);
	}
	public void Login()
	{
		btn_login.click();
	}
	public boolean CheckLogoPresence()
	{
		boolean b=driver.findElement(img_logo_loc).isDisplayed();
		return b;
	}

}
