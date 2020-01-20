package udemyTutorial;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.*;

public class BasicTest6DragDrop extends base{

    public static void main(String args[]) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=Capabilities("real");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
       WebElement source=driver.findElementsByClassName("android.view.View").get(0);
       WebElement destination=driver.findElementsByClassName("android.view.View").get(2);
        TouchAction t=new TouchAction(driver);
        //Actual Actions->longPress(source)/moveTo(destination/release)
        t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
    }
}
