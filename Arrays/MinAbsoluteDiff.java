import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinAbsoluteDiff {
    /*
    Consider an array of integers, . We define the absolute difference between two elements,  and  (where ), to be the absolute value of .

Given an array of integers, find and print the minimum absolute difference between any two elements in the array.
 For example, given the array -2,2,4 we can create 3 pairs of numbers: -2,2 -2,4  and  2,4. The absolute differences for these pairs are -2-2=4 , -2-4=6  and 2-4 = 2 . The minimum absolute difference is .

Function Description

Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.

minimumAbsoluteDifference has the following parameter(s):

n: an integer that represents the length of arr
arr: an array of integers
Input Format

The first line contains a single integer , the size of .
The second line contains  space-separated integers .

Constraints

Output Format

Print the minimum absolute difference between any two elements in the array.

Sample Input 0

3
3 -7 0
Sample Output 0

3
Explanation 0

With  integers in our array, we have three possible pairs: , , and . The absolute values of the differences between these pairs are as follows:

Notice that if we were to switch the order of the numbers in these pairs, the resulting absolute values would still be the same. The smallest of these possible absolute differences is .

Sample Input 1

10
-59 -36 -13 1 -53 -92 -2 -96 -54 75
Sample Output 1

1
Explanation 1

The smallest absolute difference is |-54- -53| =1 .

Sample Input 2

5
1 -3 71 68 17
Sample Output 2

3
Explanation 2

The minimum absolute difference is |71-68| = 3 .
     */

    static int minimumAbsoluteDifference(int[] arr) {
        int n=arr.length;
        int min = Integer.MAX_VALUE;
        int[] aux=new int[n];
        /*Bruteforce
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int diff= arr[i] - arr[j];
                int absDiff = Math.abs(diff);
                System.out.println("Absolute diff: " + absDiff);
                min=Math.min(min, absDiff);
            }
        }
        */
        Arrays.sort(arr);
         for(int i=0;i<n-1;i++){
            int diff=arr[i+1]-arr[i];
           min=Math.min(min, diff);
         }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of the array: \n");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter the array of size " + n + "\n");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(minimumAbsoluteDifference(arr));


        scanner.close();
    }
}
