package org.adrianwalker.callablefrom;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public final class CallableFromAspect {

  @Before("@annotation(callableFrom) && call(* *.*(..))")
  public void before(final JoinPoint joinPoint, final CallableFrom callableFrom) throws CallableFromError {

    Class callingClass = joinPoint.getThis().getClass();
    boolean isCallable = isCallable(callableFrom, callingClass);

    if (!isCallable) {
      Class targetClass = joinPoint.getTarget().getClass();
      throw new CallableFromError(targetClass, callingClass);
    }
  }

  private boolean isCallable(final CallableFrom callableFrom, final Class callingClass) {

    boolean callable = false;
    CallableFromClass[] callableFromClasses = callableFrom.value();

    for (CallableFromClass callableFromClass : callableFromClasses) {

      Class clazz = callableFromClass.value();
      boolean subclasses = callableFromClass.subclasses();

      callable = (subclasses && clazz.isAssignableFrom(callingClass))
              || (!subclasses && clazz.equals(callingClass));

      if (callable) {
        break;
      }
    }

    return callable;
  }
}
