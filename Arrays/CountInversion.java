import java.io.IOException;
import java.util.Scanner;

public class CountInversion {
    /*
    /**
 * Counting inversions.
 * An inversion in an array a[] is a pair of entries a[i] and a[j] such that i<j but a[i]>a[j].
 * Given an array, design a linearithmic algorithm to count the number of inversions.
 *
 * Eg: In this array: [2, 4, 1, 3, 5], there are three inversions: 2,1; 4,1; 4,3
 *
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0.
 * If array is sorted in reverse order that inversion count is the maximum.
     */

    private static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return countInversions(arr, 0, arr.length - 1, aux);
    }

    private static long countInversions(int[] arr, int lo, int hi, int[] aux) {
        if (lo >= hi) return 0;

        int mid = lo + (hi - lo) / 2;

        long count = 0;
        count += countInversions(aux, lo, mid, arr);
        count += countInversions(aux, mid + 1, hi, arr);
        count += merge(arr, lo, mid, hi, aux);

        return count;
    }

    private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
        long count = 0;
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > hi) {
                arr[k++] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
                count += mid + 1 - i;
            }
        }

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of test cases: \n");
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i=0;i<t;i++) {
            System.out.println("Enter the size of the array for the test case: " + i);
            int n = scanner.nextInt();
            int[] q = new int[n];

            //String[] arrItems = scanner.nextLine().split("\n");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println("Enter the elements: ");
            for (int j = 0; j < n; j++) {
                q[j] = scanner.nextInt();
            }
            System.out.println(countInversions(q));
        }

        scanner.close();
    }
}
