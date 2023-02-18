import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class add2Cart extends BaseTest{
	
	//fill all the data required and successfully submit the form
	@Test
	public void fillFormData() throws InterruptedException {
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text (\"Algeria\"))")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ibrahim Fatai");
		
		driver.hideKeyboard(); // hide the keyboard after typing so that other elements are visible
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Assertion to verify that the next page got opened
		String expectedTitle=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		Assert.assertEquals(expectedTitle, "Products");
		
		Thread.sleep(5000);
	}
	

}
