import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommonChild {
    /*
    A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?

For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD  ABDC.

Function Description

Complete the commonChild function in the editor below. It should return the longest string which is a common child of the input strings.

commonChild has the following parameter(s):

s1, s2: two equal length strings
Input Format

There is one line with two space-separated strings,  and .

Constraints

All characters are upper case in the range ascii[A-Z].
Output Format

Print the length of the longest string , such that  is a child of both  and .

Sample Input

HARRY
SALLY
Sample Output

 2
Explanation

The longest string that can be formed by deleting zero or more characters from  and  is AY, whose length is 2.

Sample Input 1

AA
BB
Sample Output 1

0
Explanation 1

 and  have no characters in common and hence the output is 0.

Sample Input 2

SHINCHAN
NOHARAAA
Sample Output 2

3
Explanation 2

The longest string that can be formed between  and  while maintaining the order is NHA .

Sample Input 3

ABCDEF
FBDAMN
Sample Output 3

2
Explanation 3
BD is the longest child of the given strings.
     */

    static int commonChild(String s1, String s2) {
        int n=s1.length();

        int[][] C = new int[n+1][n+1];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    C[i+1][j+1] = C[i][j] + 1;
                } else {
                    C[i+1][j+1] = Math.max(C[i+1][j], C[i][j+1]);

                }
            }
        }

        return C[n][n];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string1:" );
        String s1 = scanner.nextLine();

        System.out.println("Enter the string2:" );
        String s2 = scanner.nextLine();

        System.out.println(commonChild(s1,s2));


        scanner.close();
    }
}
