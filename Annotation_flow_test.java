package com.lex.assiment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Annotation_flow_test {

	@Before
	public void setUp() throws Exception {
		System.out.println("M in before annotation");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("m after annotation");
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
