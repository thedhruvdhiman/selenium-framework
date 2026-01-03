package infinity.Test.Components;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import infinity.data.Data;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import infinity.page.PageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.DataProvider;

public class Base {
	
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void InitializeDriver() throws IOException {
		
		Properties props = new Properties();
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//infinity//resources//information.properties");
		props.load(stream);
		String browser = props.getProperty("browser");

        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            }
        }
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}

	/**
	 *  Take screenshot and return the complete location with its name; where it is stored
	 * */
	public static String TakeScreenShot(String testName) throws IOException {
		File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String outputFileLocation = System.getProperty("user.dir") + "/report/" + testName +".png";
		FileUtils.copyFile(file, new File(outputFileLocation));
		return outputFileLocation;
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		infinity.data.Data data = new Data();
		List<HashMap<String, String>> map = data.getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//infinity//data//purchase-data.json");
		return new Object[][] {{map.get(0)}, {map.get(1)}};
	}

	@SuppressWarnings("InstantiationOfUtilityClass")
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws Exception {
		Base.InitializeDriver();
		new PageObjects(getDriver());
		PageObjects.loginPage().openURL();
	}
	
	/**
	 * driver.quit()
	 * */
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		getDriver().quit();
		driver.remove();
	}
}