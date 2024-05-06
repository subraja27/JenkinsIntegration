package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass{

	@When("Click on ShopNow button")
	public void click_on_shop_now_button() {
 
		try {
			driver.findElement(By.linkText("Shop now")).click();
			attachScreenshot();
		} 

		catch (Exception e) {
			System.out.println(e);
			attachScreenshot();
		}
	}

}
