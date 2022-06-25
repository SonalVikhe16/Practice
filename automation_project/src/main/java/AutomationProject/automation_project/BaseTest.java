package AutomationProject.automation_project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest implements core {
	Actions actions ;
	public WebDriver webDriverSetting(String driverName, String path) {
		System.setProperty(driverName,/*"D:\\WebDriver\\chromedriver.exe"*/path);
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);
		return driver;
	}
	
	public void launchApplication(WebDriver driver,String url) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
		//driver.navigate().refresh();
	}
	
	public void implicitWait(WebDriver driver,int time, String timeunit) {
		switch(timeunit) { 
		case "seconds":
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		break;
		default:
			System.out.println("Enter time unit properly (In lowercase)");
		}	
		
	}
	
	public void wait(WebDriver driver, WebElement ele,int time) {
	WebDriverWait wait = new WebDriverWait(driver,time);
	
	 wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void performClick(WebElement ele) {
		ele.click();
	}
	
	public void rightClick(WebElement ele, WebDriver driver) {
		 actions = new Actions(driver);
		 actions.contextClick(ele).perform();
		 
	}
	
	public void enterValue( String value,WebElement ele) {
		ele.sendKeys(value);
	}
	
	public void hoverOver( WebDriver driver,WebElement ele) {
		actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		
		
	}
	
	public void selectByVisibleText(WebDriver driver,WebElement ele,String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}
}
