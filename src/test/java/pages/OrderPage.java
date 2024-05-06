package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class OrderPage extends BaseClass{
	
	@Then("verify the order id and print in the console")
	public void verify_the_order_id_and_print_in_the_console() {
		try {
			String text = driver.findElement(By.xpath("//p[@class='font-color-light mb-2']")).getText();
			String[] split = text.split(":");
			System.out.println("The order number is : "+split[split.length-1]);
			attachScreenshot();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
