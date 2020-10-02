import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumIterationEqualArray {
    /*
    /*numbers = [3, 4, 6, 6, 3]
iter1: add 1
[4, 4, 6, 6, 4]
iter2: add 2
[6,6,6,6,6]

or
max = getmax(numbers)//max = 6
for (int i;i < numbers.length();i++):
    if(numbers[i] < max){
        numbers[i] = number[i] + (max- numbers[i])
    }

iter1: 3 < 6
    6-3 + 3




smaller = [1,2 1]
iter1 = [1, 3, 2]
iter2= [2, 4, 3]

    public class MinIteration{
        public static int getMinIteration(int[] arr) {
            //Sort the array
            //Arrays.sort(arr);
            int max=0;
            //get max element
            for(int i=0;i<arr.length;i++){
                if(arr[i] > max){
                    max=arr[i];
                }
            }
            for(int i=)

        }
        public static void main(){
            int[] numbers = new int[5];
            numbers[0] = 3;
            numbers[1] = 4;
            numbers[2] = 6;
            numbers[3] = 6;
            numbers[4] = 3;

            int result = getMinIteration(numbers);
            System.out.println(result);


       }
    }

    Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     */

    public static int minimumIteration(int[] nums){

        int sum = nums[0];
        int minValue = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if(nums[i] < minValue) {
                minValue = nums[i];
            }
        }
        return sum - (minValue * nums.length);

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of the array: \n");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter the array of size " + n + "\n");
        int[] arr = new int[n];

        //String[] arrItems = scanner.nextLine().split("\n");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int res = minimumIteration(arr);
        System.out.println(res);

        scanner.close();
    }
}
