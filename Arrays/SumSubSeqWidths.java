import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SumSubSeqWidths {

    /*
    class Solution {
    public int sumSubseqWidths(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i)
            pow2[i] = pow2[i-1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < N; ++i)
            ans = (ans + (pow2[i] - pow2[N-1-i]) * A[i]) % MOD;

        return (int) ans;
    }
}
     */

    /*
    Intuition

Let's try to count the number of subsequences with minimum A[i] and maximum A[j].

Algorithm

We can sort the array as it doesn't change the answer. After sorting the array, this allows us to know that the number of subsequences with minimum A[i] and maximum A[j] is 2^{j-i-1}2
j−i−1
 . Hence, the desired answer is:

\sum\limits_{j > i} (2^{j-i-1}) (A_j - A_i)
j>i
∑
​
 (2
j−i−1
 )(A
j
​
 −A
i
​
 )

= \big( \sum\limits_{i = 0}^{n-2} \sum\limits_{j = i+1}^{n-1} (2^{j-i-1}) (A_j) \big) - \big( \sum\limits_{i = 0}^{n-2} \sum\limits_{j = i+1}^{n-1} (2^{j-i-1}) (A_i) \big)=(
i=0
∑
n−2
​

j=i+1
∑
n−1
​
 (2
j−i−1
 )(A
j
​
 ))−(
i=0
∑
n−2
​

j=i+1
∑
n−1
​
 (2
j−i−1
 )(A
i
​
 ))

= \big( (2^0 A_1 + 2^1 A_2 + 2^2 A_3 + \cdots) + (2^0 A_2 + 2^1 A_3 + \cdots) + (2^0 A_3 + 2^1 A_4 + \cdots) + \cdots \big)=((2
0
 A
1
​
 +2
1
 A
2
​
 +2
2
 A
3
​
 +⋯)+(2
0
 A
2
​
 +2
1
 A
3
​
 +⋯)+(2
0
 A
3
​
 +2
1
 A
4
​
 +⋯)+⋯) - \big( \sum\limits_{i = 0}^{n-2} (2^0 + 2^1 + \cdots + 2^{N-i-2}) (A_i) \big)−(
i=0
∑
n−2
​
 (2
0
 +2
1
 +⋯+2
N−i−2
 )(A
i
​
 ))

= \big( \sum\limits_{j = 1}^{n-1} (2^j - 1) A_j \big) - \big( \sum\limits_{i = 0}^{n-2} (2^{N-i-1} - 1) A_i \big)=(
j=1
∑
n−1
​
 (2
j
 −1)A
j
​
 )−(
i=0
∑
n−2
​
 (2
N−i−1
 −1)A
i
​
 )

= \sum\limits_{i = 0}^{n-1} \big(((2^i - 1) A_i) - ((2^{N-i-1} - 1) A_i)\big)=
i=0
∑
n−1
​
 (((2
i
 −1)A
i
​
 )−((2
N−i−1
 −1)A
i
​
 ))

= \sum\limits_{i = 0}^{n-1} (2^i - 2^{N-i-1}) A_i=
i=0
∑
n−1
​
 (2
i
 −2
N−i−1
 )A
i
​



Complexity Analysis

Time Complexity: O(N \log N)O(NlogN), where NN is the length of A.

Space Complexity: O(N)O(N), the space used by pow2. (We can improve this to O(1)O(1) space by calculating these powers on the fly.)
     */

    /*
    Given an array of integers A, consider all non-empty subsequences of A.

For any sequence S, let the width of S be the difference between the maximum and minimum element of S.

Return the sum of the widths of all subsequences of A.

As the answer may be very large, return the answer modulo 10^9 + 7.



Example 1:

Input: [2,1,3]
Output: 6
Explanation:
Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.
     */

    public static int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long c = 1, res = 0, mod = (long)1e9 + 7;
        for (int i = 0, n = A.length; i < n; ++i, c = c * 2 % mod)
            res = (res + A[i] * c - A[n - i - 1] * c) % mod;
        return (int)((res + mod) % mod);
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



        System.out.println(sumSubseqWidths(arr));


        scanner.close();
    }
}
