/**
 * 
 */
/**
 * 
 */
package infinity.Test.Components;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import infinity.page.PageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static void InitializeDriver() throws IOException {
		
		Properties props = new Properties();
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//infinity//resources//information.properties");
		props.load(stream);
		String browser = props.getProperty("browser");
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}

	/**
	 *  Take screenshot and return the complete location with its name; where it is stored
	 * */
	public static String TakeScreenShot(String testName) throws IOException {
		File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String outputFileLocation = System.getProperty("user.dir") + "//report//" + testName +".png";
		FileUtils.copyFile(file, new File(outputFileLocation));
		return outputFileLocation;
	}
	
	private static WebDriver getDriver() {
		return driver.get();
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public static void beforeMethod() throws Exception {
		Base.InitializeDriver();
		new PageObjects(getDriver());
		PageObjects.loginPage().openURL();
	}
	
	
	/**
	 * driver.close()
	 * */
	@AfterSuite(alwaysRun=true)
	public void afterMethod() {
		getDriver().close();
		driver.remove();
	}
}