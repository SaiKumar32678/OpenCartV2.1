package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends HomePage {
	
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	//Web Elements
	
	@FindBy(css="#input-firstname")
	WebElement txtFirstName;
	
	@FindBy(css="#input-lastname")
	WebElement txtLastName;
	
	@FindBy(css="#input-email")
	WebElement txtEmail;
	
	@FindBy(css="#input-telephone")
	WebElement txtTelephone;
	
	@FindBy(css="#input-password")
	WebElement txtPwd;
	
	@FindBy(css="#input-confirm")
	WebElement txtCnfPwd;
	
	@FindBy(css="input[name='agree']")
	WebElement chkPolicy;

	@FindBy(css="input[type='submit']")
	WebElement submitBtn;
	
	@FindBy(css="#content h1")
	WebElement cnfMsg;
	
	//Action Methods
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	public void setPassword(String pwd) {
		txtPwd.sendKeys(pwd);
	}
	public void setCnfPassword(String pwd) {
		txtCnfPwd.sendKeys(pwd);
	}
	public void setPolicy() {
		chkPolicy.click();;
	}
	public void clickSubmit() {
		submitBtn.click();
	}
	
	public String getConfirmationMessage() {
		try {
			return cnfMsg.getText();
		}
		catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	
	
	
	

}
