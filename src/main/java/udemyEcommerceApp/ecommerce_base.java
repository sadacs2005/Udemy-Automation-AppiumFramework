package udemyEcommerceApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ecommerce_base {
    
    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;
    
    public AppiumDriverLocalService AppiumServerStart() {
        boolean flag=   checkIfServerIsRunnning(4723);
        if(!flag)
        {
            
            service=AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
            return service;
    }
    
    
    public static AndroidDriver<AndroidElement> Capabilities() throws IOException, InterruptedException {
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\udemyEcommerceApp\\global.properties");
        Properties prop=new Properties();
        prop.load(fis);
        File app=new File((String) prop.get("GeneralStoreApp"));
        String deviceName= System.getProperty("DeviceName");
        if(deviceName==null)
        {
            deviceName=prop.getProperty("DeviceName");
        }
        
        if(deviceName.contains("Emulator")) {
            emulatorStart();
        }
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        return driver;
    }
    
    public static boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
    
    public static void AppiumServerStop() {
        service.stop();
    }
    
    public static void emulatorStart() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\EmulatorStart.bat");
        Thread.sleep(6000);
    }
    
    public static void getScreenshot(String s) throws IOException {
        File scrfile=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
    }
}
