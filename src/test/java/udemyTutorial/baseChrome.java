package udemyTutorial;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseChrome {
    
    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60");
        AndroidDriver <AndroidElement> driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        return driver;
    }
}
