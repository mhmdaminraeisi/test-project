/*
 * This file was automatically generated by EvoSuite
 * Wed Jul 12 22:20:19 GMT 2023
 */

package org.example.filter;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.example.Flight;
import org.example.Time;
import org.example.filter.CostRangeFilter;
import org.example.filter.Input;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CostRangeFilter_ESTest extends CostRangeFilter_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      // Undeclared exception!
      try { 
        costRangeFilter0.read((Input) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.example.filter.CostRangeFilter", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      Time time0 = new Time((-1156), 0);
      Input input0 = new Input("", "", "", 1263.0467179197824, 1263.0467179197824, true, true, 1134, time0, time0, true, false);
      costRangeFilter0.read(input0);
      // Undeclared exception!
      try { 
        costRangeFilter0.apply((List<Flight>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.example.filter.CostRangeFilter", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      LinkedList<Flight> linkedList0 = new LinkedList<Flight>();
      Flight flight0 = new Flight(379);
      linkedList0.add(flight0);
      Time time0 = new Time(0, 0);
      Input input0 = new Input("Mk[>9Td!c^4|kd:G", "", (String) null, 0.0, 28.95222923653137, true, true, 0, time0, time0, true, true);
      costRangeFilter0.read(input0);
      boolean boolean0 = costRangeFilter0.apply(linkedList0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      Time time0 = new Time((-14), (-14));
      Input input0 = new Input("org.example.filter.CostRangeFilter", "business", "business", 3022.0, 3022.0, true, true, (-14), time0, time0, true, false);
      input0.setMaxPrice(0.0);
      costRangeFilter0.read(input0);
      LinkedList<Flight> linkedList0 = new LinkedList<Flight>();
      // Undeclared exception!
      try { 
        costRangeFilter0.apply(linkedList0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Bad Request
         //
         verifyException("org.example.filter.CostRangeFilter", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      Time time0 = new Time(1397, 1397);
      Input input0 = new Input("", "", "", (-1475.005470888742), (-1475.005470888742), false, true, (-2431), (Time) null, time0, true, true);
      costRangeFilter0.read(input0);
      // Undeclared exception!
      try { 
        costRangeFilter0.apply((List<Flight>) null);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Bad Request
         //
         verifyException("org.example.filter.CostRangeFilter", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      Time time0 = new Time((-1383), (-1383));
      Input input0 = new Input("", (String) null, "[iu7b0?$nl#Hv4D0>C", 0.0, 0.0, true, false, (-1383), time0, time0, true, true);
      costRangeFilter0.read(input0);
      LinkedList<Flight> linkedList0 = new LinkedList<Flight>();
      boolean boolean0 = costRangeFilter0.apply(linkedList0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      Time time0 = new Time();
      Input input0 = new Input("l*eSuyvd}mfxXRo", "Vzdm! 7mibTN[R;Q{[", "Vzdm! 7mibTN[R;Q{[", (-3880.67006569521), (-3880.67006569521), true, true, 0, time0, time0, true, true);
      costRangeFilter0.read(input0);
      LinkedList<Flight> linkedList0 = new LinkedList<Flight>();
      // Undeclared exception!
      try { 
        costRangeFilter0.apply(linkedList0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Bad Request
         //
         verifyException("org.example.filter.CostRangeFilter", e);
      }
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      LinkedList<Flight> linkedList0 = new LinkedList<Flight>();
      Time time0 = new Time();
      Input input0 = new Input("=k<~jqa9A3t", "", ",", 34.85746915, 0.0, false, true, (-1588), time0, time0, false, true);
      costRangeFilter0.read(input0);
      boolean boolean0 = costRangeFilter0.apply(linkedList0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      CostRangeFilter costRangeFilter0 = new CostRangeFilter();
      LinkedList<Flight> linkedList0 = new LinkedList<Flight>();
      boolean boolean0 = costRangeFilter0.apply(linkedList0);
      assertFalse(boolean0);
  }
}
