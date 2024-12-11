package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
public WebDriver driver;
public Logger logger;
public Properties p;

@BeforeClass
@Parameters ({"os","browser"})
public void setup(String os,String br) throws IOException{
	FileReader file=new FileReader("C:\\Users\\Hrushikesh Dandpat\\eclipse-workspace\\test.vir.gv\\src\\test\\resources\\config.properties");
	p=new Properties();
	p.load(file);
	
	logger =LogManager.getLogger(this.getClass());
	switch(br.toLowerCase())
	{
	case"chrome" :driver=new ChromeDriver(); break;
	case "edge" :driver=new EdgeDriver(); break;
	case "firefox" :driver=new FirefoxDriver(); break;
	default :System.out.println("invalid browser name: ..."); return;
	}
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get(p.getProperty("appUrl2")); //reading url from config.properties
	driver.manage().window().maximize();
	
}

@AfterClass
public void tearDown() {
	driver.close();
}
public String randomeString() {
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
}
public String randomeNumber() {
	String generatedNumber=RandomStringUtils.randomNumeric(10);
	return generatedNumber;
}

public String randomeAlphaNumeric() {
	String generatedstring=RandomStringUtils.randomAlphabetic(3);
	String generatenumber=RandomStringUtils.randomNumeric(3);
	return (generatedstring+"@"+generatenumber);}
}
