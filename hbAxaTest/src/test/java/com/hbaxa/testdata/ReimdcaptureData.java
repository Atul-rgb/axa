package com.hbaxa.testdata;

import org.testng.annotations.Parameters;

import com.hbaxa.utilities.ReadConfig;
import com.hbaxa.utilities.Xls_Reader;

public class ReimdcaptureData {
	
	//Xls_Reader ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata.xlsx");
	
	ReadConfig readconfig = new ReadConfig();
	Xls_Reader ldread;
	
	public ReimdcaptureData() {

		if (readconfig.gethostname().equalsIgnoreCase("SIT_STAGE4(GI)")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_SITS4.xlsx");

		} else if (readconfig.gethostname().equalsIgnoreCase("UAT_STAGE4")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_UATS4.xlsx");
		}

	}
	
	public String getReimDataCapture(int row, String col)
	{
		String colValue = ldread.getCellData("REIMDATACAPTURE", col, row);
		return colValue;
	}

	public String getReimDataMultiICD(int row, String col)
	{
		String colValue = ldread.getCellData("MULTI_ICD", col, row);
		return colValue;
	}
	
	public String getReimDataMultiSurgeryCode(int row, String col)
	{
		String colValue = ldread.getCellData("MULTI_SURGERY_CODE", col, row);
		return colValue;
	}

	public String getReimDataMultiBill(int row, String col)
	{
		String colValue = ldread.getCellData("REIM_MULTI_BILLING", col, row);
		return colValue;
	}
	
	public String getReimDataMultiBillBenefit(int row, String col)
	{
		String colValue = ldread.getCellData("REIM_MULTI_BILL_BENF", col, row);
		return colValue;
	}
	
	public String getReimDataOtherInsurance(int row, String col) {
		
		String colValue = ldread.getCellData("REIM_OTHER_INSURANCE", col, row);
		return colValue;
	}	
	
	public String getReimLink(int row, String col) {
		
		String colValue = ldread.getCellData("LinkRimbursment", col, row);
		return colValue;
	}
	
	public void setReimDataCapture(String sheet, String colname, int row, String value){
		
		ldread.setCellData(sheet, colname, row, value);
	}





	
}
