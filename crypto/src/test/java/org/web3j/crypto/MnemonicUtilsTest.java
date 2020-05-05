/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.web3j.crypto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Unit tests for {@link MnemonicUtils} utility class. */
public class MnemonicUtilsTest {

  /**
   * Path to test vectors generated by the BIP 39 reference implementation. Each
   * test vector include input entropy, mnemonic and seed. The passphrase
   * "TREZOR" is used for all vectors.
   *
   * @see <a
   *     href="https://github.com/trezor/python-mnemonic/blob/master/vectors.json">Test
   *     vectors</a>
   */
  private static final String SAMPLE_FILE =
      "build/resources/test/mnemonics/test-vectors.txt";

  /**
   * Loads the test vectors into a in-memory list and feed them one after
   * another to our parameterized tests.
   *
   * @return Stream of test vectors in which each vector is an array containing
   *     initial entropy, expected mnemonic and expected seed.
   * @throws IOException Shouldn't happen!
   */
  public static Stream<Arguments> data() throws IOException {
    String data =
        Files.lines(Paths.get(SAMPLE_FILE)).collect(Collectors.joining("\n"));
    String[] each = data.split("###");

    List<Arguments> parameters = new ArrayList<>();
    for (String part : each) {
      parameters.add(Arguments.of((Object[])part.trim().split("\n")));
    }

    return parameters.stream();
  }

  @ParameterizedTest
  @MethodSource("data")
  public void
  generateMnemonicShouldGenerateExpectedMnemonicWords(String initialEntropy,
                                                      String mnemonic) {
    String actualMnemonic =
        MnemonicUtils.generateMnemonic(Hex.decode(initialEntropy));

    assertEquals(mnemonic, actualMnemonic);
  }

  @ParameterizedTest
  @MethodSource("data")
  public void generateSeedShouldGenerateExpectedSeeds(String initialEntropy,
                                                      String mnemonic,
                                                      String seed) {
    byte[] actualSeed = MnemonicUtils.generateSeed(mnemonic, "TREZOR");

    assertArrayEquals(Hex.decode(seed), actualSeed);
  }

  @ParameterizedTest
  @MethodSource("data")
  public void
  generateEntropyShouldGenerateExpectedEntropy(String initialEntropy,
                                               String mnemonic) {
    byte[] actualEntropy = MnemonicUtils.generateEntropy(mnemonic);

    assertArrayEquals(Hex.decode(initialEntropy), actualEntropy);
  }
}
