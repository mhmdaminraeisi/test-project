/*
 * This file was automatically generated by EvoSuite
 * Wed Jul 12 22:24:36 GMT 2023
 */

package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.example.Headers;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Headers_ESTest extends Headers_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Headers headers0 = new Headers();
      assertEquals('?', Headers.THE_SIGN);
  }
}
