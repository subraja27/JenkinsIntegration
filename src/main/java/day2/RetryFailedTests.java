package day2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryFailedTests implements IRetryAnalyzer,IAnnotationTransformer{

	int maxRetry = 0;
	public boolean retry(ITestResult result) {
		if (maxRetry<2) {
			maxRetry++;
			return true; // retry will continue
		}
		
		return false; // retry will stop
	}
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

}
