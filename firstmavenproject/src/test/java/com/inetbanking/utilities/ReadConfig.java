package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	
	public ReadConfig() 
	{
		File src = new File("./Configurations/config.properties");
					
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getAppUrl()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath()
	{
		String cromepath=pro.getProperty("chromepath");
		return cromepath;
	}
	public String getIEPath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}