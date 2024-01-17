package io.github.testeroprogramowania.testngtests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// zaleznosci miedzy metodami są ogólnie niezalecane
public class FourthTest extends BaseTest{
    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest(){
        System.out.println("I'm first test");
    }

    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest(){
        System.out.println("I'm second test");
    }

    @Test
    public void thirdTest(){
        System.out.println("I'm third test");
    }

    @Test(dataProvider = "data")
    public void fourthTest(String value){
        System.out.println(value);
    }

    @Test(dataProvider = "dataWithNumbers")
    public void fifthTest(String value, String number){

        System.out.println(value);
        System.out.println(number);
    }
    @DataProvider(name = "data")
    public Object[][] dataProvider(){
        return new Object[][]{{"I am first test"},
                              {"I am second test"},
                              {"I am third test"}};
    }

    @DataProvider(name = "dataWithNumbers")
    public Object[][] dataProviderForSecondTest(){
        return new Object[][]{{"I am first test","First"},
                              {"I am second test","Second"},
                              {"I am third test","Third"}};
    }
}
