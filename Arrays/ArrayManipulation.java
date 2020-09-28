import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {
    //Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int a,b,k;
        long[] result_array=new long[n+2];

        /* O(m*n) costly for(int[] element: queries) {
            a=element[0];
            b=element[1];
            k=element[2];

            for(int i=a-1;i<=b-1; i++) {
                result_array[i]+=k;
            }
            System.out.println("The updated array: " + Arrays.toString(result_array));
        }

        largest = result_array[0];

        for(int i=0;i<n;i++) {
            if(result_array[i] > largest) {
                largest = result_array[i];
            }
        }*/

        for(int i=0;i< queries.length;i++) {
            a=queries[i][0];
            b=queries[i][1];
            k=queries[i][2];
            result_array[a-1]+=k;
            result_array[b]-=k;
        }

        //prefix sum algorithm
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += result_array[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of the array: \n");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter the number of operations: ");
        int m = scanner.nextInt();

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the " + i + "th query (in the form a b k)");
            for(int j=0;j<3;j++) {
                queries[i][j] = scanner.nextInt();
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);


        scanner.close();
    }
}
/*
Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in the array.

Example


Queries are interpreted as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is 10 after all operations are performed.

Function Description

Complete the function arrayManipulation in the editor below.

arrayManipulation has the following parameters:

int n - the number of elements in the array
int queries[q][3] - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
Returns

int - the maximum value in the resultant array
Input Format

The first line contains two space-separated integers  and , the size of the array and the number of operations.
Each of the next  lines contains three space-separated integers ,  and , the left index, right index and summand.

Constraints

Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
Explanation

After the first update the list is 100 100 0 0 0.
After the second update list is 100 200 100 100 100.
After the third update list is 100 200 200 200 100.

The maximum value is 200.
 */