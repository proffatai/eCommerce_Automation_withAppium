import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text (\"Jordan 6 Rings\"))"));
		
		int  productCount=driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size(); // hold the count of the total items appearing on the screen at that point in time
		
		for (int i=0; i<productCount; i++) {
			String  productName=driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText(); // getting the product name of each item
			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();// accessing the ADD TO CART button of each item
			}
			}
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click(); // click the cart icon
		
		//Let's provide assertion to verify if the item we clicked on now appears on the cart page
		//Method 1: we hopoe that once the cart icon is clicked, the next cart page opens on time
//		String itemName= driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
//		Assert.assertEquals(itemName, "Jordan 6 Rings");
		
		
		// Method 2: We want to use Explicit wait such that, we want to apply the assertion only when we see the Cart page
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5)); //created of obj of WebDriverWait for 5secs
		//Now, we are waiting until driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")) has an attribute of text whose value is Cart
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		//Now let's apply assertion, we are sure that the Cart page has loaded
		String itemName= driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(itemName, "Jordan 6 Rings");
		
		
		driver.findElement(AppiumBy.xpath("//android.widget.CheckBox")).click(); // click the checkbox
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
	}
	

}
