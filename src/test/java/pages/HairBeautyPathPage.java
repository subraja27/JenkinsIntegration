package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;
import io.cucumber.java.en.When;

public class HairBeautyPathPage extends BaseClass{

	@When("Click Addtocart button")
	public void click_addtocart_button() {

		try {
			driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
			attachScreenshot();
		} 
		catch (ElementClickInterceptedException e) {
			WebElement addToCartEle = driver.findElement(By.xpath("//span[text()='Add to cart']"));
			wait.until(ExpectedConditions.visibilityOf(addToCartEle));
			addToCartEle.click();
		}

		catch (Exception e) {
			System.out.println(e);
			attachScreenshot();
		}

	}

	@When("Click on the cart button")
	public void click_on_the_cart_button() {
		try {
			driver.findElement(By.xpath("//div[@class='cart-animation']")).click();
			attachScreenshot();
		} catch (Exception e) {
			System.out.println(e);
			attachScreenshot();
		}
	}

	@When("Click Checkout button")
	public void click_checkout_button() {
		try {
			driver.findElement(By.linkText("Checkout")).click();
			attachScreenshot();
		} 
		catch (StaleElementReferenceException e) {
			WebElement element = driver.findElement(By.linkText("Checkout"));
			wait.until(ExpectedConditions.stalenessOf(element));
			element.click();
			attachScreenshot();

		}
		catch (JavascriptException e) {
			WebElement checkoutEle = driver.findElement(By.linkText("Checkout"));
			driver.executeScript("arguments[0].click();", checkoutEle);
			attachScreenshot();
		}

		catch(Exception e) {
			System.out.println(e);
			attachScreenshot();
		}
	}
}
