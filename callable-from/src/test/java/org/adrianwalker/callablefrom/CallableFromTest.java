package org.adrianwalker.callablefrom;

import org.adrianwalker.callablefrom.test.TestCaller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public final class CallableFromTest implements TestCaller {

  @Test
  public void testCallableFromTestCaller() {

    CallableCaller cc = new CallableCaller(new Callable());
    cc.doStuff();
  }

  @Test
  public void testCallableFromError() {

    ErrorCaller er = new ErrorCaller(new CallableCaller(new Callable()));

    try {

      er.doStuff();
      fail("Expected CallableFromError to be thrown");

    } catch (final CallableFromError cfe) {

      String expectedMessage
              = "org.adrianwalker.callablefrom.Callable "
              + "is not callable from "
              + "org.adrianwalker.callablefrom.ErrorCaller";
      String actualMessage = cfe.getMessage();

      assertEquals(expectedMessage, actualMessage);
    }
  }

  @Test
  public void testNotCallableFromSubclass() {

    CallableCallerSubclass ccs = new CallableCallerSubclass(new Callable());

    try {

      ccs.doStuff();
      fail("Expected CallableFromError to be thrown");

    } catch (final CallableFromError cfe) {

      String expectedMessage
              = "org.adrianwalker.callablefrom.Callable "
              + "is not callable from "
              + "org.adrianwalker.callablefrom.CallableCallerSubclass";
      String actualMessage = cfe.getMessage();

      assertEquals(expectedMessage, actualMessage);
    }
  }
}
