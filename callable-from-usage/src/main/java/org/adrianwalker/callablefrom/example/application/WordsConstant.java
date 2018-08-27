package org.adrianwalker.callablefrom.example.application;

import java.io.Serializable;

public final class WordsConstant implements Serializable {

  private final String[] words;
  private final Double constant;

  public WordsConstant(final String[] words, final Double constant) {
    this.words = words;
    this.constant = constant;
  }

  public String[] getWords() {
    return words;
  }

  public Double getConstant() {
    return constant;
  }
}
