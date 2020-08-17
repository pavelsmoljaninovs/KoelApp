package unitTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculationTest {


    @DataProvider(name="Ages")
    public Object[][] createData(){
        return new Object[][]{
                {1,1000,0.0},
                {2,1000,0.0},
                {3,1000,500.0},
                {10,1000,500.0},
                {20,1000,1000.0},
                {70,1000,800.0}
        };
    }





}
