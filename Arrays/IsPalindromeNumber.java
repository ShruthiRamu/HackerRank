import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class IsPalindromeNumber {
    /*
    Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?



Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false
     */

    public static boolean isPalindrome(int x) {
        int n=0;
        int original = x;

        if(x<0) return false;
        while(x!=0) {
            int digit = x%10;
            n = n * 10+digit;
            x=x/10;
        }

        return original == n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int target;
        System.out.println("Enter the number: ");
        target = scanner.nextInt();

        System.out.println(isPalindrome(target));


        scanner.close();
    }
}
