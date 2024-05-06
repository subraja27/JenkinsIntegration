package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_001Commercejs extends ProjectSpecificMethods{

	@Test
	public void printOrderID() {			
		//Click 'Shop now'
		driver.findElement(By.xpath("Shop now")).click();
		//Click 'Products' under 'Hair Products' section.
		driver.findElement(By.xpath("//p[text()='Hair Products']/following::p")).click();
		//Click 'Hair Beauty Bath'
		WebElement eleHairProduct = driver.findElement(By.xpath("//p[text()='Hair Beauty Bath']"));
		driver.executeScript("arguments[0].click();", eleHairProduct);
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
