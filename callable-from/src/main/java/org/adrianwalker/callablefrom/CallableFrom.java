package org.adrianwalker.callablefrom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.adrianwalker.callablefrom.test.TestCaller;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CallableFrom {

  CallableFromClass[] value() default {
    @CallableFromClass(TestCaller.class)
  };
}
