package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(xpath="//span[text()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(xpath="(//a[normalize-space()='Register'])[1]")
	WebElement linkRegister;
	@FindBy(linkText = "Login")   // Login link added in step5
	WebElement linkLogin;
	
	public void clickAccount() {
		linkMyAccount.click();
	}
	public void clickRegister() {
		linkRegister.click();
	}
	public void clickLogin()
	{
		linkLogin.click();
	}
	

}
