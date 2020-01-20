package udemyTutorial;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.*;
import static io.appium.java_client.touch.LongPressOptions.*;
import static java.time.Duration.*;

public class BasicTest4Swipe extends base{
    public static void main(String args[]) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=Capabilities("real");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
       //Here instead of attribute name , we used //* because the class-name has special character "$"
        driver.findElementByXPath("//*[@content-desc='9']").click();
        
        //Swipe actions-> long press//on element// 2 seconds//move to another element//release
        TouchAction t=new TouchAction(driver);
        WebElement first=driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second=driver.findElementByXPath("//*[@content-desc='55']");
        t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
    }
}
