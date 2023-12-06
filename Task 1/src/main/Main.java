public class Main {
  public static void main(String[] args) {

    char[] chars = {'0', 'N', 'z', 'Ж', (char) 32, (char) 9, '&', 'λ'};

    for (char character : chars) {
      UnicodeCharInfo unicodeCharInfo = new UnicodeCharInfo(character);

      System.out.println("Символ: " + unicodeCharInfo.getUnicodeChar());
      System.out.println("unicode Int: " +unicodeCharInfo.getUnicodeCharToInt());
      System.out.println("unicode Hex: " +unicodeCharInfo.getUnicodeCharToHex());
      System.out.println("next Char: " + unicodeCharInfo.nextChar());
      System.out.println("prev Char: " + unicodeCharInfo.prevChar());
      System.out.println("Char Type: " + unicodeCharInfo.getCharType());
      System.out.println("alphabet Number: " + unicodeCharInfo.getAlphabetNumber());

      System.out.println();
    }

  }
}