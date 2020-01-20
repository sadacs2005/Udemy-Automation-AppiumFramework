package udemyTutorial;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicTest9BrowserLaunchESPNCricinfo extends baseChrome {
    
    @Test
    public void Test01_googleSearch() throws MalformedURLException {
        
        AndroidDriver<AndroidElement> driver=Capabilities();
        driver.get("https://www.espncricinfo.com/");
        driver.findElementByXPath("//a/span[text()='Edition GL']").click();
        driver.findElementByXPath("//a[@data-edition-link='espncricinfo-en-in']//span[text()='India']").click();
    }

}
