package com.lex.assiment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Annotation_flow_test_class_methods {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("m in Before class annotation");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("m in After class annotation");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("m in Before annotation");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("m in After annotation");
	}

	@Test
	public void test() {
		System.out.println("m in test1 annotation");
	}
	
	@Test
	public void test1() {
		System.out.println("m in test2 annotation");
	}

}
