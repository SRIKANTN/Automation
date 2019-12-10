package generic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest 
{
	public WebDriver driver;
	@Parameters({"nodeurl","browser"})
	@BeforeMethod
	public void  percondition(String nodeurl, String browser) throws MalformedURLException
	{
		URL url = new URL(nodeurl);
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver = new RemoteWebDriver(url, dc);
		driver.get("https://demo.actitime.com");
	}
	@AfterMethod
	public void postcondition()
	{
		driver.close();
	}

}
