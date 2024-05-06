package runner;

import base.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features="src/test/java/features/PurchaseBeautyProduct.feature",
	    glue = "pages",
	    plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
	    monochrome=true,
	    publish=true
	)

public class CucumberRunner extends BaseClass {

}
