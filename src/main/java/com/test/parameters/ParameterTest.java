package com.test.parameters;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class ParameterTest {
	@Parameters({"p1","p2","p3"})
  @Test
  public void f(@Optional("film")String book, String elec,String life) {
		System.out.println(book);
		System.out.println(elec);
		System.out.println(life);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
