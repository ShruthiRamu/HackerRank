import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationOfString {

    /*
    Input: str = “cd”
Output: cd dc

Input: str = “abb”
Output: abb abb bab bba bab bba
     */

    static void printPermutn(String str, String ans)
    {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            printPermutn(ros, ans + ch);
        }
    }

    static void printDistinctPermutn(String str,
                                     String ans)
    {

        // If string is empty
        if (str.length() == 0) {

            // print ans
            System.out.print(ans + " ");
            return;
        }

        // Make a boolean array of size '26' which
        // stores false by default and make true
        // at the position which alphabet is being
        // used
        boolean alpha[] = new boolean[26];

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // If the character has not been used
            // then recursive call will take place.
            // Otherwise, there will be no recursive
            // call
            if (alpha[ch - 'a'] == false)
                printDistinctPermutn(ros, ans + ch);
            alpha[ch - 'a'] = true;
        }
    }

    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string:" );
        String s = scanner.nextLine();

        printPermutn(s," ");


        scanner.close();
    }
}
