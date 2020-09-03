package com.jitterted.ebp.blackjack;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.approvaltests.Approvals;
import org.approvaltests.legacycode.Range;
import org.junit.jupiter.api.Test;

class GameTest {

  @Test
  void game_always_hitting() throws Exception {
    Approvals.verifyAll("play", Range.get(1, 100), i -> i + " -> " + playTheGame(i));
  }

  private String playTheGame(int seed) {
    String output;
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(baos, true, StandardCharsets.UTF_8));

      Game.applesauce(new Random(seed), new StubUserInput("h", "s"));

      output = baos.toString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return output;
  }

  static class StubUserInput implements UserInput {

    List<String> replies;

    public StubUserInput(String... replies) {
      this.replies = new ArrayList(Arrays.asList(replies));
    }

    @Override
    public String getUserInput() {
      return replies.remove(0);
    }
  }
}
