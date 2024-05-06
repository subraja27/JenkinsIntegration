package day2;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {
	
	public RemoteWebDriver driver ;
	public WebDriverWait wait;
	public String excelFileName;
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void preCondition(String url,String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
					
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
//	@DataProvider
//	public String[][] sendData() throws IOException {
//		return ReadExcelIntegration.readExcelData(excelFileName);
//
//	}
	
	@AfterMethod
	public void postCondition() {
       driver.quit();		

	}

}
