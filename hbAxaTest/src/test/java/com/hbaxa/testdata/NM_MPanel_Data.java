package com.hbaxa.testdata;

import org.testng.annotations.Parameters;

import com.hbaxa.utilities.ReadConfig;
import com.hbaxa.utilities.Xls_Reader;

public class NM_MPanel_Data {
	
	//Xls_Reader ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata.xlsx");
	
	ReadConfig readconfig = new ReadConfig();
	Xls_Reader ldread;
	
	public NM_MPanel_Data() {

		if (readconfig.gethostname().equalsIgnoreCase("SIT_STAGE4(GI)")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_NM_SITS4.xlsx");

		} else if (readconfig.gethostname().equalsIgnoreCase("UAT_STAGE4")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_NM_UATS4.xlsx");
		}

	}
	
	public String getNmMPanelData(int row, String col)
	{
		String colValue = ldread.getCellData("MAINTAIN_PANEL", col, row);
		return colValue;
	}

	public String getNmMPanelSearch(int row, String col) {
		
		String colValue = ldread.getCellData("MAINTAIN_PANEL_SEARCH", col, row);
		return colValue;
		
	}
	
}
