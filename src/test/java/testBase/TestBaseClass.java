package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException {
		//loading configuration file through property class
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		//add logs to execution
		logger=LogManager.getLogger(this.getClass());
		//launching browsers through xml file
		switch(br.toLowerCase())
		{
		case "chrome":driver= new ChromeDriver(); break;
		case "edge":driver= new EdgeDriver(); break;
		case "firefox":driver= new FirefoxDriver(); break;
		default: System.out.println("Invalid Browser"); return;
		}		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("appURL"));//reading url from property file 
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	public String randomString() {
		String geneartedString=RandomStringUtils.randomAlphabetic(7);
		return geneartedString;
		
	}
	public String randomNumeric() {
		String geneartedNumber=RandomStringUtils.randomNumeric(7);
		return geneartedNumber;
		
	}
	public String randomAlphaNumeric() {
		String geneartedString=RandomStringUtils.randomAlphabetic(7);
		String geneartedNumber=RandomStringUtils.randomNumeric(7);
		return (geneartedString+"@"+geneartedNumber);
		
	}
	

}
