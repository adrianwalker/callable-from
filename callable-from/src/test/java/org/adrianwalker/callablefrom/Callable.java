package org.adrianwalker.callablefrom;

public final class Callable {

  @CallableFrom({
    @CallableFromClass(value=CallableCaller.class, subclasses=false)
  })
  public void doStuff() {

    System.out.println("Callable doing stuff");
  }
}
