import java.io.IOException;
import java.util.Scanner;

public class ReverseInteger {

    /*
    Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
     */

    public static int reverse(int x) {
        int n=0;

        while(x!=0){
            int digit = x%10;
            n= n*10 + digit;
            x=x/10;

        }

        if(n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the integer:" );
        int s = scanner.nextInt();

        System.out.println(reverse(s));


        scanner.close();
    }
}
