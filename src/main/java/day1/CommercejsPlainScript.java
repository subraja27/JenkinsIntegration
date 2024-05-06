package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommercejsPlainScript {


	public static void main(String[] args) throws InterruptedException {

		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		//load the url
		driver.get("https://commercejs-demo-store.netlify.app/");
		//maximize the window
		driver.manage().window().maximize();
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//Click 'Shop now'
		driver.findElement(By.linkText("Shop now")).click();
		//Click 'Products' under 'Hair Products' section.
		driver.findElement(By.xpath("//p[text()='Hair Products']/following::p")).click();
		//Click 'Hair Beauty Bath'
		driver.findElement(By.xpath("//p[text()='Hair Beauty Bath']")).click();
		//Click 'Add to cart'
		WebElement addToCartEle = driver.findElement(By.xpath("//span[text()='Add to cart']"));
		wait.until(ExpectedConditions.visibilityOf(addToCartEle));
		addToCartEle.click();
		//Navigate to Cart and checkout the product.
		driver.findElement(By.xpath("//div[@class='cart-animation']")).click();
		driver.findElement(By.linkText("Checkout")).click();
		//Click the 'Shipping Method' dropdown and select 'Worldwide - $5.00 USD'
		WebElement ddEle = driver.findElement(By.name("fulfillment[shipping_method]"));
		Select sec = new Select(ddEle);
		sec.selectByVisibleText("Worldwide - $5.00 USD");
		//Click 'Make payment'
		driver.findElement(By.xpath("//button[text()='Make payment']")).click();
		//Read the order number and print it in console.
		String text = driver.findElement(By.xpath("//p[@class='font-color-light mb-2']")).getText();
		String[] split = text.split(":");
		System.out.println("The order number is : "+split[split.length-1]);



	}

}
