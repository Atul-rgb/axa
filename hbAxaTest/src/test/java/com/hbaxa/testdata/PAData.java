package com.hbaxa.testdata;

import com.hbaxa.utilities.ReadConfig;
import com.hbaxa.utilities.Xls_Reader;

public class PAData {
	
	//Xls_Reader paRead = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata.xlsx");
	
	ReadConfig readconfig = new ReadConfig();
	Xls_Reader paRead;
	
	public PAData() {

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
	
	public String getPaManual(int row, String getsCollumnName)
	{
		String CollumnName = paRead.getCellData("GIPA", getsCollumnName, row);
		return CollumnName;
	}	
	
	public String getPaDoc(int row, String getsCollumnName)
	{
		String CollumnName = paRead.getCellData("PADOCID", getsCollumnName, row);
		return CollumnName;
	}
	
	public String getPaAdjustment(int row, String getsCollumnName)
	{
		String CollumnName = paRead.getCellData("PAADJUSTMENT", getsCollumnName, row);
		return CollumnName;
	}
	
	public String getpamergedata(int row, String getsCollumnName)
	{
		String CollumnName = paRead.getCellData("PAMERGE", getsCollumnName, row);
		return CollumnName;
	}
	
	
	
}
