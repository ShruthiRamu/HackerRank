import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

    /*
    Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example , the list of all anagrammatic pairs is  at positions  respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

sherlockAndAnagrams has the following parameter(s):

s: a string .
Input Format

The first line contains an integer , the number of queries.
Each of the next  lines contains a string  to analyze.

Constraints



String  contains only lowercase letters  ascii[a-z].

Output Format

For each query, return the number of unordered anagrammatic pairs.

Sample Input 0

2
abba
abcd
Sample Output 0

4
0
Explanation 0

The list of all anagrammatic pairs is  and  at positions  and  respectively.

No anagrammatic pairs exist in the second query as no character repeats.

Sample Input 1

2
ifailuhkqq
kkkk
Sample Output 1

3
10
Explanation 1

For the first query, we have anagram pairs  and  at positions  and  respectively.

For the second query:
There are 6 anagrams of the form  at positions  and .
There are 3 anagrams of the form  at positions  and .
There is 1 anagram of the form  at position .

Sample Input 2

1
cdcd
Sample Output 2

5
Explanation 2

There are two anagrammatic pairs of length :  and .
There are three anagrammatic pairs of length :  at positions  respectively.
     */

    static int anagram(String s) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();


        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<=s.length();j++) {
                String currentSubString = s.substring(i,j);

                //sort all the substrings
                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);


                // If sorted substring has been seen before
                if(map.containsKey(currentSubString))
                {
                    // Check how many times we've seen it and add that amount to the count
                    int value = map.get(currentSubString);
                    count=count+value;

                    // Increment the times we've seen the string
                    map.put(currentSubString, value+1);
                }
                else
                {
                    // Never seen it before = insert and set to 1 to indiciate we've now seen it
                    map.put(currentSubString, 1);
                }
            }
        }

        return count;
    }

        private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of test cases: ");
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            System.out.println("Enter the string : ");

            String s = scanner.nextLine();

            int result = anagram(s);
            System.out.println(result);

        }
        scanner.close();
    }
}
