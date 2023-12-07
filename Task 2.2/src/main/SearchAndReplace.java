import java.util.ArrayList;

public class SearchAndReplace {

  String inputString;

  public SearchAndReplace(String inputString) {
    setInputString(inputString);
  }

  public String getInputString() {
    return inputString;
  }

  public void setInputString(String inputString) {
    this.inputString = inputString;
  }

  public int[] Search(String searchStr){

    StringBuilder sbLower = new StringBuilder(inputString.toLowerCase());
    String searchStrLower = searchStr.toLowerCase();

    ArrayList<Integer> ints = new ArrayList<>();
    int startIndex;
    int i = 0;
    while (i < inputString.length()){
      startIndex = sbLower.indexOf(searchStrLower, i);
      if (startIndex >= 0){
        ints.add(startIndex);
        i = startIndex + searchStr.length();
      }
      i++;
    }
    int[] output = new int[ints.size()];
    for (int j = 0; j < ints.size(); j++) {
      output[j] = ints.get(j);
    }
    return output;
  }

  public int[] Search(String searchStr, boolean isCaseSensitive){
    if (!isCaseSensitive){
      return Search(searchStr);
    }

    StringBuilder sb = new StringBuilder(inputString);

    ArrayList<Integer> ints = new ArrayList<>();
    int startIndex;
    int i = 0;
    while (i < inputString.length()){
      startIndex = sb.indexOf(searchStr, i);
      if (startIndex >= 0){
        ints.add(startIndex);
        i = startIndex + searchStr.length();
      }
      i++;
    }
    int[] output = new int[ints.size()];
    for (int j = 0; j < ints.size(); j++) {
      output[j] = ints.get(j);
    }
    return output;
  }

  public int Replace(String searchStr, String replaceStr){

    int[] searchIndexes = Search(searchStr);
    StringBuilder sb = new StringBuilder(inputString);

    for (int i = searchIndexes.length - 1; i > -1; i--) {
      sb.replace(searchIndexes[i], searchIndexes[i] + searchStr.length(), replaceStr);
    }

    setInputString(sb.toString());
    return searchIndexes.length;
  }

  public int Replace(String searchStr, String replaceStr, boolean isCaseSensitive){
    if (!isCaseSensitive){
      return Replace(searchStr, replaceStr);
    }

    int[] searchIndexes = Search(searchStr, isCaseSensitive);
    StringBuilder sb = new StringBuilder(inputString);

    for (int i = searchIndexes.length - 1; i > -1; i--) {
      sb.replace(searchIndexes[i], searchIndexes[i] + searchStr.length(), replaceStr);
    }

    setInputString(sb.toString());
    return searchIndexes.length;
  }
}
