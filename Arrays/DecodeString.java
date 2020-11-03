import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class DecodeString {
    /*
    Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
     */

    public static String decodeString(String s) {
        int n =s.length();
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        int i=0;
        while(i<n) {
            if(Character.isDigit(s.charAt(i))) {
                int count = 0;
                while(Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            } else if(s.charAt(i) == '['){
                resultStack.push(res);
                i++;
            }
            else if(s.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder (resultStack.pop());
                int repeatTimes = countStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            }
            else {
                res += s.charAt(i++);
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string:" );
        String s = scanner.nextLine();

        System.out.println(decodeString(s));

        scanner.close();
    }
}
