import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxSumTwoNoOverlap {

    /*
    Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays, which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)

Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:

0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
0 <= j < j + M - 1 < i < i + L - 1 < A.length.


Example 1:

Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
Example 2:

Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
Example 3:

Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.
     */

    /*
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        // calculate L sums and M sums
        int n = A.length, lSum = 0, mSum = 0;
        int[] lSumArr = new int[n];
        int[] mSumArr = new int[n];
        for (int i = 0; i < n; i++) {
            lSum += A[i];
            if (i == L - 1) {
                lSumArr[i] = lSum;
            } else if (i >= L) {
                lSum -= A[i - L];
                lSumArr[i] = lSum;
            }

            mSum += A[i];
            if (i == M - 1) {
                mSumArr[i] = mSum;
            } else if (i >= M) {
                mSum -= A[i - M];
                mSumArr[i] = mSum;
            }
        }

        // keep a max-stack for M
        Deque<Integer> maxStack = new ArrayDeque<>();
        for (int i = n - 1; i >= L + M - 1; i--) {
            if (maxStack.isEmpty() || maxStack.peekFirst() <= mSumArr[i]) {
                maxStack.offerFirst(mSumArr[i]);
            }
        }

        // L goes left -> right and M goes left <- right
        int max = 0, maxL = 0, maxM = 0;
        for (int i = L - 1; i < n - M; i++) {
            maxL = Math.max(maxL, lSumArr[i]);
            maxM = maxStack.peekFirst();
            max = Math.max(max, maxL + maxM);
            if (mSumArr[i + M] == maxStack.peekFirst()) {
                maxStack.pollFirst();
            }
        }

        // keep a max-stack for L
        for (int i = n - 1; i >= L + M - 1; i--) {
            if (maxStack.isEmpty() || maxStack.peekFirst() <= lSumArr[i]) {
                maxStack.offerFirst(lSumArr[i]);
            }
        }

        // M goes left -> right and L goes left <- right
        maxL = 0;
        maxM = 0;
        for (int i = M - 1; i < n - L; i++) {
            maxL = maxStack.peekFirst();
            maxM = Math.max(maxM, mSumArr[i]);
            max = Math.max(max, maxL + maxM);
            if (lSumArr[i + L] == maxStack.peekFirst()) {
                maxStack.pollFirst();
            }
        }

        return max;
    }
     */

    /*
     int n = A.length;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = A[i];
                continue;
            }
            prefix[i] = prefix[i - 1] + A[i];
        }
		// initialize max sum for L length and M length subarrays respectively
        int lmax = prefix[L - 1], mmax = prefix[M - 1];
		//initialize max sum for case 1 and case 2
        int max1 = 0, max2 = 0;
		//L before M. enumerate all the M length subarray sums, while maintaining max L length subarray sum
        for (int i = L; i <= n - M; i++) {
            int mSum = prefix[i + M - 1] - prefix[i] + A[i];
            max1 = Math.max(max1, mSum + lmax);
            lmax = Math.max(lmax, prefix[i] - prefix[i - L]);
        }
		//M before L. enumerate all the L length subarray sums, while maintaining max M length subarray sum
        for (int i = M; i <= n - L; i++) {
            int lSum = prefix[i + L - 1] - prefix[i] + A[i];
            max2 = Math.max(max2, lSum + mmax);
            mmax = Math.max(mmax, prefix[i] - prefix[i - M]);
        }
        return Math.max(max1, max2);
     */
    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        for(int i = 1 ; i < n ; i++)
            A[i] += A[i-1];

        int res = 0;

        int l_max = A[L-1];
        int m_max = A[M-1];

        for(int i = L ; i + M - 1 < n ; i++) {
            res = Math.max(res, l_max + A[i+M-1] - A[i-1]);
            l_max = Math.max(l_max, A[i] - A[i-L]);
        }

        l_max = A[L-1];
        m_max = A[M-1];

        for(int i = M ; i + L - 1 < n ; i++) {
            res = Math.max(res, m_max + A[i+L-1] - A[i-1]);
            m_max = Math.max(m_max, A[i] - A[i-M]);
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of the array: \n");
        int n = scanner.nextInt();


        System.out.println("Enter the array of size " + n + "\n");
        int[] arr = new int[n];

        //String[] arrItems = scanner.nextLine().split("\n");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter l:");
        int l = scanner.nextInt();

        System.out.println("Enter m:");
        int m = scanner.nextInt();


        int res = maxSumTwoNoOverlap(arr, l, m);
        System.out.println(res);

        scanner.close();
    }
}
