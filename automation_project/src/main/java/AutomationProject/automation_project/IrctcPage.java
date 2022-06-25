package AutomationProject.automation_project;

import java.util.List;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class IrctcPage extends BaseTest {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	@FindBy (xpath = "//div[@class = 'text-center col-xs-12']//button")
	WebElement ok_button;
	
	@FindBy (xpath = "//input[@class = 'ng-tns-c58-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")
	WebElement from;
	
	@FindBy (xpath = "//input[@class='ng-tns-c58-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")
	WebElement to;
	
	@FindBy (xpath = "//input[@class='ng-tns-c58-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")
	WebElement date;
	
	@FindBy (xpath = "//button[text()='Search']")
	WebElement search;
	
	@FindBy (xpath = "//ul[@id = 'pr_id_1_list']//li//span")
	List<WebElement> from_stations;
	
	@FindBy (xpath = "//ul[@id = 'pr_id_2_list']//li")
	List<WebElement> to_stations;
	
	public IrctcPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOkButton() {
		performClick(ok_button);
		
		  if(ok_button.isDisplayed())
		  Reporter.log("Successfully opened Irctc",true);
		  else
		  softAssert.assertAll("Something is wrong with the page load");
		 

	}
	
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   // isAlertPresent()
	
	public void fromSelection(String fromStation) {
		for(WebElement element:from_stations) {
			System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase(fromStation)) {
				element.click();
				break;
			}
		}
	}
	
	public void toSelection(String toStation) {
		for(WebElement element:to_stations) {
			if(element.getText().equalsIgnoreCase(toStation)) {
				element.click();
				break;
			}
		}
	}
}
