package com.jitterted.ebp.blackjack;

import java.util.Scanner;

public class ScannerUserInput implements UserInput {

    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
