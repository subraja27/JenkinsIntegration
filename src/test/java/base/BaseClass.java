package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Allure;


public class BaseClass extends AbstractTestNGCucumberTests{
	
	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	
	public static void attachScreenshot() {
		
		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			Allure.addAttachment("src", new FileInputStream(src));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
    }
	@Parameters({"url","browser"})
	@BeforeMethod
	public void preCondition(String url,String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		}

	@AfterMethod
	public void postCondition() {
		driver.quit();

	}

}
