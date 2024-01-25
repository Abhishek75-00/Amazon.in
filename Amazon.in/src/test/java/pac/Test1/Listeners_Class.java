package pac.Test1;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners_Class implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" Test Started");
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" Test Success");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" Test failure");
	}


	

}
