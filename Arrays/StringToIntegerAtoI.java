import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class StringToIntegerAtoI {

    /*
    Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered a whitespace character.
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.


Example 1:

Input: str = "42"
Output: 42
Example 2:

Input: str = "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: str = "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: str = "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: str = "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Thefore INT_MIN (−231) is returned.

     */
    public static int myAtoi(String s) {
        /*int n=s.length();
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        if(n==0) return 0;
        if(n==1) {
            if(Character.isDigit(chars[0])) {
                stringBuilder.append(chars[0]);
                return Integer.parseInt(stringBuilder.toString());
            }
            else return 0;
        }
        if(n > 1) {
            char first = s.charAt(0);
            char second = s.charAt(1);
            if (Character.isLetter(first) || first == '.' || (first == '+' && second=='-') ||
            (first == '-' && second=='+')) {
                return 0;
            }
        }

        for(int i=0;i<n;i++) {
            if(Character.isWhitespace(chars[i])) {
                continue;
            }
            if(chars[i] == '-') {
                stringBuilder.append(chars[i]);
            }
            if(chars[i] == '.') {
                break;
            }
            else if(Character.isDigit(chars[i])) {
                stringBuilder.append(chars[i]);
            }
        }
        Long result= Long.parseLong(stringBuilder.toString());
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            if(result >0) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        } else{
            return result.intValue();
        }*/
        long answer = 0;
        boolean isNegative = false;
        boolean started = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(started && !(c >= '0' && c <= '9')) {
                break;
            }

            if(c == ' ') {
                continue;
            } else if(c == '-') {
                isNegative = true;
                started = true;
                continue;
            } else if(c == '+') {
                started = true;
                continue;
            } else if(c >= '0' && c <= '9') {
                started = true;
                answer = (answer * 10) + Character.getNumericValue(c);
                if(answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                continue;
            } else {
                break;
            }
        }

        return (int)(isNegative ? answer * -1 : answer);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string:" );
        String s = scanner.nextLine();

        System.out.println(myAtoi(s));


        scanner.close();
    }
}
