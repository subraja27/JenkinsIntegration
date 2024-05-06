package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.When;

public class CollectionsPage extends BaseClass{
	
	@When("Click Products under HairProducts")
	public void click_products_under_hair_products() {
		try {
			driver.findElement(By.xpath("//p[text()='Hair Products']/following::p")).click();
			attachScreenshot();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@When("Click HairBeautyPath link")
	public void click_hair_beauty_path_link() {
		try {
			WebElement element = driver.findElement(By.xpath("//p[text()='Hair Beauty Bath']"));
			driver.executeScript("arguments[0].click();", element);
			attachScreenshot();
		} catch (Exception e) {
			System.out.println(e);
			attachScreenshot();
		}
	}

}
