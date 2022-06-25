package AutomationProject.automation_project;

import org.openqa.selenium.WebDriver;

public interface core {
	public WebDriver webDriverSetting(String driverName, String path);
	public void launchApplication(WebDriver driver,String url);
}
