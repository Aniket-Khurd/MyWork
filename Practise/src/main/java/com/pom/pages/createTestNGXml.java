package com.pom.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class createTestNGXml {
	
	public   void runTestNG() {
		XmlSuite suite = new XmlSuite();
		suite.setName("xmlsuite");
		
		XmlTest test = new XmlTest(suite);
		test.setName("xmltest");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.pom.test.OrangeListnerTest"));
		test.setXmlClasses(classes);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		
		TestNG testng = new TestNG();
		testng.setXmlSuites(suites);
		testng.run();

	}
	
	public static void main(String[] args) {
		
		
		
		createTestNGXml create = new createTestNGXml();
		create.runTestNG();
	}

}
