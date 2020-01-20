package udemyTutorial;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicTest8BrowserLaunchCricbuzz extends baseChrome {
    
    public static void main(String args[]) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=Capabilities();
        driver.get("http://cricbuzz.com");
        driver.findElementByXPath("//a/span[normalize-space(text())='Menu']").click();
        driver.findElementByXPath("//a[@title='Cricbuzz Home']").click();
        JavascriptExecutor jsc= (JavascriptExecutor)driver;
        jsc.executeScript("window.scrollBy(0,900)", "");
        Assert.assertTrue(driver.findElementByXPath("//h4[text()='Upcoming Fixtures']").getAttribute("class").contains("header"));
        
    }

}
