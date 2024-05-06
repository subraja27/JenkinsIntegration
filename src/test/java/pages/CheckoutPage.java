package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;
import io.cucumber.java.en.When;

public class CheckoutPage extends BaseClass{
	
	@When("Select a shipping method")
	public void select_a_shipping_method() {
		try {
			WebElement ddEle = driver.findElement(By.name("fulfillment[shipping_method]"));
			Select sec = new Select(ddEle);
			sec.selectByVisibleText("Worldwide - $5.00 USD");
			attachScreenshot();
		} catch (Exception e) {
			
			e.printStackTrace();
			attachScreenshot();
		}
	}

	@When("Click Make Payment button")
	public void click_make_payment_button() {
		try {
			driver.findElement(By.xpath("//button[text()='Make payment']")).click();
			attachScreenshot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attachScreenshot();
		}
	}

}
