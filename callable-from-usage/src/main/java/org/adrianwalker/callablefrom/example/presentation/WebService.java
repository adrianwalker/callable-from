package org.adrianwalker.callablefrom.example.presentation;

import org.adrianwalker.callablefrom.example.application.Facade;
import org.adrianwalker.callablefrom.example.application.WordsConstant;
import org.json.JSONObject;

public final class WebService implements PresentationLayer {

  private static final String CONSTANT_KEY = "constant";
  private static final String WORDS_KEY = "words";

  private final Facade facade;

  public WebService(final Facade facade) {

    this.facade = facade;
  }

  public String getWordsConstant(final int messageId, final String constantName) {

    WordsConstant wordsConstant = facade.getWordsConstant(messageId, constantName);

    JSONObject json = new JSONObject();
    json.put(WORDS_KEY, wordsConstant.getWords());
    json.put(CONSTANT_KEY, wordsConstant.getConstant());

    return json.toString();
  }
}
