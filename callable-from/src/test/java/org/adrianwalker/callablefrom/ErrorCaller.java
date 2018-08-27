package org.adrianwalker.callablefrom;

public final class ErrorCaller {

  private final CallableCaller callableCaller;

  public ErrorCaller(final CallableCaller callableCaller) {

    this.callableCaller = callableCaller;
  }

  // No annotation, callable from anywhere
  public void doStuff() {

    System.out.println("ErrorCaller doing stuff");

    callableCaller.doStuff(); // callable from here

    new Callable().doStuff(); // NOT callable from here
  }
}
