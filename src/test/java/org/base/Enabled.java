package org.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Enabled {

	@BeforeSuite
	private void beforeSuit() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	private void afterSuite() {
		System.out.println("After Suite");
	}

	@BeforeTest
	private void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	private void AfterTest() {
		System.out.println("After Suite");
	}

	@BeforeClass
	private void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	private void afterClass() {
		System.out.println("After Class");
	}

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("After Method");
	}

	@Test(priority = -1, enabled = false)
	private void test() {
		System.out.println("Test");

	}

	@Test
	private void test1() {
		System.out.println("test1");

	}

	@Test(priority = 2)
	private void test2() {
		System.out.println("test2");

	}

	@Test(priority = 1, enabled = true)
	private void test3() {
		System.out.println("test3");

	}

}
