package com.hrm.generic.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility {
	
	public String getDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./configApplicationData/hrm.properties");
		
		
		
		Properties pObj= new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
		
		
		
	}

}
