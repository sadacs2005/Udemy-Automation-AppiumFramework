package udemyEcommerceApp;

import org.testng.annotations.DataProvider;

    public class TestData {
    @DataProvider(name="InputData")
    public Object[][] inputData() {
        Object [][] obj=new Object[][] {
            {"Anu"},{"!@#$"}
        };
        return obj;
    }
}
