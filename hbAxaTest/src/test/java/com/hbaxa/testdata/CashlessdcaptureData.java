package com.hbaxa.testdata;

import org.testng.annotations.Parameters;

import com.hbaxa.utilities.ReadConfig;
import com.hbaxa.utilities.Xls_Reader;

public class CashlessdcaptureData {
	
	//Xls_Reader ldread = new Xls_Reader(System.getProperty("user.dir") + "\\TCfile\\Testdata.xlsx");
	
	ReadConfig readconfig = new ReadConfig();
	Xls_Reader ldread;
	
	public CashlessdcaptureData() {

		if (readconfig.gethostname().equalsIgnoreCase("SIT_STAGE4(GI)")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_SITS4.xlsx");

		} else if (readconfig.gethostname().equalsIgnoreCase("UAT_STAGE4")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_UATS4.xlsx");
		}

	}	
	
	public String getCashlessDataCapture(int row, String col)
	{
		String colValue = ldread.getCellData("CASHLESSDATACAPTURE", col, row);
		return colValue;
	}
	
	public String getCashlessDataMultiICD(int row, String col)
	{
		String colValue = ldread.getCellData("MULTI_ICD_CD", col, row);
		return colValue;
	}
	
	public String getCashlessDataMultiSurgeryCode(int row, String col)
	{
		String colValue = ldread.getCellData("MULTI_SURGERY_CODE_CD", col, row);
		return colValue;
	}
	
	public String getClessDataMultiBill(int row, String col)
	{
		String colValue = ldread.getCellData("CASHLESS_MULTI_BILLING", col, row);
		return colValue;
	}	
	
	public String getCashlessDataMultiBillBenefit(int row, String col)
	{
		String colValue = ldread.getCellData("CASHLESS_MULTI_BILL_BENF", col, row);
		return colValue;
	}		
	
	public void setCashlessDataCapture(String sheet, String colname, int row, String value){
		
		ldread.setCellData(sheet, colname, row, value);
	}

	
}
