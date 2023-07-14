/*
 * This file was automatically generated by EvoSuite
 * Wed Jul 12 22:22:53 GMT 2023
 */

package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.example.Time;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Time_ESTest extends Time_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Time time0 = new Time();
      Time time1 = new Time(138, 138);
      boolean boolean0 = time0.lessThanEqual(time1);
      assertEquals(138, time1.getMin());
      assertEquals(138, time1.getHour());
      assertTrue(boolean0);
      assertEquals(0, time0.getHour());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Time time0 = new Time();
      Time time1 = new Time((-762), (-762));
      boolean boolean0 = time0.lessThanEqual(time1);
      assertEquals((-762), time1.getHour());
      assertEquals((-762), time1.getMin());
      assertFalse(boolean0);
      assertEquals(0, time0.getHour());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Time time0 = new Time(10, 10);
      String string0 = time0.toString();
      assertEquals("1010", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Time time0 = new Time();
      int int0 = time0.getMin();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Time time0 = new Time(4791, (-227));
      int int0 = time0.getMin();
      assertEquals((-227), int0);
      assertEquals(4791, time0.getHour());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Time time0 = new Time();
      int int0 = time0.getHour();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Time time0 = new Time((-6045), 0);
      int int0 = time0.getHour();
      assertEquals((-6045), int0);
      assertEquals(0, time0.getMin());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Time time0 = new Time(4791, (-227));
      // Undeclared exception!
      try { 
        time0.set("TA*.igEpYU");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // For input string: \"TA*.igEpYU\"
         //
         verifyException("java.lang.NumberFormatException", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Time time0 = new Time(10, 10);
      // Undeclared exception!
      try { 
        time0.set((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.example.Time", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Time time0 = new Time();
      // Undeclared exception!
      try { 
        time0.lessThanEqual((Time) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.example.Time", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Time time0 = new Time(10, 10);
      int int0 = time0.getHour();
      assertEquals(10, time0.getMin());
      assertEquals(10, int0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Time time0 = new Time(10, 10);
      int int0 = time0.getMin();
      assertEquals(10, time0.getHour());
      assertEquals(10, int0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Time time0 = new Time();
      Time time1 = new Time(138, 138);
      boolean boolean0 = time1.lessThanEqual(time0);
      assertEquals(138, time1.getMin());
      assertEquals(0, time0.getHour());
      assertEquals(138, time1.getHour());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Time time0 = new Time();
      String string0 = time0.toString();
      assertEquals("0000", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Time time0 = new Time(138, 138);
      String string0 = time0.toString();
      assertEquals("138138", string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Time time0 = new Time();
      boolean boolean0 = time0.lessThanEqual(time0);
      assertTrue(boolean0);
      assertEquals(0, time0.getHour());
      assertEquals(0, time0.getMin());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Time time0 = new Time();
      // Undeclared exception!
      try { 
        time0.set("0000");
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 1
         //
         verifyException("org.example.Time", e);
      }
  }
}
