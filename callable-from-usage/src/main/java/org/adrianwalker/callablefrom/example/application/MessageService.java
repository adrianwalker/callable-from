package org.adrianwalker.callablefrom.example.application;

import org.adrianwalker.callablefrom.CallableFrom;
import org.adrianwalker.callablefrom.CallableFromClass;
import org.adrianwalker.callablefrom.example.dataaccess.MessageDataAccessObject;

public final class MessageService implements ApplicationLayer {

  private final UpperCaseBusinessObject upperCaseBusinessObject;
  private final SplitWordsBusinessObject splitWordsBusinessObject;
  private final MessageDataAccessObject messageDataAccessObject;

  public MessageService(
          final UpperCaseBusinessObject upperCaseBusinessObject,
          final SplitWordsBusinessObject splitWordsBusinessObject,
          final MessageDataAccessObject messageDataAccessObject) {

    this.upperCaseBusinessObject = upperCaseBusinessObject;
    this.splitWordsBusinessObject = splitWordsBusinessObject;
    this.messageDataAccessObject = messageDataAccessObject;
  }

  @CallableFrom({
    @CallableFromClass(value = Facade.class, subclasses = false),
  })
  public String[] getUpperCaseWordsById(final int id) {

    return splitWordsBusinessObject.splitWords(
            upperCaseBusinessObject.uppercaseMessage(
                    messageDataAccessObject.findMessageById(id)));
  }
}
