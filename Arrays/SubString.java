
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class SubString {

    /*
    Given two strings, determine if they share a common substring. A substring may be as small as one character.

For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.

Function Description

Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on
whether the strings share a common substring.

twoStrings has the following parameter(s):

s1, s2: two strings to analyze .
Input Format

The first line contains a single integer , the number of test cases.

The following  pairs of lines are as follows:

The first line contains string .
The second line contains string .
Constraints

 and  consist of characters in the range ascii[a-z].
Output Format

For each pair of strings, return YES or NO.

Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
Explanation

We have  pairs to check:

, . The substrings  and  are common to both strings.
, .  and  share no common substrings.
     */

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        /*Complexity: O(n^2)
        String result = "NO";

        for(int i=0;i<s1.length();i++) {
            for(int j=0;j<s2.length();j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    result = "YES";
                }
            }
        }
        return result;*/

        //Complexity: o(n)
        String result = "NO";

        HashSet<Character> s1_set = new HashSet<>();
        HashSet<Character> s2_set = new HashSet<>();

        for(int i=0;i<s1.length();i++) {
            s1_set.add(s1.charAt(i));
        }

        for(int i=0;i<s2.length();i++) {
            s2_set.add(s2.charAt(i));
        }

        s1_set.retainAll(s2_set);
        if(!s1_set.isEmpty()) {
            result = "YES";
        }

        return result;

    }

    /*
    Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
     */

    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of test cases: ");
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            System.out.println("Enter the string1 : ");

            String s1 = scanner.nextLine();

            System.out.println("Enter the string2 : ");

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);

        }
        scanner.close();
    }
}
