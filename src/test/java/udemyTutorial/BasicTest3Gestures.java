package udemyTutorial;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.springframework.util.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.*;
import static io.appium.java_client.touch.LongPressOptions.*;
import static java.time.Duration.*;

public class BasicTest3Gestures extends base {
    
    public static void main(String args[]) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=Capabilities("emulator");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        
        //Perform touch actions
       TouchAction t=new TouchAction(driver);
       WebElement expandableLists= driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
       //Perform tap on an element
        t.tap(tapOptions().withElement(element(expandableLists))).perform();
        WebElement customAdapter  = driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
        //Perform tap on an element
        t.tap(tapOptions().withElement(element(customAdapter))).perform();
        WebElement peopleNames  = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        //Perform long press on an element
        t.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();
        
        //Check if the frame layout exists after a long press
        driver.findElementByClassName("android.widget.FrameLayout").isDisplayed();
        Assert.isTrue(driver.findElementByClassName("android.widget.FrameLayout").isDisplayed(), "The framelayout exists");
        
        
    }
}
