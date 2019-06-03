package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getAppUrl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("ie")) {

			// Create object of DesiredCapabilities class

			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();

			// Set ACCEPT_SSL_CERTS  variable to true
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver(cap);

		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger = LogManager.getLogger(BaseClass.class.getName());
		// logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void capturescreenshot(WebDriver driver, String sname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + sname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}

	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(8);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (generatedString2);

	}
}
