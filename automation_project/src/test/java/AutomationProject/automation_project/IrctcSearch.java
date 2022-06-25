package AutomationProject.automation_project;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

;

public class IrctcSearch extends BaseTest {
WebDriver driver;
	IrctcPage home ;
	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = webDriverSetting("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
		home = new IrctcPage(driver);
		
		
	}
	@Test(groups = "required")
	
	public void search() throws AWTException {
		launchApplication(driver, "https://www.irctc.co.in");
		home.clickOkButton();
		if(home.isAlertPresent())
		driver.switchTo().alert().accept();
		performClick(home.from);
		home.fromSelection("PUNE JN - PUNE");
		//Actions action = new Actions(driver);
		Robot robot = new Robot();
		
		  robot.keyPress(KeyEvent.VK_TAB); System.out.println("tab first pressed");
		  robot.keyPress(KeyEvent.VK_TAB); System.out.println("tab second pressed");
		 
		performClick(home.to);
		home.toSelection("PURI - PURI");
		//home.enterValue("Pune", home.from);
		//home.enterValue("Puri", home.to);
		performClick(home.search);
		
	}
	
	/*
	 * @AfterTest public void close() { driver.close(); }
	 */
	
}
