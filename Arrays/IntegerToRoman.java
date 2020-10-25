import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntegerToRoman {

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.



Example 1:

Input: num = 3
Output: "III"
Example 2:

Input: num = 4
Output: "IV"
Example 3:

Input: num = 9
Output: "IX"
Example 4:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= num <= 3999
     */

    public static String intToRoman(int num) {
        StringBuilder roman= new StringBuilder();
        Map<Integer, String> romanNumeralsMap = new HashMap<>();
        int digits=0;
        romanNumeralsMap.put(0,"");
        romanNumeralsMap.put(1,"I");
        romanNumeralsMap.put(2, "II");
        romanNumeralsMap.put(3, "III");
        romanNumeralsMap.put(4, "IV");
        romanNumeralsMap.put(5,"V");
        romanNumeralsMap.put(6,"VI");
        romanNumeralsMap.put(7,"VII");
        romanNumeralsMap.put(8,"VIII");
        romanNumeralsMap.put(9,"IX");
        romanNumeralsMap.put(10,"X");
        romanNumeralsMap.put(20,"XX");
        romanNumeralsMap.put(30,"XXX");
        romanNumeralsMap.put(40,"XL");
        romanNumeralsMap.put(50,"L");
        romanNumeralsMap.put(60,"LX");
        romanNumeralsMap.put(70,"LXX");
        romanNumeralsMap.put(80,"LXXX");
        romanNumeralsMap.put(90,"XC");
        romanNumeralsMap.put(100,"C");
        romanNumeralsMap.put(200,"CC");
        romanNumeralsMap.put(300,"CCC");
        romanNumeralsMap.put(400,"CD");
        romanNumeralsMap.put(500,"D");
        romanNumeralsMap.put(600,"DC");
        romanNumeralsMap.put(700,"DCC");
        romanNumeralsMap.put(800,"DCCC");
        romanNumeralsMap.put(900,"CM");
        romanNumeralsMap.put(1000,"M");
        romanNumeralsMap.put(2000,"MM");
        romanNumeralsMap.put(3000,"MMM");

        int temp=num;

        while(num != 0) {
            num = num/10;
            ++digits;
        }

        int n=0;

        while(num!=0){
            int digit = num%10;
            n= n*10 + digit;
            num=num/10;
        }
        int thousand, hundred, ten,unit;
        switch (digits) {
            case(1):
                    roman.append(romanNumeralsMap.get(temp));
                    break;
            case(2):

                    ten = temp/10;
                    roman.append(romanNumeralsMap.get(ten*10));

                    unit = temp%10;
                    roman.append(romanNumeralsMap.get(unit));

                break;
            case(3):
                hundred = temp/100;
                roman.append(romanNumeralsMap.get(hundred*100));

                int aux = temp;
                aux=aux/10;
                ten= aux%10;
                roman.append(romanNumeralsMap.get(ten*10));

                int a=temp%10;
                unit = a;
                roman.append(romanNumeralsMap.get(unit));
                break;
            case(4):
                thousand = temp/1000;
                roman.append(romanNumeralsMap.get(thousand*1000));

                int auxil = temp/100;
                auxil=auxil%10;
                hundred = auxil;
                roman.append(romanNumeralsMap.get(hundred*100));

                int auxillary = temp/10;
                auxillary = auxillary%10;
                ten = auxillary;
                roman.append(romanNumeralsMap.get(ten*10));

                int i = temp%1000;
                i=i%100;
                i=i%10;
                unit = i;
                roman.append(romanNumeralsMap.get(unit));
                break;
            default:
                return null;

        }

        return roman.toString();
    }

    /*
    Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.



     */

    public static int RomanToInt(String s) {
        int result=0;

        Map<String, Integer> romanNumeralsMap = new HashMap<>();

        romanNumeralsMap.put("",0);
        romanNumeralsMap.put("I",1);
        romanNumeralsMap.put("II",2);
        romanNumeralsMap.put("III",3);
        romanNumeralsMap.put("IV",4);
        romanNumeralsMap.put("V",5);
        romanNumeralsMap.put("VI",6);
        romanNumeralsMap.put("VII",7);
        romanNumeralsMap.put("VIII",8);
        romanNumeralsMap.put("IX",9);
        romanNumeralsMap.put("X",10);
        romanNumeralsMap.put("XX",20);
        romanNumeralsMap.put("XXX",30);
        romanNumeralsMap.put("XL",40);
        romanNumeralsMap.put("L",50);
        romanNumeralsMap.put("LX",60);
        romanNumeralsMap.put("LXX",70);
        romanNumeralsMap.put("LXXX",80);
        romanNumeralsMap.put("XC",90);
        romanNumeralsMap.put("C",100);
        romanNumeralsMap.put("CC",200);
        romanNumeralsMap.put("CCC",300);
        romanNumeralsMap.put("CD",400);
        romanNumeralsMap.put("D",500);
        romanNumeralsMap.put("DC",600);
        romanNumeralsMap.put("DCC",700);
        romanNumeralsMap.put("DCCC",800);
        romanNumeralsMap.put("CM",900);
        romanNumeralsMap.put("M",1000);
        romanNumeralsMap.put("MM",2000);
        romanNumeralsMap.put("MMM",3000);

        for(int i=s.length()-1;i>=0;i--){
            char a = s.charAt(i);
            int ans = romanNumeralsMap.get(String.valueOf(s.charAt(i)));
            if(i>0 &&((a=='V' && s.charAt(i-1)=='I')||(a=='X' && s.charAt(i-1)=='I'))){
                result = result+ans-1;
                i--;
            }
            else if(i>0 &&((a=='L' && s.charAt(i-1)=='X')||(a=='C' && s.charAt(i-1)=='X'))){
                result = result+ans-10;
                i--;
            }
            else if(i>0 &&((a=='D' && s.charAt(i-1)=='C')||(a=='M' && s.charAt(i-1)=='C'))){
                result = result+ans-100;
                i--;
            }
            else {
                result = result + ans;
            }
        }


        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int target;
        System.out.println("Enter the number to convert to roman: ");
        target = scanner.nextInt();

        System.out.println(intToRoman(target));

        System.out.println("Enter the roman numeral to convert to number: ");
        String s = scanner.next();

        System.out.println(RomanToInt(s));


        scanner.close();
    }
}
