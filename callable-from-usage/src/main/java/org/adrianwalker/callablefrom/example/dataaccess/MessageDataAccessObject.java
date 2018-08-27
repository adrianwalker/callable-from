package org.adrianwalker.callablefrom.example.dataaccess;

import java.util.HashMap;
import java.util.Map;
import org.adrianwalker.callablefrom.CallableFrom;
import org.adrianwalker.callablefrom.CallableFromClass;
import org.adrianwalker.callablefrom.example.application.MessageService;

public final class MessageDataAccessObject implements DataAccessLayer {

  private static final Map<Integer, String> DATABASE = new HashMap<>();

  static {
    DATABASE.put(1, "Hello Callable From World!");
    DATABASE.put(2, "Everything that is syntactically legal, "
            + "that the compiler will accept, "
            + "will eventually wind up in your code base.");
  }

  @CallableFrom({
    @CallableFromClass(value = MessageService.class, subclasses = false),
  })
  public String findMessageById(final int id) {

    return DATABASE.get(id);
  }
}
