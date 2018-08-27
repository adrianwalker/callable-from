package org.adrianwalker.callablefrom.example.dataaccess;

import java.util.HashMap;
import java.util.Map;
import org.adrianwalker.callablefrom.CallableFrom;
import org.adrianwalker.callablefrom.CallableFromClass;
import org.adrianwalker.callablefrom.example.application.ConstantService;

public final class ConstantDataAccessObject implements DataAccessLayer {

  private static final Map<String, Double> DATABASE = new HashMap<>();

  static {
    DATABASE.put("pi", Math.PI);
    DATABASE.put("e", Math.E);
  }

  @CallableFrom({
    @CallableFromClass(value = ConstantService.class, subclasses = false),
  })
  public double findConstantByName(final String name) {

    return DATABASE.get(name);
  }
}
