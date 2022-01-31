package com.practice.codes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {

	@Test
	public void test() {
		Assert.assertTrue(true, "False condition detected");
	}

}
