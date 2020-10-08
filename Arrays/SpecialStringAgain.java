import java.io.IOException;
import java.util.Scanner;

public class SpecialStringAgain {
    /*
    A string is said to be a special string if either of two conditions is met:

All of the characters are the same, e.g. aaa.
All characters except the middle one are the same, e.g. aadaa.
A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.

For example, given the string , we have the following special substrings: .

Function Description

Complete the substrCount function in the editor below. It should return an integer representing the number of special substrings that can be formed from the given string.

substrCount has the following parameter(s):

n: an integer, the length of string s
s: a string
Input Format

The first line contains an integer, , the length of .
The second line contains the string .

Constraints


Each character of the string is a lowercase alphabet, .

Output Format

Print a single line containing the count of total special substrings.

Sample Input 0

5
asasd
Sample Output 0

7
Explanation 0

The special palindromic substrings of asasd are
{a,s,a,s,d,asa,sas}

Sample Input 1

7
abcbaba
Sample Output 1

10
Explanation 1

The special palindromic substrings of abcbaba are
{a,b,c,b,a,b,a,bcb,bab,aba}
Sample Input 2

4
aaaa
Sample Output 2

10
Explanation 2

The special palindromic substrings of aaaa are
a,a,a,a,aa,aa,aa,aaa,aaa,aaaa
     */

    static long substrCount(int n, String s) {
        // initialize counter to n because each character is a
        // palindromic string
        int counter = n;

        // to count consecutive characters that are the same
        int consec = 1;

        // the middle index of a 3-character symmetry,
        // assigned only once detected
        int midIndex = -1;

        // compare with previous character so start with i=1
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                // Condition 1: All of the characters are the same
                // For n consecutive characters that are the same,
                // we have this formula:
                // Number of palindromic strings =
                //     (n-1) + (n-2) + ... + (n-(n-1))
                counter += consec;
                consec++;

                // Condition 2: All characters except the middle one
                // are the same
                if (midIndex > 0) {
                    // check for symmetry on both sides
                    // of the midIndex
                    if ((midIndex-consec) >= 0 && s.charAt(midIndex-consec) == s.charAt(i)) {
                        counter++;
                    } else {
                        // no more possibility of palindromic string
                        // with this midIndex
                        midIndex = -1;
                    }
                }
            } else {
                // reset consecutive chars counter to 1
                consec = 1;

                // check for a 3-character symmetry
                if (((i-2) >= 0) && s.charAt(i-2) == s.charAt(i)) {
                    counter++; // 3-char symmetry is detected

                    // to check if the next characters are the same
                    // and symmetrical along the midIndex
                    midIndex = i-1;
                } else {
                    midIndex = -1;
                }
            }
        }
        return counter;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string:" );
        String s = scanner.nextLine();

        System.out.println(substrCount(s.length(),s));


        scanner.close();
    }
}
