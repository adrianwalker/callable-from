package org.adrianwalker.callablefrom.example.application;

import org.adrianwalker.callablefrom.CallableFrom;
import org.adrianwalker.callablefrom.CallableFromClass;
import org.adrianwalker.callablefrom.example.presentation.PresentationLayer;

public final class Facade implements ApplicationLayer {

  private final MessageService messageService;
  private final ConstantService constantService;

  public Facade(
          final MessageService messageService,
          final ConstantService constantService) {

    this.messageService = messageService;
    this.constantService = constantService;
  }

  @CallableFrom({
    @CallableFromClass(value = PresentationLayer.class, subclasses = true),})
  public WordsConstant getWordsConstant(final int messageId, final String constantName) {

    return new WordsConstant(
            messageService.getUpperCaseWordsById(messageId),
            constantService.getConstantByName(constantName));
  }
}
