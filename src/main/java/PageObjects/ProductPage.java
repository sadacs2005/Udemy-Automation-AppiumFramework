package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {

    public ProductPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    public List<WebElement> ProductName;
    
    @AndroidFindBy(xpath ="//*[@text='ADD TO CART']")
    public List<WebElement> addToCart;
    
    @AndroidFindBy(xpath = "//*[@resource-id='com.androidsample.generalstore:id/counterText']")
    public WebElement counterText;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement cartButton;
    

}
