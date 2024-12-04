package com.hbaxa.testdata;

import org.testng.annotations.Parameters;

import com.hbaxa.utilities.ReadConfig;
import com.hbaxa.utilities.Xls_Reader;

public class CashlessOverviewData {
	
	//Xls_Reader ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata.xlsx");
	
	ReadConfig readconfig = new ReadConfig();
	Xls_Reader ldread;
	
	public CashlessOverviewData() {

		if (readconfig.gethostname().equalsIgnoreCase("SIT_STAGE4(GI)")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_SITS4.xlsx");

		} else if (readconfig.gethostname().equalsIgnoreCase("UAT_STAGE4")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_UATS4.xlsx");
		}

	}	

	public String getCashlessOverview(int row, String col)
	{
		String colValue = ldread.getCellData("CASHLESSOVERVIEW", col, row);
		return colValue;
	}
	
	public String getCashlessDataCapture(int row, String col)
	{
		String colValue = ldread.getCellData("CASHLESSDATACAPTURE", col, row);
		return colValue;
	}	
	
	public String getCashlessReverse(int row, String col)
	{
		String colValue = ldread.getCellData("CASHLESS_REVERSE", col, row);
		return colValue;
	}
	
	public String getCashlessOverviewAPS(int row, String col)
	{
		String colValue = ldread.getCellData("CASHLESSOVERAPSCAPTURE", col, row);
		return colValue;
	}
	
	public void setCashlessOverview(String sheet, String colname, int row, String value){
		
		ldread.setCellData(sheet, colname, row, value);
	}

	
}
