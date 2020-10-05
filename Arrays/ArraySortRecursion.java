import java.io.IOException;
import java.util.Scanner;

public class ArraySortRecursion {

    public static int isArraySorted(int[] A, int n){
        if(n==1) return 1;
        return A[n-1]<A[n-2]?0:isArraySorted(A, n-1);
    }
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        System.out.println("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            A[i] = scanner.nextInt();
        }
        int result= isArraySorted(A, n);
        if(result==1) {
            System.out.println("Array is sorted in ascending order ");
        } else {
            System.out.println("Array is not sorted in ascending order");

        }
    }
}
