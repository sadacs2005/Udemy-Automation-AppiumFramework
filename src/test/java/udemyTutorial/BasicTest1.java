package udemyTutorial;
import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicTest1 extends base  {
    
    public static void main(String args[]) throws MalformedURLException {
        AndroidDriver<AndroidElement>driver=Capabilities("real");
     
        //Different ways to identify UI elements
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("SadaAnu");
        driver.findElementsByClassName("android.widget.Button").get(1).click();
    }

}
