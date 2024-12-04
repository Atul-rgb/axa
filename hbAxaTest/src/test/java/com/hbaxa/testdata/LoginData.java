package com.hbaxa.testdata;

import org.testng.annotations.Parameters;

import com.hbaxa.utilities.ReadConfig;
import com.hbaxa.utilities.Xls_Reader;

public class LoginData {

	//Xls_Reader ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata.xlsx");
	
	ReadConfig readconfig = new ReadConfig();
	Xls_Reader ldread;
	
	public LoginData() {

		if (readconfig.gethostname().equalsIgnoreCase("SIT_STAGE4(GI)")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_SITS4.xlsx");

		} else if (readconfig.gethostname().equalsIgnoreCase("UAT_STAGE4")) {

			ldread = new Xls_Reader(System.getProperty("user.dir")+ "\\TCfile\\Testdata_UATS4.xlsx");
		}

	}

	public String getUsername(int row, String user)
	{
		String username = ldread.getCellData("Logindata", user, row);
		return username;
	}
	
	public String getPassword(int row, String pass)
	{
		String password = ldread.getCellData("Logindata", pass, row);
		return password;
	}
	
	
	
	
	
	
}
