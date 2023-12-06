import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeCharInfoTest {

  char[] chars = {'0', 'N', 'z', 'Ж', (char) 32, (char) 9, '&', 'λ'};

  @Test
  void getUnicodeCharToInt() {
    int[] outputs = {48, 78, 122, 1046, 32, 9, 38, 955};
    for (int i = 0; i < chars.length; i++) {
      UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo(chars[i]);

      assertEquals(outputs[i], unicodeCharInfo.getUnicodeCharToInt());
    }
  }

  @Test
  void getUnicodeCharToHex() {
    String[] outputs = {"U+0030", "U+004E", "U+007A", "U+0416", "U+0020", "U+0009", "U+0026", "U+03BB"};
    for (int i = 0; i < chars.length; i++) {
      UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo(chars[i]);
      assertEquals(outputs[i], unicodeCharInfo.getUnicodeCharToHex());
    }
  }

  @Test
  void nextChar() {
    char[] outputs = {'1', 'O', '{', 'З', (char) 33, (char) 10, '\'', 'μ'};
    for (int i = 0; i < chars.length; i++) {
      UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo(chars[i]);
      assertEquals(outputs[i], unicodeCharInfo.nextChar());
    }
  }

  @Test
  void prevChar() {
    char[] outputs = {'/', 'M', 'y', 'Е', (char) 31, (char) 8, '%', 'κ'};
    for (int i = 0; i < chars.length; i++) {
      UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo(chars[i]);
      assertEquals(outputs[i], unicodeCharInfo.prevChar());
    }
  }

  @Test
  void getCharType() {

    String[] outputs = {UnicodeCharInfo.DIGIT, UnicodeCharInfo.LETTER_UPPER, UnicodeCharInfo.LETTER_LOWER,
            UnicodeCharInfo.LETTER_UPPER, UnicodeCharInfo.SPACE, UnicodeCharInfo.SPACE,
            UnicodeCharInfo.OTHER, UnicodeCharInfo.OTHER};
    for (int i = 0; i < chars.length; i++) {
      UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo(chars[i]);
      assertEquals(outputs[i], unicodeCharInfo.getCharType());

    }
  }

  @Test
  void getAlphabetNumber() {
    int[] outputs = {-1, 14, 26, -1, -1, -1, -1, -1};
    for (int i = 0; i < chars.length; i++) {
      UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo(chars[i]);
      assertEquals(outputs[i], unicodeCharInfo.getAlphabetNumber());
    }
  }
}