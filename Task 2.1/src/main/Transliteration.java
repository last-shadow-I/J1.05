
import static java.util.Arrays.*;

public class Transliteration {

  private static final String[] russianLetters = {"а", "б", "в", "г", "д", "е", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р",
          "с", "т", "у", "ф", "х", "ь", "ц", "я", "ё", "ю", "ж", "ч", "ш", "э", "ъ", "ы", "це", "цы", "цй", "ци", "щ"};
  private static final String[] latinLetters = {"a", "b", "v", "g", "d", "e", "z", "i", "j", "k", "l", "m", "n", "o", "p", "r",
          "s", "t", "u", "f", "x", "`", "cz", "ya", "yo", "yu", "zh", "ch", "sh", "e`", "``", "y`", "ce", "c``", "cj", "ci", "shh"};

  // ` c
  private static String rusToLat(char rusLetter, char... rusLetter2){

    char rusLetterLower = Character.toLowerCase(rusLetter);

    String latinLetter;

    if(!Character.UnicodeBlock.of(rusLetter).equals(Character.UnicodeBlock.CYRILLIC)){
      return Character.toString(rusLetter);
    } else if (rusLetter2.length == 1) {
      char rusLetter2Lower = Character.toLowerCase(rusLetter2[0]);
      int index;
      if(rusLetter2Lower == 'е' || rusLetter2Lower == 'ы' || rusLetter2Lower == 'й' || rusLetter2Lower == 'и') {
        index = asList(russianLetters).indexOf(rusLetterLower + "" + rusLetter2Lower);
      } else {
        index = asList(russianLetters).indexOf(Character.toString(rusLetterLower));
      }
      latinLetter = latinLetters[index];
    } else {
      int index = asList(russianLetters).indexOf(Character.toString(rusLetterLower));
      latinLetter = latinLetters[index];
    }

    if(Character.isUpperCase(rusLetter)){
      StringBuilder sb = new StringBuilder(latinLetter);
      sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
      latinLetter = sb.toString();
    }
    return latinLetter;
  }

  public static String rusToLat(String str){

    StringBuilder sb = new StringBuilder(str.length()*2);

    char[] chars= str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if(chars[i] != 'ц' ){
        sb.append(rusToLat(chars[i]));
      } else {
        String string = rusToLat(chars[i], chars[i+1]);
        sb.append(string);
        if(!string.equalsIgnoreCase("cz")){
          i++;
        }
      }
    }
    return sb.toString();
  }

  public static String latinToRus(String str){

    StringBuilder sb = new StringBuilder(str);
    StringBuilder sbLower = new StringBuilder(str.toLowerCase());
    int index;
    String replaceStr;
    String rusStr;
    for (int i = latinLetters.length-1; i > -1;) {
      index = sbLower.indexOf(latinLetters[i]);
      if (index >= 0){
        replaceStr = sb.substring(index, index + latinLetters[i].length());
        rusStr = russianLetters[i];
        if(Character.isUpperCase(replaceStr.toCharArray()[0])){
          StringBuilder rusSb = new StringBuilder(rusStr);
          rusSb.setCharAt(0, Character.toUpperCase(rusSb.charAt(0)));
          rusStr = rusSb.toString();
        }
        sb.replace(index, index + latinLetters[i].length(), rusStr);
        sbLower.replace(index, index + latinLetters[i].length(), rusStr);
      } else {
        i--;
      }
    }
    return sb.toString();
  }



}
