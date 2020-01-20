package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {

    public CartPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    public WebElement ProductNameInCart;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    public static List <WebElement> ProductPrice;
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement totalPurchaseAmt;
    
    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement cartCheckBox;
    
    @AndroidFindBy(xpath = "//*[@text='Please read our terms of conditions']")
    public WebElement termsAndConditions;
    
    @AndroidFindBy(xpath = "//*[@text='CLOSE']")
    public WebElement termsAndConditionsCloseBtn;
    
    @AndroidFindBy(xpath = "//*[@text='Visit to the website to complete purchase']")
    public WebElement visitWebsite;
    
    
    
    public static double PerformProductPriceCalculation(AndroidDriver<AndroidElement> driver) {
        int priceCount=ProductPrice.size();
        double TotalCount=0;
        for(int i=0;i<priceCount;i++) {
            String price=ProductPrice.get(i).getText();
            price=price.substring(1,price.length());
            double priceInt=Double.parseDouble(price);
            System.out.println("The amount of each product is "+priceInt);
            TotalCount=TotalCount+priceInt;
            }    
        return TotalCount;
    }

    public void VerifyTotalPurchaseAmtValue(double TotalCount, AndroidDriver<AndroidElement> driver) {
        String totalPurchaseAmount=totalPurchaseAmt.getText();
        totalPurchaseAmount=totalPurchaseAmount.substring(1,totalPurchaseAmount.length()).trim();
        System.out.println("The total purchase amount is "+totalPurchaseAmount);
        Assert.assertTrue(TotalCount==Double.parseDouble(totalPurchaseAmount));        
    }

}


