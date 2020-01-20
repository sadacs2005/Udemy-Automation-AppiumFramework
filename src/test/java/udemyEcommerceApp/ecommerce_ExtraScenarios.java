package udemyEcommerceApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_ExtraScenarios extends ecommerce_base{
    AndroidDriver<AndroidElement> driver=null;
    
    @Test
    public void Test01_ValidateToastMsgClickCartOnNoItemsSelected() throws IOException, InterruptedException {
     driver =Capabilities();   
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     eCommerce_CommonMethods.loginToGeneralStore(driver);
     driver.findElementByXPath("//*[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']").click();
     String Toastmsg=driver.findElementByXPath("//android.widget.Toast").getAttribute("name");
     Assert.assertTrue(Toastmsg.contentEquals("Please add some product at first"));
    }
    
    @Test
    public void Test02_AddExtraItemToCart() throws InterruptedException, IOException {
     driver=Capabilities();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     eCommerce_CommonMethods.loginToGeneralStore(driver);
     eCommerce_CommonMethods.addElementToCart("Converse All Star",driver); 
     eCommerce_CommonMethods.verifyCounterTextInCart("1", driver);
     driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/appbar_btn_back']")).click();
     eCommerce_CommonMethods.addElementToCart("LeBron Soldier 12 ",driver);
     eCommerce_CommonMethods.verifyCounterTextInCart("2", driver);
    }
    
 

}
