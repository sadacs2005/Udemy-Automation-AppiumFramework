package udemyEcommerceApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.HomePage;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class ecommerce_HomePage extends ecommerce_base {
    static AndroidDriver<AndroidElement> driver=null;
    public AppiumDriverLocalService service;
    HomePage hp;
    
   @BeforeTest
   public void killAllTaks() throws IOException, InterruptedException {
       Runtime.getRuntime().exec("taskkill /F /IM node.exe");
       Thread.sleep(5000);
   }
   
    @BeforeMethod
    public void Test01_createAppiumDriver() throws IOException, InterruptedException {
        service =AppiumServerStart();
        driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    //Constructor used to pass the driver to the HomePage Class 
    
    @Test(dataProvider = "InputData",dataProviderClass = TestData.class)
    public void Test01_BasicPurchaseFlow(String inputData) throws MalformedURLException {
        HomePage hp=new HomePage(driver);
        hp.YourName.sendKeys(inputData);
       // driver.hideKeyboard();
        hp.FemaleGender.click();
        hp.CountryDropDown.click();
        eCommerce_CommonMethods.scrollToTextAndClick("Algeria", driver);
        hp.LetsShopButton.click();
        AppiumServerStop();
    }
    
    @Test
    public void Test02_VerifyToastMessage() throws MalformedURLException {
        HomePage hp=new HomePage(driver);
        hp.CountryDropDown.click();
        eCommerce_CommonMethods.scrollToTextAndClick("Algeria", driver);
        hp.FemaleGender.click();
        hp.LetsShopButton.click();
        String Toastmsg=hp.ToastMsg.getAttribute("name");
        Assert.assertEquals(Toastmsg, "Please enter your name");
       AppiumServerStop();
    }
    
}
