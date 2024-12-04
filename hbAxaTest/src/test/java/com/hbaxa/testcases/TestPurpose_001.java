package com.hbaxa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.PAData;

public class TestPurpose_001 extends BaseClass {
	
	LoginData ldread = new LoginData();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void testinPurpose(String row) throws Exception
	{
		PAData paread = new PAData();
		int currentRow = Integer.parseInt(row);

		if(paread.getPaManual(currentRow, "Approve").equalsIgnoreCase("Yes")){
			
			
			if(paread.getPaManual(currentRow, "Log Amount").equalsIgnoreCase("No")) // it should be yes technically
			{
				
				System.out.println("if part No");
				
				
				TC_PATest_001 obj = new TC_PATest_001();
				
				obj.paTestManual("2");
				obj.quitBrowser();
				

			}
			else {
				
				System.out.println("else part");

			}

		}

		
	}
	


}
