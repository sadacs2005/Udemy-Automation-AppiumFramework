package udemyTutorial;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicTest2UIAutomator extends base{
   
    //Finding elements using Android UI operator
    public static void main(String args[]) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=Capabilities("emulator");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
       // driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
        
        //Check the condition if any of the element has isclickable() property is enabled
        int size =driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
        System.out.println("The total clickable elements are "+size);
        
    }
  

}
