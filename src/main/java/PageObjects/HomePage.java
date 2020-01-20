package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
    
    //Android driver received from the Test Method
    public HomePage(AndroidDriver<AndroidElement> driver) {
        //AppiumFieldDecorator->Provides compatibility for both Android and IOS
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    public WebElement YourName;

    @AndroidFindBy(xpath="//*[@text='Female']")
    public WebElement FemaleGender;
    
    @AndroidFindBy(id="android:id/text1")
    public WebElement CountryDropDown;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    public WebElement LetsShopButton;
    
    @AndroidFindBy(xpath="//android.widget.Toast")
    public WebElement ToastMsg;
}
