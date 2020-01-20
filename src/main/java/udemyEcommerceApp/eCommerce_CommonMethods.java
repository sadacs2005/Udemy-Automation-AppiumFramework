package udemyEcommerceApp;

import org.openqa.selenium.By;
import org.testng.Assert;

import PageObjects.ProductPage;
import PageObjects.CartPage;
import PageObjects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class eCommerce_CommonMethods {
    HomePage hp;
    ProductPage ac;
   
    public static void loginToGeneralStore(AndroidDriver<AndroidElement> driver) {
        HomePage hp = new HomePage(driver);
        
        hp.YourName.sendKeys("Anu");
        hp.FemaleGender.click();
        hp.CountryDropDown.click();
        scrollToTextAndClick("Aruba", driver);
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));").click();
        hp.LetsShopButton.click();
        
    }

    public static void addElementToCart(String prodName,AndroidDriver<AndroidElement> driver) {
        ProductPage ac =new ProductPage(driver);
        scrollTheProducts(prodName, driver);
        int size=ac.ProductName.size(); 
        for(int i=0;i<size;i++) {
            String productName=ac.ProductName.get(i).getText();
            if(productName.equals(prodName)) {
                ac.addToCart.get(i).click();
                break;
            }
        }
    }
    
    public static void verifyCounterTextInCart(String counter,AndroidDriver<AndroidElement> driver) {
        ProductPage ac =new ProductPage(driver);
        String count=ac.counterText.getText();
        Assert.assertTrue(count.equals(counter));
    }
    
    public static void scrollToTextAndClick(String text,AndroidDriver<AndroidElement>driver) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));").click();
        
    }
    
    public static void scrollTheProducts(String ProductName,AndroidDriver<AndroidElement>driver) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\""+ProductName+"\"));");
        // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"LeBron Soldier 12 \").instance(0))")); 
 
    }

   
}
