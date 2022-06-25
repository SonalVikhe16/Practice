package AutomationProject.automation_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class HomePage extends BaseTest {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	@FindBy(xpath = /*"//div[@id = 'nav-tools']//span[text()='Hello, Sign in']"*/ "//a[@id = 'nav-link-accountList']")
		WebElement sign_in;
		
		@FindBy (xpath = "//div[@id = 'nav-flyout-ya-signin']//span[text()='Sign in']")
		WebElement sign_in_button;
		
		@FindBy (id = "ap_email")
		WebElement email;
		
		@FindBy (id = "ap_password")
		WebElement password;
		
		@FindBy (xpath = "//div[@class = 'a-section']//span[@id='continue']")
		WebElement continue_button;
		
		@FindBy (xpath = "//div[@class = 'a-section']//span[@id='auth-signin-button']")
		WebElement signIn_button_final;
		
		@FindBy (xpath = "//a[@id = 'nav-item-signout']//span[text()= 'Sign Out']")
		WebElement signOut;
		
		/* verifying the account options*/
		
		@FindBy (xpath = "//div[@id = 'nav-al-your-account']//a")
		List<WebElement> account_options;
		
		public HomePage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
		}
		
		public void hoverOverTheLink() {
			hoverOver(driver,sign_in);
			wait(driver, sign_in_button, 30);
			if(sign_in_button.isDisplayed())
				Reporter.log("The sign in button is displayed",true);
			else
				softAssert.assertAll("problem in displaying SignIn button ");
			
		}
		public void clickSignInButton() {
			performClick(sign_in_button);
			if(email.isDisplayed())
				Reporter.log("Successfully clicked sign in button",true);
			else
				softAssert.assertAll("Sign In button is not clicked");

		}
		
		public void enterCredentials(String email_id, String pass) {
			enterValue(email_id,email);
			performClick(continue_button);
			enterValue(pass,password);

		}
		
		public void clickSignInButton_final() {
			performClick(signIn_button_final);
			//hoverOver(driver, signOut);
			if(signOut.isDisplayed())
				Reporter.log("Successfully signed in",true);
			else
				softAssert.assertAll("Sign In failed");

		}
		
		public void getTheAccountList() {
			String[] actual = {"Your Account","Your Orders","Your Wish List",
					"Your Recommendation","Your Prime Membership","Your Prime Video",
					"Your Subscribe & Save Items","Membership & Subscription","Your Gift Card Balance",
					"Your Amazon Business Account","Your Seller Account","Manage Your Content And Devices","Switch Accounts","Sign Out"};
			List<String> actualList = new ArrayList<String>();
			List<String> expectedList = new ArrayList<String>();
			//Iterator it = account_options.iterator();
			/*
			 * while(it.hasNext()) { actualList.add(account_options[]) }
			 */
			for (WebElement element : account_options) {
				actualList.add( element.getText());
			}
			
			Collections.addAll(expectedList, actual);
			
			if(expectedList.equals(actualList)) {
				Reporter.log("List is properly displayed",true);
			}else {
				softAssert.assertAll("List might be missing the element");
			}
		
			
		}
		
}
