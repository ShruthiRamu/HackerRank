import java.io.IOException;
import java.util.Scanner;

public class LongestCommonPrefix {

    /*
    Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int n = strs.length;
        int charIndex = 0;

        if(strs.length == 0)
            return "";

        String prefix = strs[0];

        for(int i=1;i<n;i++) {
            if(prefix.length() > strs[i].length()) {
                prefix= prefix.substring(0, strs[i].length());
            }
            for(int j=0; j<Math.min(prefix.length(),strs[i].length()); j++)
            {
                if(prefix.charAt(j) != strs[i].charAt(j))
                    prefix = prefix.substring(0,j); //store the value until it has the common prefix
            }
            if(prefix.isEmpty())
                break;
        }
        return prefix;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of strings to be compared: ");
        int size = scanner.nextInt();
        String[] s = new String[size];
        for(int i=0;i<size;i++) {
            System.out.println("Enter the string:");
            s[i] = scanner.next();

        }
        System.out.println(longestCommonPrefix(s));

        scanner.close();
    }
}
