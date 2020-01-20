package udemyTutorial;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicTest7BrowserLaunchFacebook extends baseChrome {
    
    public static void main(String args[]) throws MalformedURLException {
       AndroidDriver<AndroidElement> driver= Capabilities();
       driver.get("http://www.facebook.com");
       driver.findElementByXPath("//input[@placeholder='Mobile number or email address']").sendKeys("abc@gmail.com");
       driver.findElementByXPath("//input[@placeholder='Password']").sendKeys("xyz123");
       driver.findElementByXPath("//button[@name='login']").click();
    }
}
