import java.io.IOException;
import java.util.*;

public class ReverseShuffleMerge {

    /*
    Given a string, S, we define some operations on the string as follows:
a. reverse(S) denotes the string obtained by reversing string S. E.g.: reverse("abc") = "cba"
b. shuffle(S) denotes any string that's a permutation of string S. E.g.: shuffle("god") ∈ ['god', 'gdo', 'ogd', 'odg', 'dgo', 'dog']
c. merge(S1,S2) denotes any string that's obtained by interspersing the two strings S1 & S2, maintaining the order of characters in both.
E.g.: S1 = "abc" & S2 = "def", one possible result of merge(S1,S2) could be "abcdef", another could be "abdecf", another could be "adbecf" and so on.
Given a string S such that S∈ merge(reverse(A), shuffle(A)), for some string A, can you find the lexicographically smallest A?
Input Format
A single line containing the string S.
Constraints:
S contains only lower-case English letters.
The length of string S is less than or equal to 10000.
Output Format
A string which is the lexicographically smallest valid A.
Sample Input
eggegg
Sample Output
egg
Explanation
reverse("egg") = "gge"
shuffle("egg") can be "egg"
"eggegg" belongs to merge of ("gge", "egg")
The split is: e(gge)gg.
egg is the lexicographically smallest.
     */

    static String reverseShuffleMerge(String S) {
        Map<Character, Integer> remainedLetter2count = buildLetter2count(S);
        Map<Character, Integer> neededLetter2count = halve(remainedLetter2count);

        SortedMap<Character, Queue<Integer>> letter2indices = new TreeMap<Character, Queue<Integer>>();
        int left = S.length();
        int right = S.length() - 1;
        StringBuilder result = new StringBuilder();
        while (result.length() * 2 < S.length()) {
            while (left == S.length()
                    || remainedLetter2count.get(S.charAt(left)) > neededLetter2count.get(S.charAt(left))) {
                if (left < S.length()) {
                    remainedLetter2count.put(S.charAt(left), remainedLetter2count.get(S.charAt(left)) - 1);
                }

                left--;

                char letter = S.charAt(left);
                if (neededLetter2count.get(letter) > 0) {
                    if (!letter2indices.containsKey(letter)) {
                        letter2indices.put(letter, new LinkedList<Integer>());
                    }
                    letter2indices.get(letter).offer(left);
                }
            }

            char chosen = letter2indices.firstKey();
            result.append(chosen);

            neededLetter2count.put(chosen, neededLetter2count.get(chosen) - 1);

            int chosenIndex = letter2indices.get(chosen).peek();
            while (right >= chosenIndex) {
                char letter = S.charAt(right);
                if (letter2indices.containsKey(letter)) {
                    letter2indices.get(letter).poll();
                    if (letter2indices.get(letter).isEmpty()) {
                        letter2indices.remove(letter);
                    }
                }

                right--;
            }
            if (neededLetter2count.get(chosen) == 0 && letter2indices.containsKey(chosen)) {
                letter2indices.remove(chosen);
            }
        }
        return result.toString();
    }

    static Map<Character, Integer> buildLetter2count(String str) {
        Map<Character, Integer> letter2count = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!letter2count.containsKey(letter)) {
                letter2count.put(letter, 0);
            }
            letter2count.put(letter, letter2count.get(letter) + 1);
        }
        return letter2count;
    }

    static Map<Character, Integer> halve(Map<Character, Integer> letter2count) {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> entry : letter2count.entrySet()) {
            result.put(entry.getKey(), entry.getValue() / 2);
        }
        return result;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string:" );
        String s = scanner.nextLine();

        System.out.println(reverseShuffleMerge(s));


        scanner.close();
    }
}
