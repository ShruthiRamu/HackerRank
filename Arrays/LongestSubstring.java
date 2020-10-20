import java.io.IOException;
import java.util.*;

public class LongestSubstring {
    /*
    Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
     */

    public static int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int max=Integer.MIN_VALUE;
        Set<Character> set=new HashSet<>();
        if(n<=1) return n;
        int right=0,left=0;

        while(right<n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                max=Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return Math.max(set.size(), max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string:" );
        String s = scanner.nextLine();

        System.out.println(lengthOfLongestSubstring(s));


        scanner.close();
    }
}
