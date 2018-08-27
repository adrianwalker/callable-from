package org.adrianwalker.callablefrom.example.application;

import org.adrianwalker.callablefrom.CallableFrom;
import org.adrianwalker.callablefrom.CallableFromClass;
import org.adrianwalker.callablefrom.example.dataaccess.ConstantDataAccessObject;

public final class ConstantService implements ApplicationLayer {

  private static final int DECIMAL_PLACES = 2;

  private final RoundNumberBusinessObject roundNumberBusinessObject;
  private final ConstantDataAccessObject constantDataAccessObject;

  public ConstantService(
          final RoundNumberBusinessObject roundNumberBusinessObject,
          final ConstantDataAccessObject constantDataAccessObject) {

    this.roundNumberBusinessObject = roundNumberBusinessObject;
    this.constantDataAccessObject = constantDataAccessObject;
  }

  @CallableFrom({
    @CallableFromClass(value = Facade.class, subclasses = false),
  })
  public Double getConstantByName(final String name) {

    return roundNumberBusinessObject.round(
            constantDataAccessObject.findConstantByName(name), DECIMAL_PLACES);
  }
}
