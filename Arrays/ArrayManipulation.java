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

    /*
    Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?


Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     */

    public void setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false
Example 3:

Input: matrix = [], target = 0
Output: false
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;

        int row=matrix.length;
        int col=matrix[0].length;

        int startRow=0,startCol=0;
        for(int i=0;i<row;i++){
            for(int j=col-1;j>=0;j--) {
                if(target==matrix[i][j]) {
                    return true;
                } else if(target<matrix[i][j]) {
                    startRow=0;
                    startCol=0;
                    while(startRow<row && startCol<col) {
                        if(matrix[startRow][startCol] == target) {
                            return true;
                        }
                        startCol++;
                    }
                } else {
                    startCol=0;
                    while(++startRow<row && startCol<col) {
                        if(matrix[startRow][startCol]==target) {
                            return true;
                        }
                        startRow++;
                        startCol++;
                    }
                }
            }
        }
        return false;
    }
    /*
    public boolean searchMatrix(int[][] matrix, int target) {
                if(matrix.length==0) return false;

        int row_num = matrix.length;
	    int col_num = matrix[0].length;

	int begin = 0, end = row_num * col_num - 1;

	while(begin <= end){
		int mid = (begin + end) / 2;
		int mid_value = matrix[mid/col_num][mid%col_num];

		if( mid_value == target){
			return true;

		}else if(mid_value < target){
			//Should move a bit further, otherwise dead loop.
			begin = mid+1;
		}else{
			end = mid-1;
		}
	}

	return false;
    }
     */

    public static void sortColors(int[] nums) {
        /*
        Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Follow up:

Could you solve this problem without using the library's sort function?
Could you come up with a one-pass algorithm using only O(1) constant space?


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]
         */
        int start = 0, end = nums.length - 1, index = 0;
        while (index <= end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
                index--;
            }
            index++;
        }
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