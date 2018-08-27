package org.adrianwalker.callablefrom.example;

import org.adrianwalker.callablefrom.example.application.ConstantService;
import org.adrianwalker.callablefrom.example.application.Facade;
import org.adrianwalker.callablefrom.example.application.MessageService;
import org.adrianwalker.callablefrom.example.application.RoundNumberBusinessObject;
import org.adrianwalker.callablefrom.example.application.SplitWordsBusinessObject;
import org.adrianwalker.callablefrom.example.application.UpperCaseBusinessObject;
import org.adrianwalker.callablefrom.example.dataaccess.ConstantDataAccessObject;
import org.adrianwalker.callablefrom.example.dataaccess.MessageDataAccessObject;
import org.adrianwalker.callablefrom.example.presentation.WebService;
import org.adrianwalker.callablefrom.test.TestCaller;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public final class ExampleTest implements TestCaller {

  private static WebService createWebservice() {

    return new WebService(
            new Facade(
                    new MessageService(
                            new UpperCaseBusinessObject(),
                            new SplitWordsBusinessObject(),
                            new MessageDataAccessObject()),
                    new ConstantService(
                            new RoundNumberBusinessObject(),
                            new ConstantDataAccessObject())));
  }

  @Test
  public void testExample() {

    WebService webService = createWebservice();

    String expectedJson = "{"
            + "\"constant\":3.14,"
            + "\"words\":[\"HELLO\",\"CALLABLE\",\"FROM\",\"WORLD!\"]"
            + "}";
    String json = webService.getWordsConstant(1, "pi");

    assertEquals(expectedJson, json);
  }

  @Test
  public void testRoundNumberBusinessObject() {

    RoundNumberBusinessObject round = new RoundNumberBusinessObject();
    Double expected = 2.72d;
    Double actual = round.round(Math.E, 2);
    
    assertEquals(expected, actual);
  }

  @Test
  public void testUpperCaseBusinessObject() {

    UpperCaseBusinessObject upper = new UpperCaseBusinessObject();
    String expected = "TEST";
    String actual = upper.uppercaseMessage("test");
    
    assertEquals(expected, actual);
  }

  @Test
  public void testSplitWordsBusinessObject() {

    SplitWordsBusinessObject split = new SplitWordsBusinessObject();
    String[] expected = {"test", "test", "test"};
    String[] actual = split.splitWords("test test test");
    
    assertArrayEquals(expected, actual);
  }
}
