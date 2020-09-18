package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {

    private final Deck deck;

    private final List<Card> dealerHand = new ArrayList<>();
    private final List<Card> playerHand = new ArrayList<>();
    private Hand appleSauce = new Hand(playerHand);

    public static void main(String[] args) {
        playTestable(new ScannerUserInput(), new Random());
    }

    public static void playTestable(UserInput userInput, Random rnd) {
        Game game = new Game(rnd);

        System.out.println(ansi()
                .bgBright(Ansi.Color.WHITE)
                .eraseScreen()
                .cursor(1, 1)
                .fgGreen().a("Welcome to")
                .fgRed().a(" Jitterted's")
                .fgBlack().a(" BlackJack"));

        game.initialDeal();
        game.play(userInput);

        System.out.println(ansi().reset());
    }

    public Game(Random rnd) {
        deck = new Deck(rnd);
    }

    public void initialDeal() {
        // deal first round of cards, players first
//        appleSauce = appleSauce;
        appleSauce.addCard(deck);
        new Hand(dealerHand).addCard(deck);

        // deal next round of cards
        appleSauce.addCard(deck);
        new Hand(dealerHand).addCard(deck);
    }

    public void play(UserInput userInput) {
        // get Player's decision: hit until they stand, then they're done (or they go bust)
        boolean playerBusted = false;
        while (!playerBusted) {
            displayGameState();
            String playerChoice = inputFromPlayer(userInput).toLowerCase();
            if (playerChoice.startsWith("s")) {
                break;
            }
            if (playerChoice.startsWith("h")) {
                appleSauce.addCard(deck);
                if (appleSauce.handValueOf() > 21) {
                    playerBusted = true;
                }
            } else {
                System.out.println("You need to [H]it or [S]tand");
            }
        }

        // Dealer makes its choice automatically based on a simple heuristic (<=16, hit, 17>stand)
        if (!playerBusted) {
            while (new Hand(dealerHand).handValueOf() <= 16) {
                new Hand(dealerHand).addCard(deck);
            }
        }

        displayFinalGameState();

        if (playerBusted) {
            System.out.println("You Busted, so you lose.  💸");
        } else if (new Hand(dealerHand).handValueOf() > 21) {
            System.out.println("Dealer went BUST, Player wins! Yay for you!! 💵");
        } else if (new Hand(dealerHand).handValueOf() < appleSauce.handValueOf()) {
            System.out.println("You beat the Dealer! 💵");
        } else if (new Hand(dealerHand).handValueOf() == appleSauce.handValueOf()) {
            System.out.println("Push: The house wins, you Lose. 💸");
        } else {
            System.out.println("You lost to the Dealer. 💸");
        }
    }

    private String inputFromPlayer(UserInput userInput) {
        System.out.println("[H]it or [S]tand?");
        return userInput.getUserInput();
    }

    private void displayGameState() {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        System.out.println(new Hand(dealerHand).first().display()); // first card is Face Up

        // second card is the hole card, which is hidden
        displayBackOfCard();

        System.out.println();
        System.out.println("Player has: ");
        displayHand(playerHand);
        System.out.println(" (" + appleSauce.handValueOf() + ")");
    }

    private void displayBackOfCard() {
        System.out.print(
                ansi()
                        .cursorUp(7)
                        .cursorRight(12)
                        .a("┌─────────┐").cursorDown(1).cursorLeft(11)
                        .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
                        .a("│░ J I T ░│").cursorDown(1).cursorLeft(11)
                        .a("│░ T E R ░│").cursorDown(1).cursorLeft(11)
                        .a("│░ T E D ░│").cursorDown(1).cursorLeft(11)
                        .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
                        .a("└─────────┘"));
    }

    private void displayFinalGameState() {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        displayHand(dealerHand);
        System.out.println(" (" + new Hand(dealerHand).handValueOf() + ")");

        System.out.println();
        System.out.println("Player has: ");
        displayHand(playerHand);
        System.out.println(" (" + appleSauce.handValueOf() + ")");
    }

    private void displayHand(List<Card> hand) {
        System.out.println(new Hand(hand).asString());
    }
}
