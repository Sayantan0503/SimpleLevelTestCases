package com.training.sanity.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest1 {
  @Test
  public void A() {
	  System.out.println("First");
	  Assert.assertEquals("Sunil", "Shiksha");
  }
  @Test
  public void B() {
	  System.out.println("Second");
  }
  @Test(dependsOnMethods = "A", alwaysRun= true)
  public void C() {
	  System.out.println("Third");
  }
  @Test(dependsOnMethods = "B")
  public void D() {
	  System.out.println("Fourth");
  }
  @Test
  public void E() {
	  System.out.println("Fifth");
  }
  
}