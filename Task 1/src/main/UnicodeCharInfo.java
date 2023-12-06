import static java.lang.Character.*;

public class UnicodeCharInfo {

  public static final String DIGIT = "DIGIT";
  public static final String LETTER_UPPER = "LETTER_UPPER";
  public static final String LETTER_LOWER = "LETTER_LOWER";
  public static final String SPACE = "SPACE";
  public static final String OTHER = "OTHER";

  private char unicodeChar;

  public UnicodeCharInfo(char unicodeChar) {
    setUnicodeChar(unicodeChar);
  }

  public char getUnicodeChar() {
    return unicodeChar;
  }

  public void setUnicodeChar(char unicodeChar) {
    this.unicodeChar = unicodeChar;
  }

  public int getUnicodeCharToInt(){
    return unicodeChar;
  }

  public String getUnicodeCharToHex(){
    return String.format("U+%04X", getUnicodeCharToInt());
  }

  public char nextChar(){
    return (char) (unicodeChar + 1);
  }

  public char prevChar(){
    return (char) (unicodeChar - 1);
  }

  public String getCharType(){
    if(isDigit(unicodeChar)){
      return DIGIT;
    } else if(isAlphabetic(unicodeChar) &&
            (Character.UnicodeBlock.of(unicodeChar).equals(UnicodeBlock.CYRILLIC) ||
                    Character.UnicodeBlock.of(unicodeChar).equals(UnicodeBlock.BASIC_LATIN))){
      if(isLowerCase(unicodeChar)){
        return LETTER_LOWER;
      }
      return LETTER_UPPER;
    } else if(isWhitespace(unicodeChar)){
      return SPACE;
    }
    return OTHER;
  }

  public int getAlphabetNumber(){
    if(Character.UnicodeBlock.of(unicodeChar).equals(UnicodeBlock.BASIC_LATIN) &&
            isAlphabetic(unicodeChar)){
      char verificationChar = 'a'; // англ. а
      int differenceRegisters = 'a' - 'A';

      if(verificationChar > unicodeChar){
        return getUnicodeCharToInt() - verificationChar + 1 + differenceRegisters;
      }
      return getUnicodeCharToInt() - verificationChar + 1;
    }
    return -1;
  }
}
