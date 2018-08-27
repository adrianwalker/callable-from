package org.adrianwalker.callablefrom.example.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.adrianwalker.callablefrom.CallableFrom;
import org.adrianwalker.callablefrom.CallableFromClass;
import org.adrianwalker.callablefrom.test.TestCaller;

public final class RoundNumberBusinessObject implements ApplicationLayer {

  @CallableFrom({
    @CallableFromClass(value = ConstantService.class, subclasses = false),
    @CallableFromClass(value = TestCaller.class, subclasses = true)
  })
  public Double round(final Double value, final int places) {

    if (null == value) {
      return null;
    }

    return new BigDecimal(Double.toString(value))
            .setScale(places, RoundingMode.HALF_UP)
            .doubleValue();
  }
}
