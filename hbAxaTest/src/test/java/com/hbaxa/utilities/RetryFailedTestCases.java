package com.hbaxa.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
	ReadConfig readconfig = new ReadConfig();
	
    private int retryCnt = readconfig.retryCount();
    //You could mentioned maxRetryCnt (Maximum Retry Count) as per your requirement. Here I took 2, If any failed testcases then it runs two times
    private int maxRetryCnt = readconfig.maxRetryCount();
    
    //This method will be called every time a test fails. It will return TRUE if a test fails and need to be retried, else it returns FALSE
    public boolean retry(ITestResult result) {
        if (retryCnt < maxRetryCnt) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
        return false;
    }
   
}