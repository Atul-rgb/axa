package com.hbaxa.utilities;

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hbaxa.testcases.BaseClass;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public static final String KEY1 = "tc_row";
	String get_row;
	
	public static final String KEY2 = "test_name";
	String get_test_name;
	
	ReadConfig readconfig = new ReadConfig();
	
	String host_name = readconfig.gethostname();
	String environment = readconfig.getenvironment();
	String user = readconfig.getuser();
	String currentrow = BaseClass.currentRow;
	

	
	//@Parameters(value="tc_row")
	public void onStart(ITestContext testContext)
	{
		get_row = testContext.getCurrentXmlTest().getParameter(KEY1);
		get_test_name = testContext.getCurrentXmlTest().getParameter(KEY2);
				
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		//String repName="Test-Report-"+row+""+timeStamp+".html";
		String repName=get_row+"_Test-Report-"+get_test_name+timeStamp+".html";

		//htmlRepor String rowter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		
//===================================old code comment to create new report folder=============================================		
		
	//	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\target\\Screenshots\\"+repName);
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\target\\AutomationReport\\"+repName);
//===================================================================================================================================		
		
		//htmlReporter=new ExtentHtmlReporter("..\\target\\"+repName);
		
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name",host_name);
		extent.setSystemInfo("Environemnt",environment);
		extent.setSystemInfo("User",user);
		
		htmlReporter.config().setDocumentTitle("HBAXA Test Project"); // Tile of report
		htmlReporter.config().setReportName("HBAXA Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	
	//@Parameters(value="tc_row")
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		//logger.pass("This test contains result from "+row+" data.");
		System.out.println("Current row is=="+currentrow);
			
		String screenshotPath=System.getProperty("user.dir")+"\\target\\Screenshots\\"+get_row+"_Success_"+tr.getName()+".png";
		//String screenshotPath="..\\Screenshots\\"+get_row+"_Success_"+tr.getName()+".png";
		

		//Reporter.addStepLog("<a href='file:///C:/Users/anbajaj/Desktop/test.xml'>Response</a>"); 
		//logger.log(Status.INFO,"<a href='file:///C://AutoScriptsEImed//hbAxaTest//target//log//hbAxa_application.log'>See Log</a>");
		
		//logger.log(Status.INFO,"<a href='..//log//hbAxa_application.log'>Click here to see Complete Log</a>");
		
		
		
		
		//=======================================Below code comment For removing log message from extend report RND 05-07-2024=============================
		//logger.log(Status.INFO,"<a href='.//hbAxa_application.log'>Click here to see Complete Log</a>");
		
		
		//============================================================================
		
		//logger.log(Status.INFO,"<a href='..//Screenshots//"+get_row+"_Success_"+tr.getName()+".png'><img src='..//Screenshots//"+get_row+"_Success_"+tr.getName()+".png' width='100' height='50' alt='click here for full View'></a>");
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			//logger.pass("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			logger.log(Status.INFO,"<a href='..//Screenshots//"+get_row+"_Success_"+tr.getName()+".png'><img src='..//Screenshots//"+get_row+"_Success_"+tr.getName()+".png' width='100' height='50' alt='click here for full View'></a>");
			} 
		//catch (IOException e) 
		catch (Exception e) 
			{
			e.printStackTrace();
			}
		}
	}
	
	//@Parameters(value="tc_row")
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the failed information to the report with RED color highlighted
		logger.log(Status.INFO, MarkupHelper.createLabel(tr.getInstanceName(), ExtentColor.BLUE));
		//logger.fail("This test contains result from "+row+" data.");
		logger.fail(tr.getThrowable());
		
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());		
		//String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+"_"+timeStamp+".png";
		//String screenshotPath=System.getProperty("user.dir")+"\\target\\Screenshots\\"+row+"_"+tr.getName()+".png";		
		
		
		String screenshotPath=System.getProperty("user.dir")+"\\target\\Screenshots\\"+get_row+"_"+tr.getName()+".png";
		//String screenshotPath="..\\Screenshots\\"+get_row+"_"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			//logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			logger.log(Status.INFO,"<a href='..//Screenshots//"+get_row+"_"+tr.getName()+".png'><img src='..//Screenshots//"+get_row+"_"+tr.getName()+".png' width='100' height='50' alt='click here for full View'></a>");
			} 
		//catch (IOException e) 
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
