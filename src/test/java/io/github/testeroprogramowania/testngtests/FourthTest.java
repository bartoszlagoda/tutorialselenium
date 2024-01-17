package io.github.testeroprogramowania.testngtests;

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
}
