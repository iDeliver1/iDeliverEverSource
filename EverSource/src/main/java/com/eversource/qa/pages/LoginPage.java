package com.eversource.qa.pages;



import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import com.eversource.qa.base.TestBase;



public class LoginPage extends TestBase {
	
	@FindBy(xpath="//div[@class='col-sm-6 col-xs-8']//img[@class='logo img-responsive']")
	WebElement EverSourcelogo;
	
		@FindBy(xpath="//input[@id='Main_Login_txtUserName']")
		WebElement Username;
		
		@FindBy(xpath="//input[@id='Main_Login_txtPassword']")
		WebElement Password;
		
		@FindBy(xpath="//input[@id='Main_Login_btnLoginEnter']")
		WebElement Signin;
		
		@FindBy(xpath="//div[@id='promotion-modal']//span[contains(text(),'×')]")
		WebElement DialogueClose;
		
		EverSource_HeaderMenu objcheck;
		
		
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
			objcheck = new EverSource_HeaderMenu();
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateSalesForceLogo(){
			return EverSourcelogo.isDisplayed();
		}
		
		
		public HomePage login(String usr, String pwd,String TestName) throws Throwable 
		{
	
			log("Logging testing with username - "+usr);
			log("Logging testing with password - "+pwd);
			
			
			
			waitforElement(10,Username);
			Username.sendKeys(usr);
			Password.sendKeys(pwd);
			
			
			Signin.click();	
			
			/*try{
				waitforElement(10, DialogueClose);
				DialogueClose.isDisplayed();
			}catch(Exception e){
				
			}*/
			
			//DialogueClose.click();
	
			if(validateSalesForceLogo()){
				
				log("Successful logging with username -  "+usr);
				Reporting("Pass"," Username & Password ", "Logged in Successful with entered Username "+usr+" & password "+pwd, "User Should be able to login with Username "+usr+" & password "+pwd,TestName);
				
				objcheck.CheckHeaderMenu(TestName);
				return new HomePage();

			}else{
				Reporting("FAIL"," Username & Password ", "Logged in Failed with entered Username"+usr+" & password"+pwd, "User Should be able to login with Username"+usr+" & password"+pwd,TestName);
				return new HomePage();
			}
			//return new HomePage();
		}
		
		

}
