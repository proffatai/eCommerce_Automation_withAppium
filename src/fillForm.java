import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class fillForm extends BaseTest{
	
	//fill all the data required and successfully submit the form
	@Test
	public void fillFormData() throws InterruptedException {
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text (\"Chad\"))")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ibrahim Fatai");
		
		driver.hideKeyboard(); // hide the keyboard after typing so that other elements are visible
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Assertion to verify that the next page got opened
		String expectedTitle=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		Assert.assertEquals(expectedTitle, "Products");
		
		Thread.sleep(5000);
	}
	
	//@Test(enabled=false) // done to skip a test in  TestNG
	public void fillSomeFormData() throws InterruptedException {
	//Afganistan is selected by default
	// we didnt fill in the name and we have decided to click the let's shop button, let's handle validate the error messages
		driver.hideKeyboard(); // hide the keyboard after typing so that other elements are visible
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Assertion to catch the error message
		String errorMessage=driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(errorMessage, "Please enter your name");
		Thread.sleep(3000);
	}
}
