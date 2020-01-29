package com.eversource.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.eversource.qa.util.*;
import com.google.common.base.Function;

public class TestBase  {
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	private static final Duration DEFAULT_WAIT_POLLING = Duration.ofSeconds(1);
	private static final Duration DEFAULT_WAIT_DURATION = Duration.ofSeconds(20);
	public static WebDriver driver;
	public static WebDriver yopdriver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	static String Report_Folder_path = "C:\\Reporting\\Report"+Gernric_functions.fTimestamp();
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	
	
	
		      
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/eversource/"
					+ "qa/config/config.properties");
			//C:\Users\iDeliver36\workspace\SalesforceMavensrc\main\java\com\salesforceqa\config\config.properties
			//C:\Users\iDeliver36\workspace\SalesforceMaven\src\main\java\com\salesforce\qa\config
			//C:\Users\iDeliver36\workspace\TestClass\src\com\salesforceqa\config
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		//the Extent report will be created only once, no matter wherever we do initialization
			static {
					 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Report_Folder_path + "\\testReport.html");
			       extent = new ExtentReports();
			       extent.attachReporter(htmlReporter);
			       extent.setSystemInfo("OS", "OS");
			       extent.setSystemInfo("Browser", "browser");
			       
			       //htmlReporter.config().setChartVisibilityOnOpen(true);
			       htmlReporter.config().setDocumentTitle("Extent Report Demo");
			       htmlReporter.config().setReportName("Test Report");
			       //htmlReporter.config().setTestViewChartLocation(CharacterSection.TOP);
			       htmlReporter.config().setTheme(Theme.STANDARD);
			       
			      
			}

	//Initiating  Browser 
	public static void initialization() throws Throwable{
		//getParentReportname("Verify User is able to launch Eversource Page or not");
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/com/eversource/qa/driver/chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/com/eversource/qa/driver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		driver.get(prop.getProperty("url"));
		
		Extent_reporter.validation("Verify User is able to launch Eversource Page or not Validation", driver.getTitle(), "Eversource | Residential");
	
		
}
	
	//Logging method so that the same log is added in logger as well as syso
		public static void log(String e) {
			log.info(e);
			Reporter.log(e);
		}
	
	
	//Getting TestName
	public static void getReportname(String Reportname){
		Extent_reporter.CreateRoportname(Reportname,extent);
	}
	
	
	
	public static void getParentReportname(String Reportname){
		Extent_reporter.CreateParentRoportname(Reportname,extent);
	}
	
	
	
	//Creating Report 
	public static void Reporting(String Status,String StepName,String ActualStep,String ExpectedStep) throws Throwable{
		Extent_reporter.Report(Status, StepName, ActualStep, ExpectedStep);
		
	}
	
	
	//Explicit Wait
	public static  void waitforElement(long timeoutseconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//PageLoadTimeout Function
	public static void waitfunction(){
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
	}
	


	//Fluent Wait for an Element for event for clicking or checking
	public static void WaitForObject(  final WebElement element,String EventName) throws InterruptedException{
		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
		   .withTimeout(DEFAULT_WAIT_DURATION)
		   .pollingEvery(DEFAULT_WAIT_POLLING)
		   .ignoring(NoSuchElementException.class);
	
		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() { 
		     public WebElement apply(WebDriver driver) {
		      return element;
		     }
		   });
		foo.isDisplayed();
		if(EventName.contains("Click")){
			
			try{
				foo.click();
			}catch(Exception f){
				System.out.println(f);
			}
			
		}
	}
	
	 public static int getRandomInteger(){
	        return ((int) (Math.random()*(5 - 1))) + 1;
	    }
	
	public static boolean isClickable(WebElement el) 
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 6);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			return true;
		}
		catch (Exception e){
			return false;
		
		}
	}
	//Closing Browser And Saving Report 
	public static void closeBrowser() {
		driver.close();
		extent.flush();
	}
}
