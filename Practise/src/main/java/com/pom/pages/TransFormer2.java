package com.pom.pages;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.ITestAnnotation;

public class TransFormer2 implements IAnnotationTransformer {

//	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//
//		if(testMethod.getName().equalsIgnoreCase("invalidlogin")) {
//			annotation.setEnabled(false);
//		}
//		else {
//			annotation.setEnabled(false);
//		}
//	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		if(testMethod.getName().equalsIgnoreCase("invalidlogin")) {
			annotation.setDataProviderClass(Dataproviders.class);
			annotation.setDataProvider("credentials");
		}
		else {
			annotation.setEnabled(false);
		}
	}



}
