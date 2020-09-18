package com.jitterted.ebp.blackjack;

import java.util.Scanner;

public class UserInput {

    String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
