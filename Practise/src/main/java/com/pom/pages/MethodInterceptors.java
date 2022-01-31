package com.pom.pages;

import java.util.ArrayList;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class MethodInterceptors implements IMethodInterceptor {

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		for(IMethodInstance method: methods) {
			Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
			System.out.println(method.getMethod().getMethodName());
			
//			if(method.getMethod().getMethodName().equalsIgnoreCase("invalidLogin")) {
//				System.out.println("Hello");
//				result.add(method);
//			}
			
//					
//				
//				
//			}
//			result.add(method);
			
			if(testMethod.dependsOnMethods()!=null) {
				result.add(method);
			}
		}
		return result;
	}

}
