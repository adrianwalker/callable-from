package org.adrianwalker.callablefrom.example.application;

import org.adrianwalker.callablefrom.CallableFrom;
import org.adrianwalker.callablefrom.CallableFromClass;
import org.adrianwalker.callablefrom.test.TestCaller;

public final class UpperCaseBusinessObject implements ApplicationLayer {

  @CallableFrom({
    @CallableFromClass(value = MessageService.class, subclasses = false),
    @CallableFromClass(value = TestCaller.class, subclasses = true)
  })
  public String uppercaseMessage(final String message) {

    if (null == message) {
      return null;
    }

    return message.toUpperCase();
  }
}
