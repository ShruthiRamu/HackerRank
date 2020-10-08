import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndValidString {
    /*
    //Problem: https://www.hackerrank.com/challenges/sherlock-and-valid-string
//Java 8
/*
Initial Thoughts:
Get every chars' frequency
If there are more than two different frequencies
    NO
if 1 frequency
    YES
if 2 frequency
    if 1 occurs only once and frequency is 1
        yes
    else
        if their difference 1 and one has frequency 1
            yes
        else
            no
examples:
abcde       -> Y
a           -> Y
aabb        -> Y
aaaabbbbc   -> Y
aaaabbbbcd  -> N
aabbcd      -> N
Time Complexity: O(n) //We have to look at every char
Space Complexity: O(n) //We store frequencies in a Hashmap
*/


    static String isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        String result="YES";
        int count=0;

        for(int i=0;i<n;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(char key: map.keySet()) {
            System.out.println("Key: " + key + " Value: " + map.get(key));
        }

        HashSet<Integer> set=new HashSet<>();

        for(int value: map.values()) {
           set.add(value);
        }
        if(set.size()>2){ //more than 2 frequencies
            return "NO";
        } else if(set.size()==1) {//only one frequency across
            return "YES";
        } else {//2 different frequency
            int f1 = 0;
            int f2 = 0;
            int f1Count = 0;
            int f2Count = 0;
            int i = 0;
            for(int num : set)
            {
                if(i == 0) f1 = num;
                else f2 = num;
                i++;
            }

            for(int freq : map.values())
            {
                if(freq == f1) f1Count++;
                if(freq == f2) f2Count++;
            }



            if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
                return "YES";
            else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
                return "YES";
            else
                return "NO";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

            System.out.println("Enter the string: " );
            String s = scanner.nextLine();
            System.out.println(isValid(s));


        scanner.close();
    }
}
