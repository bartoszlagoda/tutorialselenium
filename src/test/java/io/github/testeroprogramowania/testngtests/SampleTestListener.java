package io.github.testeroprogramowania.testngtests;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am starting test");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("I am taking screenshot");
    }
    }
