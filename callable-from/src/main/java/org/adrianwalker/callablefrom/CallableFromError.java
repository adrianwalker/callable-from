package org.adrianwalker.callablefrom;

public final class CallableFromError extends Error {

  private static final String EXCEPTION_MESSAGE = "%s is not callable from %s";

  public CallableFromError(final Class targetClass, final Class callingClass) {

    super(String.format(EXCEPTION_MESSAGE,
            targetClass.getCanonicalName(),
            callingClass.getCanonicalName()));
  }
}
