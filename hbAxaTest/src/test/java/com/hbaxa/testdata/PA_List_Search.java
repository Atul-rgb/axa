package com.hbaxa.testdata;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hbaxa.pageobjects.PreApproval_Indexing_Page;
import com.hbaxa.pageobjects.PreApproval_PA_List_Page;
import com.hbaxa.utilities.ReadConfig;
import com.hbaxa.utilities.Xls_Reader;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class PA_List_Search {
	
	//Xls_Reader paRead = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata.xlsx");
	
	ReadConfig readconfig = new ReadConfig();
	Xls_Reader paRead;
	WebDriver ldriver;
	WebDriverWait wait;
	PreApproval_PA_List_Page preApproval_PA_List_Page;
	public PA_List_Search(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		preApproval_PA_List_Page=new PreApproval_PA_List_Page(ldriver);
		
	}
	public PA_List_Search() {

		if (readconfig.gethostname().equalsIgnoreCase("SIT_STAGE4(GI)")) {

			paRead = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_SITS4.xlsx");

		} else if (readconfig.gethostname().equalsIgnoreCase("UAT_STAGE4")) {

			paRead = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_UATS4.xlsx");
		}

	}
	
	public String getSearchPolicy(int row, String getsPolicy)
	{
		String sPolicy = paRead.getCellData("GIPA", getsPolicy, row);
		//System.out.println("SearchPolicy is :=" +sPolicy);
		return sPolicy;
	}
	
	
	
	
	
}
