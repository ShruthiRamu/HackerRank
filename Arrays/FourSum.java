import java.io.IOException;
import java.util.*;

public class FourSum {
    // Time complexity: O(n ^ (k - 1))
    //Space complexity: O(1)
    /*
    Given an array nums of n integers and an integer target, are there elements a, b, c, and d in
    nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
     */
    public static List<List<Integer>> fourSum(int[] A, int target)
    {
        Arrays.sort(A);
        return kSum(A, 0, A.length - 1, target, 4);
    }

    private static List<List<Integer>> kSum(int[] A, int start, int end, int target, int k)
    {
        List<List<Integer>> list = new ArrayList<>();

        if(k == 2)
        {
            while(start < end)
            {
                if(A[start] + A[end] == target)
                {
                    list.add(new LinkedList<Integer>(Arrays.asList(A[start], target - A[start])));
                    while(start < end && A[start] == A[start + 1]) start++;
                    while(start < end && A[end] == A[end - 1])     end--;
                    start++; end--;
                }
                else if (A[start] + A[end] < target)
                {
                    start++;
                }
                else
                {
                    end--;
                }
            }
        }
        else // Reduce kSum to (k - 1)sum
        {
            for(int i = start; i < A.length - k + 1 && A[i] * k <= target; i++)
            {
                if(i == start || A[i] != A[i - 1])
                {
                    List<List<Integer>> mainList = kSum(A, i + 1, A.length - 1, target - A[i], k - 1);

                    for(List<Integer> subList : mainList)
                    {
                        subList.add(0, A[i]);
                    }
                    list.addAll(mainList);
                }
            }
        }
        return list;
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
        int target;
        System.out.println("Enter the target sum ");
        target = scanner.nextInt();



        List<List<Integer>>  res = fourSum(arr, target);
        System.out.println(res);


        scanner.close();
    }
}
