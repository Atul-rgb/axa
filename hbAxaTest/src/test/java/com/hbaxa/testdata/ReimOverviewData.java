package com.hbaxa.testdata;

import org.testng.annotations.Parameters;

import com.hbaxa.utilities.ReadConfig;
import com.hbaxa.utilities.Xls_Reader;

public class ReimOverviewData {
	
	//Xls_Reader ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata.xlsx");
	
	ReadConfig readconfig = new ReadConfig();
	Xls_Reader ldread;
	
	public ReimOverviewData() {

		if (readconfig.gethostname().equalsIgnoreCase("SIT_STAGE4(GI)")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_SITS4.xlsx");

		} else if (readconfig.gethostname().equalsIgnoreCase("UAT_STAGE4")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_UATS4.xlsx");
		}

	}	
	
	public String getReimOverview(int row, String col)
	{
		String colValue = ldread.getCellData("REIMOVERVIEW", col, row);
		return colValue;
	}

	public String getReimDataCapture(int row, String col)
	{
		String colValue = ldread.getCellData("REIMDATACAPTURE", col, row);
		return colValue;
	}
	
	public String getReimReverse(int row, String col)
	{
		String colValue = ldread.getCellData("REIM_REVERSE", col, row);
		return colValue;
	}	
	
	public String getReimOverviewAPS(int row, String col)
	{
		String colValue = ldread.getCellData("REIMOVERAPSCAPTURE", col, row);
		return colValue;
	}
	
	public String getReimDataMultiBilliTEM(int row, String col)
	{
		String colValue = ldread.getCellData("REIM_MULTI_BILLING", col, row);
		return colValue;
	}	
	
	public String getReimDataMultiBillBenefit(int row, String col)
	{
		String colValue = ldread.getCellData("REIM_MULTI_BILL_BENF", col, row);
		return colValue;
	}	
	
	
	public void setReimOverview(String sheet, String colname, int row, String value){
		
		ldread.setCellData(sheet, colname, row, value);
	}

	public String getReimLink(int row, String col) {
		
		String colValue = ldread.getCellData("LinkRimbursment", col, row);
		return colValue;
	}

	
}
