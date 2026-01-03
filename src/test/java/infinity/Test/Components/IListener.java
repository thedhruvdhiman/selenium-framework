package infinity.Test.Components;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import infinity.resources.ExtentReport;

import java.io.IOException;

public class IListener extends Base implements ITestListener{

	ExtentTest test;
	ExtentReports extent = ExtentReport.generateReport();
	ThreadLocal <ExtentTest> thread = new ThreadLocal<>();
	

	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		thread.get().pass("Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		thread.get().fail(result.getThrowable());

        try {
            String path = TakeScreenShot(result.getMethod().getMethodName());
			System.out.println("path to screenshot file: " + path);
			thread.get().fail("Test Failed").addScreenCaptureFromPath(result.getMethod().getMethodName() + ".png", result.getMethod().getMethodName());
        } catch (IOException e) {
			e.fillInStackTrace();
        }
    }

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	
}
