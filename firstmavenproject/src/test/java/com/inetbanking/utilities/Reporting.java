package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlreporter;// specify settings of reports
	public ExtentReports extent; //specify location of report
	public ExtentTest logger; //details to be populated in reports
	
	public void onStart(ITestContext testContext)
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
		String repName="Test-Report-"+timestamp+".html";
		
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);// Specify Location
		
		htmlreporter.config().setDocumentTitle("InetBanking Test Project");//Title of report
		htmlreporter.config().setReportName("Functional Test Report");//Name of report
		htmlreporter.config().setTheme(Theme.DARK);//Theme
		
		extent =new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "windows 10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Vardhaman");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		System.out.println(screenshotpath);
		
		File f=new File(screenshotpath);
		
		System.out.println(f.exists());
		
		logger.log(Status.FAIL, "Test Case Failed is:" + tr.getName());
		logger.log(Status.FAIL, "Test Case Failed is:" + tr.getThrowable());
		
		
		if(f.exists())
		{
			try {
			logger.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
						
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	
}
