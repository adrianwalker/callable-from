package org.adrianwalker.callablefrom.example;

import java.util.Random;
import org.adrianwalker.callablefrom.CallableFrom;
import org.adrianwalker.callablefrom.CallableFromClass;
import org.junit.Test;

public final class BenchmarkTest {

  private static class CallableFromRandomNumberGenerator {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @CallableFrom({
      @CallableFromClass(value = BenchmarkTest.class, subclasses = false)
    })
    public int nextInt() {

      return RANDOM.nextInt();
    }
  }

  @Test
  public void testBenchmarkCallableFrom() {

    long elapsed = generateRandomNumbers(1_000_000_000);

    System.out.printf("%s milliseconds\n", elapsed);
  }

  private long generateRandomNumbers(final int n) {

    CallableFromRandomNumberGenerator cfrng = new CallableFromRandomNumberGenerator();

    long start = System.currentTimeMillis();

    for (long i = 0; i < n; i++) {
      cfrng.nextInt();
    }

    long end = System.currentTimeMillis();

    return end - start;
  }
}
