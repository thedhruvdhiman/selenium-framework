package infinity.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    public static ExtentReports generateReport() {
    
    	String path = System.getProperty("user.dir") + "//report//extentReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
  
        return extent;
    }

}
