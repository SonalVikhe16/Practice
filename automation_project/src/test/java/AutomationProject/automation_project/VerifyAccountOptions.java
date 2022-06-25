package AutomationProject.automation_project;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyAccountOptions extends BaseTest {

	WebDriver driver;
	HomePage home ;
	
	
	  @BeforeTest 
	  @Parameters ({"email","pass"})
	  public void loginToApplication(String email, String pass) throws InterruptedException {
			/*
			 * driver =webDriverSetting("webdriver.chrome.driver",
			 * "D:\\WebDriver\\chromedriver.exe") ; home = new HomePage(driver);
			 * home.launchApplication(driver, "https://www.amazon.co.in");
			 */
		  TestLogin login = new TestLogin();
		  home = new HomePage(driver);
		  login.setUp();
		  login.login(email, pass);
	  
	  }
	 

	@Test
	public void verify_Account_details() {
		//System.out.println("here");
		home.hoverOverTheLink();
		home.getTheAccountList();
	}

}
