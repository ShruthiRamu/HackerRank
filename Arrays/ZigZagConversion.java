import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZigZagConversion {

    /*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
     */

    public static String convert(String s, int numRows) {
        /*int n=s.length();
        int count=0;
        int row=0,column=0;
        char[][] changed = new char[1000][1000000];
        char[] original = new char[n];

        original=s.toCharArray();

        for(count=0;count<n;count++){
            if(row==numRows-1 || row==numRows) {
                row=numRows-2;
                int i=count;
                while (row>=0){
                    column++;
                    changed[row][column]=original[i++];
                    row--;
                }
            } else {
                if(row==-1) {
                    row+=2;
                }
                if(column!=0) {
                    changed[row][column] = original[count];
                    row++;
                } else {
                    changed[row][column] = original[count];
                    row++;
                }
            }
        }
*/
        /*while (row < numRows && count < n) {
            changed[row++][column] = original[count++];
        }
        row=numRows-2;
        while(count<n && row>=0) {
            column++;
            changed[row][column] = original[count];
            row--;
            count++;
        }
        row++;
        count--;
        while(count<n) {
            changed[row][column] = original[count];
            row++;
            count++;
        }*/

        if(numRows<=1)
            return s;

        ArrayList<String> res=new ArrayList<>();
        for(int i=0;i<numRows;i++)
            res.add("");
        int row=0,step=1;
        for(int i=0;i<s.length();i++)
        {

            res.set(row, res.get(row)+s.charAt(i));

            if(row==0)
                step=1;
            else if(row==numRows-1)
                step=-1;

            row+=step;
        }
        s="";
        for(String s1 : res)
            s+=s1;

        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string : ");

        String s1 = scanner.nextLine();

        System.out.println("Enter the number of rows: ");
        int q = scanner.nextInt();

        String result = convert(s1,q);

        System.out.println(result);

        scanner.close();
    }
}
