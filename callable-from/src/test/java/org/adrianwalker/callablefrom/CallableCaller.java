package org.adrianwalker.callablefrom;

import org.adrianwalker.callablefrom.test.TestCaller;

public class CallableCaller {

  private final Callable callable;

  public CallableCaller(final Callable callable) {

    this.callable = callable;
  }

  @CallableFrom({
    @CallableFromClass(value=ErrorCaller.class, subclasses = false),
    @CallableFromClass(value=TestCaller.class, subclasses = true)
  })
  public void doStuff() {

    System.out.println("CallableCaller doing stuff");

    callable.doStuff(); // callable from here
  }
}
