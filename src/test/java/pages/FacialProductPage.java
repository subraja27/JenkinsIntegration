package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.And;

public class FacialProductPage extends BaseClass{
	
	@And("Click Products under FacialProduct")
	public void clickFacialProduct() {
		try {
			driver.findElement(By.xpath("//p[text()='Facial Products']/following::p")).click();
			attachScreenshot();
		} catch (Exception e) {
			System.out.println(e);
			attachScreenshot();
		}
	}
	
	@And("Click LipFantastic link")
	public void clickLipFantastic() {
		
        try {
			driver.findElement(By.xpath("//p[text()='Lip Fantastic']")).click();
			attachScreenshot();
		} catch (Exception e) {
			System.out.println(e);
			attachScreenshot();
		}
	}

}
