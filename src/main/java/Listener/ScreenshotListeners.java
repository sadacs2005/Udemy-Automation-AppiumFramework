package Listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import udemyEcommerceApp.ecommerce_base;

public class ScreenshotListeners implements ITestListener {
    
    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //screenshot 
        String s=result.getName();
        try {
        ecommerce_base.getScreenshot(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
