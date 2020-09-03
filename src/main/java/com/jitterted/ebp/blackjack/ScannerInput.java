package com.jitterted.ebp.blackjack;

import java.util.Scanner;

public class ScannerInput implements UserInput {

  private final Scanner scanner;

  public ScannerInput(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public String getUserInput() {
    return scanner.nextLine();
  }

}
