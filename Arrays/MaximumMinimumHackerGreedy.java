import org.graalvm.compiler.nodes.extended.ArrayRangeWrite;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumMinimumHackerGreedy {

    /*
    For the people that are having some problems with the way to approach this problem, I will copy paste what
    I wrote as an aswer to a guy:

The trick is to sort the array first. For example, let's say we have this array:

[3 2 8 5]

If you sort it, you get:

[2 3 5 8]

The reason is we are trying to calculate the smallest value for max-min. That means that the smallest value
for max-min will always have to be between consecutive array values; for k = 2 (groups of 2 numbers), taking 8
and 2 would yield 6, while taking 3 and 2 would yield 1, so, as you can see, the best and most efficient way to
find the smallest max-min is to do it with consecutive numbers. We can discard a lot of calculations that we know
 for sure that will never be small. Now that we know that the answer is always going to be the max-min between
 consecutive numbers, we need to test it for all subgroups; that is, for [2 3 5 8], we can create 3 subgroups:

max-min of [2 3], [3 5], and [5 8]

which yields 1, 2, and 3, respectively, with answer being 1, since it's the smallest, which is what we are looking for.

If we had the same numbers but we had to test it for k = 3 (groups of 3 numbers), we would find the smallest max-min
of the following groups:

[2 3 5], [3 5 8]

So, to solve this problem, we need to:

1) sort

2) find the max-min of each subgroup

3) compare the result of each subgroup with the fairness

4) if the result is smaller than the fairness, fairness = value of new subgroup

Hopefully it can help you.

Oh, and remember that the max and the min value of each subgroup is, in some way, already calculated, since the
array is sorted, so the min value is going to be lowest index in the subgroup, and the max value is going to be the
 highest index of each group. Remember to set fairness to a VERY high value, because testcases 7-11 work with very
 high numbers, and if fairness is very low, the testcases are not going to work.
     */

    static int maxMin(int k, int[] arr) {
        int n= arr.length;
        int diff=Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i=0;i<n-k+1;i++){
            if(arr[i+k-1]-arr[i] < diff){
                diff = arr[i+k-1]-arr[i];
            }
        }

        return diff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of array: ");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter the size of sub array: ");
        int k=scanner.nextInt();

        System.out.println("Enter the array " + n + "\n");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(maxMin(k,arr));

        scanner.close();
    }
}
