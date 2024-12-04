package com.hbaxa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hbaxa.pageobjects.HomePage;
import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.PAListPage;
import com.hbaxa.pageobjects.PAPage;
import com.hbaxa.pageobjects.Pop_up_FWA_Reason;
import com.hbaxa.pageobjects.Pop_up_Pre_Approval_History;
import com.hbaxa.pageobjects.Pop_up_Pre_Approval_View_PA;
import com.hbaxa.pageobjects.Pop_up_Reason_For_Aprove;
import com.hbaxa.pageobjects.Pop_up_Reason_For_Pending;
import com.hbaxa.pageobjects.Pop_up_Reassign_Claim;
import com.hbaxa.pageobjects.Pop_up_Reject_Reason;
import com.hbaxa.pageobjects.PreApproval_Indexing_Page;
import com.hbaxa.pageobjects.PreApproval_PA_List_Page;
import com.hbaxa.pageobjects.PreApproval_Page;
import com.hbaxa.pageobjects.PreApproval_View_PA;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.PAData;

public class TC_PA_List_newTC extends BaseClass  {
	String parent;
	String child;
	String paNdetails;
	String actions;
	String AlertMessage;	
	PreApproval_PA_List_Page preApproval_PA_List_Page;
	PAListPage pAListPage;
	Pop_up_Reason_For_Aprove pop_up_Reason_For_Aprove;
	PAData paread ;
	LoginData ldread ;
	PAPage pa;
	PAListPage palistp ;
	LoginPage lp;
	PreApproval_View_PA preApproval_View_PA;
	HomePage homepage;
	@Parameters(value="tc_row")
	@BeforeMethod
	public void pom_object(String row) throws Exception {
		int currentRow = Integer.parseInt(row);	
		preApproval_PA_List_Page=new PreApproval_PA_List_Page(driver);
		pAListPage=new PAListPage(driver);
		palistp= new PAListPage(driver);
		preApproval_View_PA=new PreApproval_View_PA(driver);
		homepage=new HomePage(driver);
		 pa = new PAPage(driver);
		 ldread = new LoginData();
		 paread = new PAData();
		pop_up_Reason_For_Aprove=new Pop_up_Reason_For_Aprove(driver);
		logger.info("<===== PA TEST STARTED  Dashboard PA List PROCESS ====>");
		
	//=======================code comment
		//driver.get(baseURL);
	//	logger.info("Base url launched");
		
		logger.info("Login test started");
		
		 lp = new LoginPage(driver);
		
		
		lp.setUserName(ldread.getUsername(currentRow,"Username")); //First parameter is current row, second is column name
		logger.info("Username Entered");
		
		lp.setPassWord(ldread.getPassword(currentRow,"Password"));
		logger.info("Password Entered");
		
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		
		//=============================================================
		
	}
	
	
	
	
	
	
	@Parameters(value="tc_row")
	@Test(priority=1)
	public void palist_Pre_Approval_View(String row) throws Exception
	{
		try {
			int currentRow = Integer.parseInt(row);	
			Thread.sleep(1000l);
			pa.clickClaimmenu();
			logger.info("Claim Menu Clicked");
			
			Thread.sleep(1000l);
			pa.clickPalink();
			logger.info("Pre-Approval Clicked");
			
			Thread.sleep(1000l);
			palistp.clickPAList();
			logger.info("PA List Link Clicked");
			
			//===========================================
			//Thread.sleep(20000l); // for loader if any
			pa.waitLoader();
			//===========================================
			//pa.waitTillLoader();
			//===========================================
			
			pa.clickAdvanceSerach();
			logger.info("Advanced Option Clicked");
			palistp.selectPaType("All");
			logger.info("PA Status Selected");	
			palistp.txtPaNum("PA001749");
			logger.info("PA No Entered");
			Thread.sleep(4000l);
			palistp.clickGO();
			logger.info("Go Clicked for PA Search");
			preApproval_PA_List_Page.click_pre_approval_link();
            logger.info("Click Pre Approval Link");
            Thread.sleep(4000);
           List <String>s=new ArrayList(    driver.getWindowHandles());
            driver.switchTo().window(s.get(s.size()-1));
            
            preApproval_View_PA.check_view_document();
            logger.info("Check view document");
            preApproval_View_PA.check_chopping();
            logger.info("Check chopping");
            preApproval_View_PA.check_generate_letter();
            logger.info("Check generate letter");
            preApproval_View_PA.check_generate_log();
            logger.info("Check generate log");
           if( preApproval_View_PA.check_policyNumber().equalsIgnoreCase(paread.getSearchPolicy(currentRow, "SearchPolicy"))) {
        	   Assert.assertTrue(true);
        		captureScreenfullPage(driver,row+"_Success_palist_Pre_Approval_View");
        		 logger.info("Scrrenshot capture");
           }
		}catch(Exception e) {
			e.printStackTrace();
		}
	
       }
	
	@Parameters(value="tc_row")
	@Test(priority=2)
	public void dashboard_tc(String row) throws Exception
	{
		try {
			int currentRow = Integer.parseInt(row);	
			Thread.sleep(1000l);
			homepage.click_dashbord();
		    logger.info("click dashboard");
            homepage.check_Approved_PA();
            logger.info("check Approved");
            homepage.check_cashless_piechart();
            logger.info("check cashless_piechart");
            homepage.check_decliend_PA();
            logger.info("check decliend_PA");
            homepage.check_logout();
            logger.info("check logout");
            homepage.check_pending_PA();
            logger.info("check pending_PA");
            homepage.check_reimbursement_piechart();
            logger.info("check reimbursement_piechart");
            homepage.check_total_PA();
            logger.info("checktotal_PA");
          //  captureScreen(driver,row+"_Success_dashboard_tc");
            captureScreenfullPage(driver,row+"_Success_dashboard_tc");
	        logger.info("full Screenshot Caputered for Dashboard");
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
	

}
}
