/*
 * Copyright (C) Fortumo OÜ, 2020
 * All rights reserved. Proprietary and confidential.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *
 * All rights reserved. Proprietary and confidential.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Distribution, modification, reproduction, merging, publishing, sub-licensing,
 * sale and/or any other use (in binary form or otherwise) of this software is
 * not permitted, unless Fortumo OÜ has explicitly and in writing permitted such
 * use of the software.
 *
 * THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Fortumo OÜ BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jitterted.ebp.blackjack;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.legacycode.Range;
import org.approvaltests.reporters.ClipboardReporter;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameTest {

    @Test
    void stand() {
        Approvals.verifyAll("blackjack", Range.get(1337, 1350), i -> playTheGame("s", i), new Options(new ClipboardReporter()));
    }

    private String playTheGame(String command, long seed) {
        final UserInput userInput = () -> command;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(baos, true, StandardCharsets.UTF_8));

            Game.playTestable(userInput, new Random(seed));

            return baos.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void hit() {
        Approvals.verify(playTheGame("h", 1337L), new Options(new ClipboardReporter()));
    }
}
