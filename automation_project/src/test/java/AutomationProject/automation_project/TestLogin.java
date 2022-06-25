package AutomationProject.automation_project;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

;

public class TestLogin extends BaseTest {
WebDriver driver;
	HomePage home ;
	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = webDriverSetting("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
		home = new HomePage(driver);
		
		
	}
	@Test(groups = "required")
	@Parameters ({"email","pass"})
	public void login(String email,String pass) {
		launchApplication(driver, "https://www.amazon.co.in");
		home.hoverOverTheLink();
		home.clickSignInButton();
		home.enterCredentials(email, pass);
		home.clickSignInButton_final();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
}
