package udemyTutorial;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

    public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {
        File fl= new File("ApiDemos-debug.apk");
        DesiredCapabilities cap=new DesiredCapabilities();
        if(device.equals("emulator")) {
          cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator28");
        }
        else if(device.equals("real")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        }
        cap.setCapability(MobileCapabilityType.APP, fl.getAbsolutePath());
       // cap.setCapability("appPackage", "com.google.android.permissioncontroller");
        //cap.setCapability("appActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
        //cap.setCapability("autoGrantPermissions",true);
        //cap.setCapability("appWaitActivity","com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
        AndroidDriver <AndroidElement> driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        return driver;
    }
}
