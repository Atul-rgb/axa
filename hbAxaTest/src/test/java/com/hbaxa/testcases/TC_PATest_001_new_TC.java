package com.hbaxa.testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.PAListPage;
import com.hbaxa.pageobjects.PAPage;
import com.hbaxa.pageobjects.Pop_up_FWA_Reason;
import com.hbaxa.pageobjects.Pop_up_Pre_Approval_History;
import com.hbaxa.pageobjects.Pop_up_Pre_Approval_View_PA;
import com.hbaxa.pageobjects.Pop_up_Reason_For_Pending;
import com.hbaxa.pageobjects.Pop_up_Reassign_Claim;
import com.hbaxa.pageobjects.Pop_up_Reject_Reason;
import com.hbaxa.pageobjects.PreApproval_Indexing_Page;
import com.hbaxa.pageobjects.PreApproval_Page;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.PAData;

public class TC_PATest_001_new_TC extends BaseClass  {
	String parent;
	String child;
	String paNdetails;
	String toppaNdetails;
	String actions;
	String AlertMessage;
	String alertsAutoaudjudicateClick;
	String alertsApprovedClick;
	String alertsPendingClick;
	PreApproval_Indexing_Page preApproval_Indexing_Page;
	SoftAssert softassert;
	Pop_up_Reassign_Claim pop_up_Reassign_Claim;
	PreApproval_Page preApproval_Page;
	Pop_up_Pre_Approval_History pop_up_Pre_Approval_History;
	Pop_up_Pre_Approval_View_PA pop_up_Pre_Approval_View_PA;
	Pop_up_FWA_Reason pop_up_FWA_Reason;
	Pop_up_Reason_For_Pending pop_up_Reason_For_Pending;
	Pop_up_Reject_Reason pop_up_Reject_Reason;
	public static String paNumber;
	
	PAData paread = new PAData();
	LoginData ldread = new LoginData();
	
	@BeforeMethod
	public void pom_object() {
		preApproval_Indexing_Page=new PreApproval_Indexing_Page(driver);
		softassert=new SoftAssert();
		pop_up_Reassign_Claim=new Pop_up_Reassign_Claim(driver);
		preApproval_Page= new PreApproval_Page(driver);
		pop_up_Pre_Approval_History=new Pop_up_Pre_Approval_History(driver);
		pop_up_Pre_Approval_View_PA=new Pop_up_Pre_Approval_View_PA(driver);
		pop_up_FWA_Reason=new Pop_up_FWA_Reason(driver);
		pop_up_Reason_For_Pending=new Pop_up_Reason_For_Pending(driver);
		pop_up_Reject_Reason=new Pop_up_Reject_Reason(driver);
	}
	
	@Parameters(value="tc_row")
	@Test(priority=1)
	public void paTestManual(String row) throws IOException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);		
			
			PAPage pa = new PAPage(driver);
			
			//Login Scenario
			logger.info("===== PA TEST STARTED THROUGH MANUAL PROCESS ====");
			
			driver.get(baseURL);
			logger.info("Base url launched ==>"+driver.getCurrentUrl());
			
			logger.info("Login test started");
			
			LoginPage lp = new LoginPage(driver);
			
			lp.setUserName(paread.getPaManual(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			lp.setPassWord(paread.getPaManual(currentRow,"Password")); // will make this code later under pa object page
			logger.info("Password Entered");
			
			lp.clickSubmit();
			logger.info("Submit Button Clicked");
			
			//================
			
			Thread.sleep(1000l);
			pa.clickClaimmenu();
		//	logger.info("Claim Menu Clicked");
			
			Thread.sleep(1000l);
			pa.clickPalink();
			logger.info("Pre-Approval Clicked");
			
			Thread.sleep(1000l);
			pa.clickIndexinglink();
			logger.info("Indexing Clicked");
			
			//===========================================
			//Thread.sleep(25000l); //for loader hard coded SLEEP TIME
			pa.waitLoader();
			logger.info("wait Loder");
		//	boolean b=
			if(paread.getPaManual(currentRow, "Pagination").equalsIgnoreCase("Yes")) {
			softassert.assertEquals(preApproval_Indexing_Page.check_Reset_button_display(), true);
			logger.info("Reset button is display");
			softassert.assertEquals(preApproval_Indexing_Page.check_searchButton_display(), true);
			logger.info("Search button is display");
			softassert.assertEquals(preApproval_Indexing_Page.check_Add_Manual_Estimation_button_display(), true);
			logger.info("Add_Manual_Estimation_button_display");
			softassert.assertEquals(preApproval_Indexing_Page.check_go_to_previous_page_display(), true);
			logger.info("go_to_previous_page_display");
			softassert.assertAll();
			softassert.assertEquals(preApproval_Indexing_Page.check_indexing_procced_link(), true);
			logger.info("check proceed link is display on indexing page");
			softassert.assertEquals(preApproval_Indexing_Page.check_indexing_Reassign_link(), true);
			logger.info("check Reasign link is display on indexing page");
			String TATtext=preApproval_Indexing_Page.get_indexing_TAT_data();
			logger.info("TAT text before click="+TATtext);
			preApproval_Indexing_Page.click_indexing_TAT();
			logger.info("Click TAT button");
			Thread.sleep(9000);
			String TATtext2=preApproval_Indexing_Page.get_indexing_TAT_data2();
			logger.info("TAT text after click=="+TATtext2);
			softassert.assertNotEquals(TATtext, TATtext2);
			 logger.info("Check Table data sorting on TAT basis");
			 softassert.assertAll();
			int reassign= preApproval_Indexing_Page.get_indexing_Reassign_list();
			logger.info("Reassign list="+reassign);
			int proceed=preApproval_Indexing_Page.get_indexing_Proceed_list();
			logger.info("proceed list ="+proceed);
			softassert.assertEquals(reassign, proceed);
			logger.info("Verify proceed & reassign option is availanle for all row");
			Thread.sleep(4000);
			softassert.assertEquals(preApproval_Indexing_Page.check_indexing_page_pagination_display(), true);
				logger.info("Check pagination display");
					softassert.assertEquals(preApproval_Indexing_Page.check_pagination_2_button_selecetd(driver), true);
			logger.info("Indexing page pagination pagination_2_button_click");
			softassert.assertEquals(preApproval_Indexing_Page.check_pagination_Previous_button_clickable(driver), true);
			logger.info("Indexing page pagination pagination_previous button click");
			preApproval_Indexing_Page.click_nextButton();
           logger.info("Click next button");
		//	softassert.assertEquals(preApproval_Indexing_Page.check_pagination_Next_button_selecetd(), true);
			//logger.info("Indexing page pagination_Next button click");
			softassert.assertAll();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-950)", "");
			 logger.info("scroll - up");
			 Thread.sleep(2000);
		}
			//===========================================
			//loadTimer.start();
			//pa.clickaddManualPA();
			pa.clickaddManualPA_new(driver);
			
			
			preApproval_Indexing_Page.click_addManualPreAproval_button(driver);
			logger.info("Add Manual Pre-Approval Button Clicked");
			//logger.info("Add Manual Pre-Approval Button Clicked - Time Taken: "+ TimeUnit.MILLISECONDS.toSeconds(loadTimer.getTime()) +" seconds");
			
			//===========================================
			//ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//driver.switchTo().window(tabs.get(1));
			//String parent = driver.getWindowHandle();
			Set <String> st= driver.getWindowHandles();
			Iterator<String> it = st.iterator();
			parent =  it.next();
			child = it.next();
			
			//swtich to parent
			//driver.switchTo().window(parent);
			//System.out.println("Returned to parent");

			// switch to child tab
			driver.switchTo().window(child);
			
			if(paread.getPaManual(currentRow, "Invalid_PolicyNumber").equalsIgnoreCase("Yes")) {
				pa.setSearchPolicy("588567");
				logger.info("Policy Number Entered");
				
				preApproval_Page.wrong_policy_errorMessage();
               logger.info("Check error message");
               
               Thread.sleep(8000);
               pa.clear_data_policy_Field();
			}
		
			//===========================================
			
			//pa.clickShowhide(); // Behavior changed
			//logger.info("Show/Hide Document Button Clicked");
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date()).replace('.', '-');
			// timeStamp
			logger.info("Current date ="+timeStamp);
			String actual_submission_date1=preApproval_Page.check_submission_date().replace(' ', '-');//
			String actual_submission_date2=actual_submission_date1.replace(':', '-');
			logger.info("Pre approval  page submission date ="+actual_submission_date2);
		    boolean b=	actual_submission_date2.contains(timeStamp);
		    logger.info("Result for submission date is same as expected ="+b);
		    softassert.assertEquals(preApproval_Page.check_Aprover_name(), preApproval_Page.check_user_name());
		    logger.info("Approvel name is same as expected="+preApproval_Page.check_Aprover_name());
		    preApproval_Page.click_Pre_approval_History(driver);
		    logger.info("Click Pre approval History");
		     preApproval_Page.check_errorMessage();
		     logger.info("Check Error Pre approval History");
		   
		   
		  //  softassert
			Thread.sleep(8000l);
			pa.setSearchPolicy(paread.getSearchPolicy(currentRow, "SearchPolicy"));
			logger.info("Policy Number Entered");
			int list=preApproval_Page.size_policy_detail();
			logger.info("Policy detail  new show parameter="+list);
			softassert.assertEquals(list, 3);
			softassert.assertAll();
		
			//Thread.sleep(2000l);
			loadTimer.start();
		//	pa.selectPolicy(row);
			pa.selectPolicy2(row);
			loadTimer.stop();
			logger.info("Policy Selected - Time Taken: "+ TimeUnit.MILLISECONDS.toSeconds(loadTimer.getTime()) +" seconds");
			
			//===========================================
			//Thread.sleep(15000l); //For Loader
			pa.waitLoader();
			//===========================================			
			
			//pa.scrolltopad();
			//logger.info("Scroll To Pre Approval Details");
			String actualPolicy=preApproval_Page.check_policyDetail_policy_Number();
			preApproval_Page.click_RefreshFromRLS_button(driver);
            logger.info("Click Refresh from RLS button  ");
            softassert.assertEquals( preApproval_Page.check_alert_message(), true);
			//if(actualPolicy.equalsIgnoreCase("588-9158670")) {
			if(actualPolicy.equalsIgnoreCase(paread.getPaManual(currentRow, "PolicyNumber"))) {
				softassert.assertEquals(true, true);
				logger.info("policy information is reflected same as expected ");
				captureScreenfullPage(driver,row+"_Succsess_policy_Information_popup");
			}else {
				softassert.assertEquals(false, true);
				logger.info("policy information not  reflected  ");
				captureScreenfullPage(driver,row+"_FAIL_policy_Information_popup");
			}
			logger.info("Policy number reflected on policy details="+actualPolicy);
			softassert.assertEquals(preApproval_Page.check_policyDetail_productName(), "Medi-Partner");
			logger.info("Product name is reflected same as on policy details ");
			
			Thread.sleep(3000);
			
			if(paread.getPaManual(currentRow, "Pre_Approval_History").equalsIgnoreCase("Yes")) {
			preApproval_Page.click_Pre_approval_History(driver);
            logger.info("Click Pre-Aproval history tab ");
            int Pre_Aproval_history_record=  preApproval_Page.check_pre_approval_history_Table_record_size();
            logger.info("Pre_Aproval_history_record ="+Pre_Aproval_history_record);
            if(Pre_Aproval_history_record>=2) {
            	softassert.assertTrue(true);
            	 logger.info("Pre_Aproval_history_record is by defoult 2 or more="+Pre_Aproval_history_record);
            }else {
            	softassert.assertTrue(false);
            	 logger.info("Pre_Aproval_history_record is not as same expected ="+Pre_Aproval_history_record);
            }
            preApproval_Page.check_view_more_button_display(driver);
            logger.info("Click view more button");
            pop_up_Pre_Approval_History.select_pre_aproval_status_dropdown("Pending");
            logger.info("Select dropdown option:Pending");
            softassert.assertAll();
            logger.info("Assertion Apply");
            Thread.sleep(4000);
        /*   String result_status= pop_up_Pre_Approval_History.check_table_pre_aproval_status();
           logger.info("result aproval status from table="+result_status);
            if(result_status.equalsIgnoreCase("Pending")){
            	 softassert.assertEquals(true ,true );
				logger.info("Select dropdown option is  shown as expected :Pending.");
				Thread.sleep(3000l);
				captureScreen(driver,row+"_Success_POP_Up_Pre_Approval_History_dropdown_pending");
				
			}else{
				
				 softassert.assertEquals(false,true );
				captureScreen(driver,row+"_FAIL_POP_Up_Pre_Approval_History_dropdown_pending");
			}*/
        pop_up_Pre_Approval_History.click_close_button();
            logger.info("Click popup closed button");
            //==============
            
        	preApproval_Page.click_Pre_approval_History(driver);
            logger.info("Click Pre-Aproval history tab ");
            Thread.sleep(4000);
            preApproval_Page.check_view_more_button_display3(driver);
            logger.info("Click view more button");
            pop_up_Pre_Approval_History.select_pre_aproval_status_dropdown("Select Pre-Approval Status");
            logger.info("Select dropdown option:Select Pre-Approval Status");
         //   pop_up_Pre_Approval_History.enter_data_PAnumbersearch_field("PA001817");
         //   ======old code=========
            pop_up_Pre_Approval_History.enter_data_PAnumbersearch_field(paread.getPaManual(currentRow, "PA_Number"));
            //========================new code===================
          //  pop_up_Pre_Approval_History.enter_new_PA_number(driver, currentRow);
            logger.info("PA number enter in searchfield="+paread.getPaManual(currentRow, "PA_Number"));
            Thread.sleep(2000);
            pop_up_Pre_Approval_History.select_pre_aproval_status_dropdown("Approved");
            pop_up_Pre_Approval_History.select_pre_aproval_status_dropdown("Select Pre-Approval Status");
            logger.info("Select dropdown option:Select Pre-Approval Status");
            Thread.sleep(4000);
            logger.info("PA number reflected="+pop_up_Pre_Approval_History.check_table_pre_aproval_number());
       
            softassert.assertEquals(pop_up_Pre_Approval_History.check_table_pre_aproval_number(), paread.getPaManual(currentRow, "PA_Number"));

            logger.info("check PA number is reflected same as enter");
           softassert.assertEquals(pop_up_Pre_Approval_History.check_PA_number_hyperlink(),"link-title" );
            logger.info("Check PA number is hyperlink");
            logger.info("Check nEW Xpath PA number from execl="+paread.getPaManual(currentRow, "PA_Number"));
        	;
    		
         //   pop_up_Pre_Approval_History.click_PA_number_hyperlink();
           pop_up_Pre_Approval_History.click_new_PA_number(driver, currentRow);;
        	//pa.click_PA_Link2(row);

             logger.info("Click new PA number is hyperlink");
             softassert.assertAll();
             Thread.sleep(8000);
             List <String> s= new ArrayList( driver.getWindowHandles());
             logger.info("Number of window="+s.size());
      
 			// switch to child tab
 			driver.switchTo().window(s.get(3));
 			
 		   String policynumber=	pop_up_Pre_Approval_View_PA.check_policy_number();
 		  logger.info("Policy number from new tab="+policynumber);
 		 if(policynumber.equalsIgnoreCase(pop_up_Pre_Approval_View_PA.check_policy_number())) {
				Assert.assertTrue(true);
				logger.info("PA Link successfully open & Policy Number also reflected same as expected.");
				captureScreenfullPage(driver,row+"_Succsess_PA_link_Open");
				driver.close();
           driver.switchTo().window(s.get(1));
           logger.info("Current URL2="+driver.getCurrentUrl());
			}else {
				Assert.assertTrue(false);
				logger.info("policy number not match");
				captureScreenfullPage(driver,row+"_FAIL_PA_link_Open");
			}
            pop_up_Pre_Approval_History.enter_data_PAnumbersearch_field(" ");
            logger.info("Enter blank data in search field");
           
            logger.info("Error message="+ pop_up_Pre_Approval_History.check_error_message());
            softassert.assertEquals( pop_up_Pre_Approval_History.check_error_message(), "No data Available");
            logger.info("Error message reflected for blank data in Search Pa Field");
                 pop_up_Pre_Approval_History.click_close_button();
            logger.info("Click popup closed button");
           
         //   softassert.assertAll();
            preApproval_Page.check_view_more_button_display2(driver);
            logger.info("Click view more button");
            pop_up_Pre_Approval_History.select_pre_aproval_status_dropdown("Approved");
            logger.info("Select dropdown option:Approved");
            Thread.sleep(2000);
            String result_status2= pop_up_Pre_Approval_History.check_table_pre_aproval_status_approved();
            logger.info("result aproval status="+result_status2);
           /* if(result_status2.equalsIgnoreCase("Pre Approval Approved")){
            	 softassert.assertEquals(true ,true );
				logger.info("Select dropdown option is  shown as expected :Pre Approval Approved.");
				Thread.sleep(3000l);
				captureScreenfullPage(driver,row+"_Success_POP_Up_Pre_Approval_History_dropdown_Approved");
				
			}else{
				
				 softassert.assertEquals(false,true );
					logger.info("Select dropdown option is  not as expected");
				captureScreenfullPage(driver,row+"_FAIL_POP_Up_Pre_Approval_History_dropdown_Approved");
			}
             */
           pop_up_Pre_Approval_History.click_close_button();
            logger.info("Click popup closed button");
            /* */
			}
            
            softassert.assertAll();
            
         
         //   softassert.assertEquals(preApproval_Page.check_category_Optiondropdown(),"In-Patient" );
       //     logger.info("Check category by defoult option");
            preApproval_Page.check_category_dropdown();
              logger.info("Check category other dropdown option");
            softassert.assertAll();
			Thread.sleep(1000l);
//==================================================================================================	
			pa.selectMedicalCardType(paread.getPaManual(currentRow, "Medical Card Type"));
			logger.info("Medical Card Type Selected="+paread.getPaManual(currentRow, "Medical Card Type"));
//=========================================================			
			
			
			
			loadTimer.reset();
			loadTimer.start();
			Thread.sleep(1000l);
//==============================================================			
			pa.selectMedicalCardType(paread.getPaManual(currentRow, "Medical Card Type"));
			logger.info("Medical Card Type Selected="+paread.getPaManual(currentRow, "Medical Card Type"));
//====================================================================			
			pa.getDocName(paread.getPaManual(currentRow, "Attending Doctor Name"));
		//	pa.getDocName("Dr. Apollo_Test_38");
			logger.info("Doctor Name Entered");
			
			Thread.sleep(2000l);
			pa.selectDocName();
			loadTimer.stop();
			logger.info("Doctor Name Selected - Time Taken: "+ TimeUnit.MILLISECONDS.toSeconds(loadTimer.getTime()) +" seconds");
			
			//===========================================
			//Thread.sleep(10000l); //For loader hard coded
//			pa.waitLoader();
			//===========================================
			
			pa.scrolltopad();
			Thread.sleep(6000);
			logger.info("Scroll To Pre Approval Details");
			String networkpanel=preApproval_Page.check_network_panel();
			logger.info("network panel reflected="+networkpanel);
			logger.info("network panel ="+paread.getPaManual(currentRow, "Network Panel"));
		
			//Assertion for Network Panel
			/*	if(networkpanel.equalsIgnoreCase(paread.getPaManual(currentRow, "Network Panel"))) {

				Assert.assertTrue(true);
				logger.info("Network name reflected as expected="+networkpanel);
			}
			else{
				logger.info("Network name not reflected2");
				Assert.assertEquals(networkpanel, "Test260 - Dr. Apollo_Test_38 - Test Test Test, Wan Chai");
			}*/
			preApproval_Page.enter_other_doctore();
			logger.info("Enter other doctore name");
			
			pa.getSymptomDate(paread.getPaManual(currentRow, "Symptom / Onset Date"));
			logger.info("Symptom / Onset Date Entered");
			
			pa.getConsultationDate(paread.getPaManual(currentRow, "First Consultation Date"));
			logger.info("First Consultation Date Entered");
			
			pa.getAdmissionDate(paread.getPaManual(currentRow, "Admission Date"));
			logger.info("Admission Date Entered");
			
			//pa.waitLoader();
			//Thread.sleep(15000l); // For a time being extending time to load properly
			pa.waitLoader();
			
			pa.getDischargeDate(paread.getPaManual(currentRow, "Discharge Date"));
			logger.info("Discharge Date Entered");
			
			pa.getTreatmentDate();
			logger.info("Treatment Date Clicked, Auto Calculated & Entered");
			
			pa.getSymptom(paread.getPaManual(currentRow, "Symptom / Complaint"));
			logger.info("Symptom / Complaint Entered");
			
			preApproval_Page.check_wardtype_option();
			logger.info("Check ward Type dropdown number of option");
				pa.getContactNumber(paread.getPaManual(currentRow, "Contact No. (Insured)"));
			logger.info("Contact No. (Insured) Entered");
			
			pa.getBillcurrency(paread.getPaManual(currentRow, "Bill Currency"));
			logger.info("Bill Currency Selected");
			preApproval_Page.click_check_box_invaluntary_wardType(driver);
			logger.info("Click Invaluntary watd type checkbox");
		   	preApproval_Page.check_check_box_invaluntary_wardType();
		   logger.info("check check box invaluntary wardType selecetd");
			//======================================
			Thread.sleep(4000l);
			
			
			//======================================
			
			pa.goToDiagnosisView();
			logger.info("Go To Diagnosis View");
			
			//======================================
			Thread.sleep(4000l);
			
			pa.scrolltopad();
			logger.info("Scroll To Pre Approval Details");
			//======================================
		//	logger.info("Click new checkBox_Unknown_Pre_Existing starting");
			preApproval_Page.click_checkBox_Unknown_Pre_Existing(driver);
			logger.info("Click new checkBox_Unknown_Pre_Existing ");
			Thread.sleep(3000);
			preApproval_Page.click_checkBox_checkBox_KnPreExisting(driver);
			logger.info("Click new checkBox_KnPreExisting ");
			Thread.sleep(3000);
			preApproval_Page.click_checkBox_IsChronicRecurrent(driver);
			logger.info("Click new IsChronicRecurrent ");
			pa.getIcdCode(paread.getPaManual(currentRow, "ICD Code / Description"));
			logger.info("ICD Code / Description Entered");
			
			Thread.sleep(2000l);
			pa.selectIcdCode(row);
			logger.info("ICD Code / Description Selected");
			
			//===========================================
			//Thread.sleep(10000l); // for loader
			pa.waitLoader();
			//===========================================
			
			pa.goToDiagnosisView();
			logger.info("Scroll the ICD add ");
			pa.getAddIcdCode();
			logger.info("ADD(ICD) Button Clicked");
			
			for(int i=0;i<2;i++) {
			pa.getIcdCode("A01.0");
			logger.info("ICD Code / Description Entered ==A01.0");
			Thread.sleep(2000l);
			if(i==0) {
			pa.selectIcdCode_A01();
			
			//pa.click_selectIcdCode_A01_ID();
			logger.info("Select  ICD code");}
			else {
				pa.click_selectIcdCode_A01_ID();
				logger.info("Select  ICD2 code");
			}
			
			pa.getAddIcdCode();
			logger.info("ADD  Button Clicked for 2nd ICD code");
			if(i==1) {
				logger.info("Alert message="+preApproval_Page.check_ICD_alert_Message());
				Assert.assertEquals(true, true);
				captureScreenfullPage(driver,row+"_Success_Alert_for_Duplicate_ICD");

			}
			
			}
			
			preApproval_Page.click_ICD_edit();
			logger.info("Click ICD code");
			preApproval_Page.select_status_dropdown("Reject");
			logger.info("Select  edit drop down");
			preApproval_Page.click_update_ICD_button();
			logger.info("Check Update Button");
			preApproval_Page.check_tablestatus();
			logger.info("check Table status=");
				Thread.sleep(3000l);
		     preApproval_Page.click_sixth_month_medical(driver);
		     logger.info("Check 6 months Medical Conditions");
		     preApproval_Page.click_twel_month_medical(driver);
		     logger.info("Check 12 months Medical Conditions");
		     preApproval_Page.click_other_conditions(driver);
		     logger.info("Check Other conditions");
			pa.goToDoctorFee();
			logger.info("Go To Doctor Fee");
			
			pa.scrolltopad();
			logger.info("Scroll To Pre Approval Details");
			
			pa.getDfBenefitItem(paread.getPaManual(currentRow, "DF Benefit Item"));
			logger.info("Doctor Fee Benefit Item Entered");
			
			Thread.sleep(2000l);
			
			
			
			pa.selectdfeeBenefitItem(row);
			logger.info("DF Benefit Item Selected");
			
			//===========================================
			//Thread.sleep(10000l); // For hard code sleep wait
//	    	pa.waitLoader();
			//===========================================			
			preApproval_Page.check_doctore_fee_wardType_dropdown();
			logger.info("Check doctore fee wardType_dropdown");
			preApproval_Page.check_doctore_fee_benefit_pack();
			logger.info("Check doctore fee Benefit pack");
						pa.getdfRequestedAmount(paread.getPaManual(currentRow, "DF Requested Amount"));
			logger.info("Doctor Fee Requested Amount Entered");
			
			Thread.sleep(1000l);
				pa.getdfApprovedAmount(paread.getPaManual(currentRow, "DF Approved Amount"));
			logger.info("Doctor Fee Approved Amount Entered");
			
			if(paread.getPaManual(currentRow, "FW_Reason").equalsIgnoreCase("Yes")) {
			preApproval_Page.click_doctore_free_FWA_reason_search(driver);
			logger.info("Click FWA reason  new search ICON ");
			pop_up_FWA_Reason.enter_data_searchfield("R001");
			logger.info("Enter Data in search Reason  code");
			pop_up_FWA_Reason.click_checkbox();
			logger.info("Click check box");
			pop_up_FWA_Reason.clicksave_button(driver);
			logger.info("Click save button");
			}
			preApproval_Page.check_doctore_fee_status_dropdown();
			logger.info("Check status dropdown");
			//pa.clickAnesthesiologistfee();
			pa.clickAnesthesiologistfee2(driver);
			logger.info("Anesthesiologist's fee Clikced");
			logger.info("Check new FWA amount="+preApproval_Page.check_FWA_amount());
			softassert.assertEquals(preApproval_Page.check_FWA_amount(), paread.getPaManual(currentRow, "DF FWA Amount"));
			logger.info("Check  FWA amount");
			softassert.assertAll();
			preApproval_Page.click_doctore_free_fifty_percent_checkbox(driver);
			logger.info("Click 50% check box ");		
			Thread.sleep(3000l);
			
			pa.getAddDocFee();
			logger.info("Doctor Fee Add Button Clicked");
			Thread.sleep(2000l);
			preApproval_Page.check_doctore_fee_Table_record();
			logger.info("Check Doctor Fee table show 2 record");
			//Hospital Charges =========================
			pa.goToHospitalCharges();
			logger.info("Go To Hospital Charges");
			
			pa.scrolltopad();
			logger.info("Scroll To Pre Approval Details");
			preApproval_Page.check_HC_wardType_dropdown();
			logger.info("Check HC Ward Type dropdown");
			pa.getHCBenefitItem(paread.getPaManual(currentRow, "HC Benefit Item"));
			logger.info("HC Benefit ITem Entered");
			
			Thread.sleep(11000l);
			
			
			
			pa.selecteHCBenefitItem(row);
			logger.info("HC Benefit Item Selected");
			
		Thread.sleep(1000l);
			pa.getHCRequestedAmount(paread.getPaManual(currentRow, "HC Requested Amount"));
			logger.info("HC Requested Amount Entered");
			
			Thread.sleep(1000l);
			pa.getHCApprovedAmount(paread.getPaManual(currentRow, "HC Approved Amount"));
			logger.info("HC Approved Amount Entered");
			
			Thread.sleep(2000l);
			preApproval_Page.check_HC_status_dropdownn();
			logger.info("Check HC new Status dropdown");
			preApproval_Page.click_HC_FWA_reason_search(driver);
			logger.info("Click HC FWA reason  search ICON ");
			//pop_up_FWA_Reason.enter_data_searchfield("R001");
			pop_up_FWA_Reason.enter_new_data_searchfield("R001");
			Thread.sleep(4000);
			logger.info("Enter   Data in search Reasoncode field");
			pop_up_FWA_Reason.click_checkbox2(driver);
			logger.info("Click  new check box");
			pop_up_FWA_Reason.clicksave_button2(driver);
			logger.info("Click save button");
			logger.info("Check hospital  FWA amount="+preApproval_Page.check_HC_FWA_amount());
			softassert.assertEquals(preApproval_Page.check_HC_FWA_amount(), paread.getPaManual(currentRow, "FWA Amount"));
			logger.info("Check  hospital fwa amount");
			softassert.assertAll();
			pa.getAddHospitalCharges();
			logger.info("Hospital Charges Add Button Clicked");
			preApproval_Page.check_total_approve_amount_field();
			logger.info("check total_approve_amount_field is visible");
			preApproval_Page.check_total_approve_amount_aft_Adjustment();
			logger.info("check total_approve_amount_after Adjustment Field is visible");
			preApproval_Page.check_total_Total_Requested_Amount();
			logger.info("check total_Total_Requested_Amount Field is visible");
			preApproval_Page.check_total_Total_FWA_Amount();
			logger.info("check total_FWA_Amount Field is visible");
			preApproval_Page.check_Deductible_Balance();
			logger.info("check Deductible Field is visible");
			preApproval_Page.check_total_approve_amount_field();
			logger.info("check Total approve Field is visible");
			preApproval_Page.check_total_Rejected_item();
			logger.info("check Total Rejected Field is visible");
			preApproval_Page.check_other_information_section();
			logger.info("Check other information_section is visible");
			preApproval_Page.enter_data_other_information_textfield();
			logger.info("Enter data in other information_section is visible");
			Thread.sleep(2000);
			 String actual_cardholdername=	preApproval_Page.check_cardholder();
				logger.info("Check card holder name="+preApproval_Page.check_cardholder());
				if(actual_cardholdername.contains("IG LOF IQFU")) {
					logger.info("Card holder name is same as expected");
					softassert.assertEquals(actual_cardholdername,"IG LOF IQFU");
					softassert.assertAll();
				}else {
					logger.info("Card holder namenot match");
				}
				
				//================================below new code for card detail===================
				pa.goTOCardDetails();
				logger.info("Go TO Card Details");
				
			/*	pa.getCardNumber(paread.getPaManual(currentRow, "Card no."));
				logger.info("Card Number Entered");
	
				pa.getCardMonth();
				logger.info("Card Month Clicked");
				
				pa.getCardMonth(paread.getPaManual(currentRow, "Expiry Date"));
				logger.info("Expire Date/Month Selected");
				preApproval_Page.check_card_status();
				logger.info("Check card status");*/
				//=========================Old code is committed below===========
			if(paread.getPaManual(currentRow, "Card Details").equalsIgnoreCase("Yes")){
			
				//CARD DETAILS
				pa.goTOCardDetails();
				logger.info("Go TO Card Details");
				
				pa.getCardNumber(paread.getPaManual(currentRow, "Card no."));
				logger.info("Card Number Entered");
	
				pa.getCardMonth();
				logger.info("Card Month Clicked");
				
				pa.getCardMonth(paread.getPaManual(currentRow, "Expiry Date"));
				logger.info("Expire Date/Month Selected");
			  
			}
			
			pa.inputRemarks(paread.getPaManual(currentRow, "Remarks"));
			logger.info("Remarks Entered");
			preApproval_Page.enter_data_network_letter_remarkfield();
			logger.info("enter Remarks in network letter field");
			preApproval_Page.enter_data_customer_remark();
			logger.info("enter Remarks in customer remark field");
			Thread.sleep(2000);
			captureScreenfullPage(driver,row+"Pre_Aproval_form");
			logger.info(" Pre_Aproval_form screenshot taken");
			
			pa.saveButton();
			logger.info("Save Button Clicked");
			
			paNdetails = pa.getpaNotification();
			logger.info("Alert Message: "+ paNdetails);
			/*	*/
			String preANumber = regExtract(paNdetails);
			
			// TODO PA INDEXING saved claim search ====
			
			if(paread.getPaManual(currentRow, "indexPaSearch").equalsIgnoreCase("Yes")){
				
				pa.clickYestoindexing();
				logger.info("Click Yes to back index page");
				
				pa.waitLoader();
				
				logger.info("<=== Start to search save pa in indexing page ====>");
				
				pa.enterPAtoSearch(preANumber);
				logger.info("Enter PA number to search in indexing page="+preANumber);
				
				pa.clickSearchbtn();
				logger.info("Clicked on search Button");
				
				//==== VERIFY PA SEARCH on Indexing page==============================================
				
				boolean chk = pa.verifypa(preANumber);
				
				if(chk){
				
					logger.info("Search pa verified on indexing page.");
					Thread.sleep(3000l);
					captureScreen(driver,row+"_Success_indexPASearch");
					
				}else{
					
					Assert.assertTrue(false,"PA Number is not found on Indexing Page");
					captureScreen(driver,row+"_indexPASearch");
				}
					
				//======================================================================	
				
				Thread.sleep(4000);
				if(paread.getPaManual(currentRow, "Reassign").equalsIgnoreCase("Yes")){
				     preApproval_Indexing_Page.click_indexing_Reassign_link2();
			        logger.info("Click Reassign link by class");
			        pop_up_Reassign_Claim.click_select(driver);
			        logger.info("Click first select link ");
			        Thread.sleep(4000);
			        pa.enterPAtoSearch(preANumber);
					logger.info("Enter PA number to search in indexing page="+preANumber);
					 Thread.sleep(4000);
					//pa.clickSearchbtn();
					pa.click_Indexing_Searchbtn(driver);
					logger.info("Clicked on search Button");
					 Thread.sleep(4000);
				  
					 String first_pick=preApproval_Indexing_Page.get_indexing_table_casepickby();
					 logger.info("First case pick by="+first_pick);
					  preApproval_Indexing_Page.click_indexing_Reassign_link3();
				       logger.info("Click Reassign link ");
				       Thread.sleep(2000);
				       pop_up_Reassign_Claim.enter_data_searchfield("Prince");
			        logger.info("enter data in search field");
			        pop_up_Reassign_Claim.click_search_icon();
			        logger.info("click search Icon");
			        Thread.sleep(8000);
			        pop_up_Reassign_Claim.click_newselectlink(driver);
			        logger.info("Click new select");
			        Thread.sleep(4000);
			        pa.enterPAtoSearch(preANumber);
					logger.info("Enter PA number to search in indexing page="+preANumber);
					 Thread.sleep(4000);
					pa.clickSearchbtn();
					logger.info("Clicked on search Button");
					Thread.sleep(4000);
					 String second_pick=preApproval_Indexing_Page.get_indexing_table_new_casepickby();
					 logger.info("Second case pick by="+second_pick);
					softassert.assertNotEquals(first_pick, second_pick);
					softassert.assertAll();
					 /**/}
				pa.clickpaProceed();
				logger.info("Click on Proceed");
				
				logger.info("===> Process complete to search save pa in indexing page <====");
				
				
			}
			
			// ========================================
			
			//=================
			//Thread.sleep(20000l); // For hard code sleep wait
			pa.waitLoader();
			//=================
			
			if (paNdetails.equalsIgnoreCase("Case has been updated")) {
				
				toppaNdetails = pa.moveToTop();
				logger.info("Success: "+ toppaNdetails);

			} else {
				
				if(paread.getPaManual(currentRow, "indexPaSearch").equalsIgnoreCase("Yes")){
					//pa.getNoTOStay();
					logger.info("No Clicked...Bypass");
				}else{
					pa.getNoTOStay();
					logger.info("No Clicked...");
				}
			}
			
			//===============
			//Thread.sleep(25000l);
			//===============

			
			//===============
			//Thread.sleep(30000l); // For hard code sleep wait
			pa.waitLoader();
			//===============
			pa.clickShowhide2(); // Behavior changed
			logger.info("Show/Hide Document Button Clicked");			
			
			//========== CODE FOR ASSESSMENT ENQUIRY =======================
			preApproval_Page.check_download_option();
			logger.info("Check download option");
			preApproval_Page.check_open_popUp();
			logger.info("Check open popup option");
			if(paread.getPaManual(currentRow, "Assessment Enquiry").equals("Yes")){
				
				pa.clickAssessmentEnquiry();
				logger.info("Assessment Enquiry clicked");
				//Thread.sleep(10000l); // For hard code sleep wait
				pa.waitLoader();
				
				String getPANumber = regExtract(paNdetails);
				
				//pa.clickViewAssesment();
				//logger.info("View Clicked");
				
				pa.clickAddAssessment();
				logger.info("Add Assessment Clicked");
				
				//Thread.sleep(7000l); // For hard code sleep wait
				pa.waitLoader();
				
				pa.selectPanumberforassessment(getPANumber);
				logger.info("PA Number Selected");
				
				Thread.sleep(1000l);
				pa.enterTextArea(paread.getPaManual(currentRow, "Assessment Text"));
				logger.info("Text Area Entered in Assessment Enquiry Page");

				Thread.sleep(1000l);
				pa.clickAddforAssessmentEnq();
				logger.info("Add clicked for Assessment Enquiry");
				
		        //Thread.sleep(5000l); // For hard code sleep wait
				pa.waitLoader();
		        
		        pa.enterPanumberAssessment(getPANumber);
		        logger.info("PA Number Entered for Search Assessment Enq");
		       
		        Thread.sleep(1000l);
		        pa.clickGoAssessmentEnq();
		        logger.info("Go Clicked for Assessment Search");
		        
		        //Thread.sleep(10000l); //loader
		        pa.waitLoader();
		        
		        captureScreen(driver,row+"_Success_paassessmentEnq");
		        logger.info("Screenshot Caputered for Assessment Enquiry");
		        
		        Thread.sleep(1000l);
		        pa.clickCloseAssessmentEnq();
		        logger.info("Assesment Eqnuiry Pop Up Closed");
				
				
			}
			
			//==============================================================
			
			Thread.sleep(8000l);
			pa.waitLoader(); //if  any
			
			pa.clickautoAudjudicate();
			logger.info("Auto-Audjudicate Clicked");
			
			alertsAutoaudjudicateClick = pa.getpaNotification();
			logger.info("Alert Message: "+ alertsAutoaudjudicateClick);			
			
			//================
			//Thread.sleep(25000l); // For hard code sleep wait
			pa.waitLoader();
			//=================
			
			pa.gotoPreApprovalResult();
			logger.info("Go To Pre Approval Result");
			captureScreen(driver,row+"_Success_paTestManual");
			logger.info("Screenshot captured of Pre Approval Result");
			
			//========== Move To Pre Approval Details FOR LOG AMOUNT CASE ===================================
			
			if (paread.getPaManual(currentRow, "Log Amount").equals("Yes")) {

				Thread.sleep(4000l);
				pa.scrolltopad();
				logger.info("Scroll To Pre Approval Details");
				
				Thread.sleep(2000l);
				pa.chekLogAmount();
				logger.info("Logged Amount Checked");
				
				Thread.sleep(2000l);
				pa.enterLogAmount(paread.getPaAdjustment(currentRow, "Log Amount if empty"));
				logger.info("Log Amount Entered");
				
			}			
			
			//===================
			//Thread.sleep(10000l); might be loader if any
			pa.waitLoader();
			//===================
			
			//============= FOR ACTIVITY LOG =======================================
			
			if(paread.getPaManual(currentRow, "Activity Log").equalsIgnoreCase("Yes")){
				
				pa.clickActivityLog();
				logger.info("Activity Log Clicked..");
				
				Thread.sleep(4000l);
				captureScreen(driver,row+"_Success_paActivityLog");
				logger.info("Screenshot caputred for Activity Log");
				
				pa.clickCloseActivityLog();
				logger.info("Close Activity Log Pop up");
			}
			
			//============= FOR APPROVE CASE =======================================

			Thread.sleep(2000l);
			if(paread.getPaManual(currentRow, "Approve").equalsIgnoreCase("Yes")){
				
				pa.clickApprove();
				logger.info("Approve Clicked...");
				
				if(paread.getPaManual(currentRow, "Log Amount").equalsIgnoreCase("No")) //change it to NO if yes
				{
					System.out.println("if value - " +paread.getPaManual(currentRow, "Log Amount"));
					
					actions = "Approve";
					
					pa.clickReasonForApprove();
					logger.info("Reason For Approved List Clicked");
					
					pa.selectReasonForApprove(row);
					logger.info("Option Selected for Reason For Approve");
					
					pa.clickSubmitReasonForApprove();
					logger.info("Submit Clicked of Reason For Approve");
					
					alertsApprovedClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsApprovedClick);
					
					//===================
					//Thread.sleep(15000l); // For hard code sleep wait
					pa.waitLoader();
					//===================
					
					pa.clickBackToApprove();
					logger.info("Back TO Approve Clicked...");					

				}else{
					
					System.out.println("Else value - " +paread.getPaManual(currentRow, "Log Amount"));
					
					actions = "Approve";
					
					alertsApprovedClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsApprovedClick);
					
					//===================
					//Thread.sleep(15000l); // For hard code sleep wait
					pa.waitLoader();
					//===================
					
					pa.clickBackToApprove();
					logger.info("Back TO Approve Clicked...");
				
				}

				//============= FOR PENDING CASE =======================================
			}else if(paread.getPaManual(currentRow, "Pending").equalsIgnoreCase("Yes")){
				
					actions = "Pending";
					
					pa.clickPending();
					logger.info("Pending Clicked...");
					
					pa.clickReasonForPending();
					logger.info("Reason For Pending List Clicked");
					
					pa.selectReasonForPending(row);
					logger.info("Option Selected for Reason For Pending");
					pop_up_Reason_For_Pending.select_P20_OTHER(driver);
					logger.info("Reason For Pending List Clicked=P20_Other");
					Thread.sleep(4000);
					pa.clickPending();
					logger.info("Click Pending");
					pop_up_Reason_For_Pending.enter_P20_OTHER_Reason();
					logger.info("Enter Other Reason");
					pa.clickSubmitReasonForPending();
					logger.info("Submit Clicked of Reason For Pending");
					
					alertsPendingClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsPendingClick);
	
					//Thread.sleep(15000l); // For hard code sleep wait
					pa.waitLoader(); // if any
					
					pa.clickBackToPending();
					logger.info("Back To Pending Clicked");
				
				//============= FOR REJECT CASE =======================================
			}else if(paread.getPaManual(currentRow, "Reject").equalsIgnoreCase("Yes")){
				
				actions = "Reject";
				
				pa.clickReject();
				logger.info("Reject Clicked...");
				
				pa.clickReasonForReject();
				logger.info("Reason For Reject List Clicked");
				
				//pa.selectReasonForReject(row);
				pop_up_Reject_Reason.select_dummycode1(actual_submission_date2);
				logger.info("Option Selected for Reason For Reject");
				
				pa.clickSubmitReasonForReject();
				logger.info("Submit Clicked of Reason For Reject");
				
				/*if(!pa.getpaNotification().isEmpty())
				{
					String alertsRejectClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsRejectClick);
				}*/
				
				//Thread.sleep(15000l); //// For hard code sleep wait
				pa.waitLoader(); //if any
				
				pa.clickBackToReject();
				logger.info("Back To Reject Clicked");
			}
			//============= Chopping ================================
	      if(paread.getPaManual(currentRow, "Chopping").equalsIgnoreCase("Yes")){
				
				
				actions = "Chopping";
				pa.clickPending();
				logger.info("Pending Clicked...");
				
				pa.clickReasonForPending();
				logger.info("Reason For Pending List Clicked");
				
				pa.selectReasonForPending(row);
				logger.info("Option Selected for Reason For Pending");
				pop_up_Reason_For_Pending.select_P20_OTHER(driver);
				logger.info("Reason For Pending List Clicked=P20_Other");
				Thread.sleep(4000);
				pa.clickPending();
				logger.info("Click Pending");
				pop_up_Reason_For_Pending.enter_P20_OTHER_Reason();
				logger.info("Enter Other Reason");
				pa.clickSubmitReasonForPending();
				logger.info("Submit Clicked of Reason For Pending");
				preApproval_Page.click_chopping(driver);
				logger.info("Click Chopping button");
				Thread.sleep(8000);
		/*	List <String>l=new ArrayList<String>(	driver.getWindowHandles());
			//String l.get(3);
			logger.info("Switch to alert start");
			driver.switchTo().alert().accept();
			logger.info("Switch to alert");
			driver.switchTo().window(l.get((l.size()-1)));
		//	driver.findElement(By.xpath(""))
			logger.info("Current URL=="+driver.getCurrentUrl());
				if(driver.getCurrentUrl().contains("Chopping")) {
					Assert.assertEquals(true, true);
					captureScreenfullPage(driver,row+"_Success_Capping_Link");
					logger.info("Screenshots captured for Capping");	
				}*/
			}
	      if(paread.getPaManual(currentRow, "Cancel").equalsIgnoreCase("Yes")){
				actions = "Cancel";
				preApproval_Page.click_cancelbutton(driver);
				logger.info(" Click cancel button");
				preApproval_Page.click_back_to_cancelbutton(driver);
				logger.info(" Click back to cancel button");
				
	      }
	      if(paread.getPaManual(currentRow, "Withdraw").equalsIgnoreCase("Yes")){
				actions = "Withdraw";
				preApproval_Page.click_WithDrawbtnbutton(driver);
				logger.info(" Click withdraw button");
				preApproval_Page.click_back_to_withdrawbutton(driver);
				logger.info(" Click back to withdraw button");
				
	      }
			logger.info("==> Process Complete of Save(Generate PA No.), auto-audjudicate, and "+actions+" Clicked <==");
			
			
		} catch (Exception e) {

			logger.info("paTestManual Fail");
			captureScreen(driver, row+"_paTestManual");// first parameter is driver, // second is test name.		
																			
			e.printStackTrace();

			if (child.equals(child)) {
				//============================================================================================================
				//driver.close();
			}
		//	driver.switchTo().window(parent);
			Assert.assertTrue(false);

		}
		
	
		
	}
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "paTestManual" })
	public void palistSearch(String row) throws IOException
	{
		try {
			
			logger.info("==== "+actions+" PA Search Started ====");
			PAListPage palistp = new PAListPage(driver);
			
			paNumber = regExtract(paNdetails);

			System.out.println(paNumber);
			
			//Thread.sleep(10000l);  // for loader
			palistp.waitLoader();
			
			palistp.txtPaNum(paNumber);
			logger.info("PA Number Entered="+paNumber);
			
			Thread.sleep(1000l); 
			palistp.waitLoader();
			palistp.clickGO();
			logger.info("Go Clicked for PA Search");
			
			//Thread.sleep(5000l); // for loader
			palistp.waitLoader();
			
			if(actions.contains("Pending")) {
				captureScreenfullPage(driver,row+"_Success_palistSearch_PA_Pending");
				logger.info("Screenshots captured for search  Pending PANumber ");
			}else if(actions.contains("Approved")) {
				captureScreenfullPage(driver,row+"_Success_palistSearch_PA_Approved");
				logger.info("Screenshots captured for search Approved PANumber");
			}else if(actions.contains("Reject")) {
				captureScreenfullPage(driver,row+"_Success_palistSearch_PA_Reject");
				logger.info("Screenshots captured for search Reject PANumber");
			}else if(actions.contains("Cancel")) {
				captureScreenfullPage(driver,row+"_Success_palistSearch_PA_Cancel");
				logger.info("Screenshots captured for search Cancel PANumber");
			}else if(actions.contains("Withdraw")) {
				captureScreenfullPage(driver,row+"_Success_palistSearch_PA_Withdraw");
				logger.info("Screenshots captured for search Withdraw PANumber");
			}
			captureScreen(driver,row+"_Success_palistSearch");
			logger.info("Screenshots captured for search PANumber");
			logger.info("====> "+actions+" PA Search Passed <====");
			
		} catch (InterruptedException e) {
			
			
			logger.info("====> "+actions+" PA Search Failed <====");
			captureScreen(driver, row+"_palistSearch");
			
			e.printStackTrace();
			
			if (child.equals(child)) {
				driver.close();
			}
			
			driver.switchTo().window(parent);
			Assert.assertTrue(false);
			
			
		}
		
	}
	
//=============================================================================================
	
	@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "palistSearch" })
	public void paGenerateLetter(String row) throws IOException
	{
		int currentRow = Integer.parseInt(row);	
		try {
			
			if(actions.equals("Approve"))
			{
			
				logger.info("==== "+actions+" PA Letter Generation Started ====");
				//PAPage pa = new PAPage(driver);
				PAListPage palistp = new PAListPage(driver);
				
				//========================================
				Thread.sleep(4000l);
				palistp.clickPreApprovalView();
				logger.info("Pre Approval View Clicked");
				
				// ====> REDIRECTING TO PRE APPROVAL VIEW PAGE <====
				ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab1.get(2));
				
				//Thread.sleep(10000l);// for loader			
				palistp.waitLoader();
				
				// === FOR SCREENSHOT OF PRE-APPROVAL VIEW PAGE
				Thread.sleep(8000l);
				//captureScreen(driver,row+"_Success_paViewpage");
				captureScreenfullPage(driver,row+"_Success_paViewpage");
				logger.info("Full Screenshots captured of pre-approval view page");
				
				if(paread.getPaManual(currentRow, "TC_ID").contains("LIFE")){
					
					palistp.clickGenerateLetterLife();
					logger.info("Generate Letter Button Clicked");
					
				}else{
					
					palistp.clickGenerateLetterGI();
					logger.info("Generate Letter Button Clicked");
					
				}
				
				
				//SWITCH TO GENERATE LETTER TAB
				ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab2.get(3));
				
				//GO TO GENERATE LETTER BUTTON
				Thread.sleep(10000l);
				palistp.gotoGenerateLetterButton();
				logger.info("Scroll to generate letter Button");
				
				palistp.clickgenerateLetterPage();
				logger.info("Generate Letter Page Clicked");
				
				//=========================================
				//Thread.sleep(13000l);
				palistp.waitLoader();
				
				captureScreen(driver,row+"_Success_paGenerateLetter");

				// ===== VERIFY PDF AVAILABLILITY =====================
				
				boolean chkPDF = palistp.validatepdf();
				
				if(chkPDF == true){
					
					logger.info("PDF Displayed.");
					
				}
				
				
				else
				{
					logger.info("PDF Not Displayed.");
					Assert.assertTrue(false, "PDF Not Displyed After Generate click");
				}		
				
				//driver.close();
				// ==================================================
				
				//captureScreen(driver,row+"_Success_paGenerateLetter");
				logger.info("Screenshots captured for search PANumber");
				
				logger.info("====> "+actions+" PA Letter Generation Passed <====");
			
			}else {
				captureScreenfullPage(driver,row+"_Success_Pending flow");
				logger.info("Screenshot caputred for Pending flow");

				logger.info("====> PA was not approved, that's why pa letter not generated <====");
			}
			
			//////Close the browser
		    driver.quit();
		logger.info("letter closed");
		
		}
		
		catch (InterruptedException e) {
			
			logger.info("====> "+actions+" PA Letter Generation Failed <====");
			captureScreen(driver, row+"_paGenerateLetter");			
			
			e.printStackTrace();
		
			if (child.equals(child)) {
				driver.close();
			}
			
			driver.switchTo().window(parent);
			Assert.assertTrue(false);
		}
		
		
		
		}
	
	
	
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "paTestManual" })
	public void indexPASearch(String row) throws IOException
	{	
		// STEPS ALREADY COVERD IN paTestManual TEST
		logger.info(" ====> Screenshot already captured for PA search on index Page <====");
	}		
	
	@Parameters(value="tc_row")
	@Test(priority=5, dependsOnMethods = { "paTestManual" })
	public void paassessmentEnq(String row) throws IOException
	{	
		// STEPS ALREADY COVERD IN paTestManual TEST
		logger.info(" ====> Screenshot already captured for Assessment Enquiry <====");
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=6, dependsOnMethods = { "paTestManual" })
	public void paActivityLog(String row) throws IOException
	{	
		// STEPS ALREADY COVERED IN paTestManual TEST
		logger.info(" ====> Screenshot already captured for Activity Log <====");
	}	
	
	@Parameters(value="tc_row")
	@Test(priority=7, dependsOnMethods = { "paGenerateLetter" })
	public void paViewpage(String row) throws IOException
	{	
		// STEPS ALREADY COVERD IN paGenerateLetter TEST
		logger.info(" ====> Screenshot already captured for Pre-Approval View Page <====");
		
		
		

		
	}
	@Parameters(value="tc_row")
	@Test(priority=8, dependsOnMethods = { "paTestManual" })
	public void cancel_TC(String row) throws Exception
	{	
		preApproval_Page.click_cancelbutton(driver);
		logger.info(" Click cancel button");
		preApproval_Page.click_back_to_cancelbutton(driver);
		logger.info(" Click back to cancel button");
		captureScreenfullPage(driver,row+"_Success_cancel_TC");
        logger.info("full Screenshot Caputered for cancel_TC");
		
	}
	@Parameters(value="tc_row")
	@Test(priority=8, dependsOnMethods = { "paTestManual" })
	public void PA_List_Pending(String row) throws Exception
	{	
		preApproval_Page.click_cancelbutton(driver);
		logger.info(" Click cancel button");
		preApproval_Page.click_back_to_cancelbutton(driver);
		logger.info(" Click back to cancel button");
		 captureScreenfullPage(driver,row+"_Success_PA_List_Pending");
	        logger.info("full Screenshot Caputered for PA_List_Pending");
	}
	
	
	
}


   
