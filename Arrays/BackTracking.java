import java.io.IOException;
import java.util.Scanner;

public class BackTracking {

    public static void printArray(int[] a, int n){

        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    /*
    Given a positive integer number N. The task is to generate all the binary strings of N bits.
    These binary strings should be in ascending order.

Examples:

Input: 2
Output:
0 0
0 1
1 0
1 1

     */
    public static void binaryString(int n, int[] a, int i){
        if(i==n) {
            printArray(a, n);
            return;
        }
        else {
            a[i]=0;
            binaryString(n, a, i+1);
            a[i] = 1;
            binaryString(n,a, i+1);
        }
    }

    /*
    Given two integers k and n, write a function that prints all the sequences of length k composed of numbers
    1,2..n. You need to print these sequences in sorted order.
Examples:

Input: k = 2, n = 3

Output:
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
     */
    public static void kString(int n, int k, int[] a, int index){
        if(k==0){
            printArray(a, index);
            return;
        }
        if(k>0) {
            for(int i=1;i<=n;i++){
                a[index] = i;
                kString(n, k-1, a,index+1);
            }
        }
    }

    /*
    Input : M[][5] = { 0 0 1 1 0
                   1 0 1 1 0
                   0 1 0 0 0
                   0 0 0 0 1 }
Output : 6
In the following example, there are
2 regions one with length 1 and the
other as 6. So largest region: 6
     */

    public static boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited){
        return ((row>=0) && (row<ROW) && (col>=0) && (col<COL) &&(matrix[row][col]==1 && !visited[row][col]));
    }
    public static void DFS(int[][] matrix, int row, int col, boolean[][] visited){
        //Search in 8 directions + X
        int[] rowNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;

        for(int k=0;k<8;k++){
            if(isSafe(matrix, row+rowNbr[k], col+colNbr[k], visited)){
                count++;
                DFS(matrix, row+rowNbr[k], col+colNbr[k], visited);
            }
        }
    }

    public static int largestRegion(int[][] matrix){
        boolean[][] visited = new boolean[ROW][COL];

        int result=0;
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    count=1;
                    DFS(matrix, i, j,visited);
                    result=Math.max(result, count);
                }
            }
        }
        return result;
    }
    public static final Scanner scanner = new Scanner(System.in);
    static int ROW, COL, count;
    public static void main(String[] args) throws IOException{
        /*System.out.println("Enter n: ");
        int n = scanner.nextInt();
        //int[] a = new int[n];
        //binaryString(n,a,0);

        //K-ary string
        System.out.println("Enter k: ");
        int k = scanner.nextInt();
        int[] a = new int[k];

        kString(n,k,a,0);*/

        //Length of connected cells of 1s or number of islands
        System.out.println("Enter the value of row: ");
        ROW=scanner.nextInt();
        System.out.println("Enter the value of column: ");
        COL=scanner.nextInt();

        int[][] matrix=new int[ROW][COL];
        System.out.println("Enter the matrix: ");
        for(int i=0;i<ROW;i++){
            System.out.println("Enter "+(i+1)+" row: ");
            for(int j=0;j<COL;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }

        System.out.println(largestRegion(matrix));

    }
}
