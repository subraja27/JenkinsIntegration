package day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintOrderID extends ProjectSpecificMethods{

	@BeforeTest
	public void setValues() {
		excelFileName="PurchaseForm";

	}


	@Test(dataProvider = "sendData")
	public void printOrderId(String name,String cardNo) {
		//Selecting the first resulting mobile phone
		driver.findElement(By.xpath("//h4[@class='card-title']")).click();
		//Click 'Add to cart': On the product detail page
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		//Explicit wait - becoz it takes time to load the alert
		wait.until(ExpectedConditions.alertIsPresent());
		//Accept the Alert
		Alert handleAlert = driver.switchTo().alert();
		handleAlert.accept();
		//Click the 'Cart' link
		driver.findElement(By.xpath("//a[contains(@href,'cart')]")).click();
		//Click 'Place Order'button
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		//Type in the 'name' and the 'credit card number'
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys(cardNo);
		//Click the 'Purchase' button
		driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
		//Read the 'Order ID' and print it in the console
		String text = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
		//Spliting the text, to get only order id
		String[] splitText = text.split("\n");
		System.out.println("Your Order "+splitText[0]);
	}
}
