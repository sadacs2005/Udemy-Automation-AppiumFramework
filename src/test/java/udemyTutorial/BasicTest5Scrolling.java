package udemyTutorial;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicTest5Scrolling extends base {
    public static void main(String args[]) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=Capabilities("real");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
       
        //Android code to automate the scroll operation. No appium code present in the latest version to do this 
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));").click();
    }
 }

