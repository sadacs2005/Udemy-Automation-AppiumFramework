package udemyEcommerceApp;

import static java.time.Duration.ofSeconds;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.ProductPage;
import PageObjects.WebSitePage;
import PageObjects.CartPage;
import static io.appium.java_client.touch.LongPressOptions.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import static io.appium.java_client.touch.TapOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.*;

public class ecommerce_AddToCart extends ecommerce_base {
    AndroidDriver<AndroidElement> driver;
    ProductPage pp;
    CartPage cp;
    WebSitePage wp;
    public AppiumDriverLocalService Server;
    
    @BeforeTest
    public void killAllTaks() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(5000);
    }
    
    @BeforeMethod
    public void Test01_createAppiumDriver() throws IOException, InterruptedException {
        Server=AppiumServerStart();
        driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
   
   // @Test
    public void Test01_addAnItemToCart() throws InterruptedException, IOException {
        pp=new ProductPage(driver); 
        cp=new CartPage(driver);
        eCommerce_CommonMethods.loginToGeneralStore(driver);
        eCommerce_CommonMethods.scrollTheProducts("LeBron Soldier 12 ", driver);
        eCommerce_CommonMethods.addElementToCart("LeBron Soldier 12 ", driver);
         pp.cartButton.click();
         Thread.sleep(3000);
         //Verify the selected item is present in the cart
         String prodName=cp.ProductNameInCart.getText();
         Assert.assertTrue(prodName.equals("LeBron Soldier 12 "));
         AppiumServerStop();
    }
    
   @Test
    @SuppressWarnings("rawtypes")
    public void Test02_TotalAmountInCheckoutPage() throws InterruptedException, IOException {
        pp=new ProductPage(driver);
        cp=new CartPage(driver);
        
        driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        eCommerce_CommonMethods.loginToGeneralStore(driver);
        eCommerce_CommonMethods.scrollTheProducts("Air Jordan 4 Retro", driver);
        eCommerce_CommonMethods.addElementToCart("Air Jordan 4 Retro", driver);
        eCommerce_CommonMethods.scrollTheProducts("LeBron Soldier 12 ", driver);
        eCommerce_CommonMethods.addElementToCart("LeBron Soldier 12 ", driver);
        pp.cartButton.click();
       
        //To avoid when same object is present in multiple pages
        Thread.sleep(3000);
        double TotalCount=CartPage.PerformProductPriceCalculation(driver);
               // eCommerce_CommonMethods.PerformProductPriceCalculation(driver,cp);
        cp.VerifyTotalPurchaseAmtValue(TotalCount,driver);
        
        //Use mobile gestures 
        TouchAction t=new TouchAction(driver);
       
        //Tap on the checkbox
        WebElement checkbox=cp.cartCheckBox;
        t.tap(tapOptions().withElement(element(checkbox))).perform();
        
        //Long press on terms and conditions
        WebElement termsAndConditions= cp.termsAndConditions;
        t.longPress(longPressOptions().withElement(element(termsAndConditions)).withDuration(ofSeconds(2))).release().perform();
        
        //Close the terms and conditions
        cp.termsAndConditionsCloseBtn.click();
        
        //open the browser version
        cp.visitWebsite.click();
        
        //Get all the contexts
        Thread.sleep(10000);
        java.util.Set<String> context= driver.getContextHandles();
        for(Object contextName:context ) {
            System.out.println("The context is "+contextName);
        }
        
        //Switch to web context
        driver.context("WEBVIEW_com.androidsample.generalstore");
        wp=new WebSitePage(driver);
        wp.inputField.sendKeys("Swami Vivekananda");
        wp.inputField.sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        AppiumServerStop();
    }
}
