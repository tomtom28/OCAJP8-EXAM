import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;                                      // (1)

public class FunWithPalindromesV3 {

  public static void main(String[] args) {

    List<String> words = new ArrayList<>();
    words.add("Otto"); words.add("ADA"); words.add("Alyla");
    words.add("Bob"); words.add("HannaH"); words.add("Java");
    System.out.println("List of words:                " + words);

    Predicate<String> predicate1 = (String str) ->
        str.equals(new StringBuilder(str).reverse().toString());          // (2)
    List<String> palindromes1 = filterStrings(words, predicate1);         // (3)
    System.out.println("Case sensitive palindromes:   " + palindromes1);

    Predicate<String> predicate2 = (String str) ->
        str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());// (4)
    List<String> palindromes2 = filterStrings(words, predicate2);         // (5)
    System.out.println("Case insensitive palindromes: " + palindromes2);
  }

  /**                                                                     // (6)
   * Filters a list of strings according to the criteria of the predicate.
   * @param strList    List of strings to filter
   * @param predicate  Provides the criteria for filtering the strings
   * @return           List of strings that match the criteria
   */
  public static List<String> filterStrings(List<String> strList,
                                           Predicate<String> predicate) {
    List<String> result = new ArrayList<>();
    for (String str : strList) {
      if (predicate.test(str)) {                                          // (7)
        result.add(str);
      }
    }
    return result;
  }
}