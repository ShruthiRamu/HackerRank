import java.util.Arrays;
import java.util.Scanner;

public class SearchDiffPairs {
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int count=0;
        int i=0,j=1;
        while(j<n) {
            int diff =arr[j]-arr[i];
            if(diff==k){
                count++;
                j++;
            }
            if(diff>k) {
                i++;
            }
            if(diff<k) {
                j++;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);


        scanner.close();
    }
}
