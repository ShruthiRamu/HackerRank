
import java.io.IOException;
import java.util.*;

public class LetterCombPhoneNum {
        /*Map<Integer, String> phoneMap = new HashMap<>();

        phoneMap.put(2,"abc");
        phoneMap.put(3,"def");
        phoneMap.put(4,"ghi");
        phoneMap.put(5,"jkl");
        phoneMap.put(6,"mno");
        phoneMap.put(7,"pqrs");
        phoneMap.put(8,"tuv");
        phoneMap.put(9,"wxyz");

        String[] letters = new String[4];
        for(int i=0;i<digits.length();i++) {
            int number = Integer.parseInt(String.valueOf(digits.charAt(i)));
            letters[i] = phoneMap.get(number);
        }
        for(String s:letters) {
            System.out.println(s);
        }
        for(int i=0;i<letters.length;i++) {
            char[] arr = letters[i].toCharArray();
            for(int j=i+1;j<letters.length;j++) {

            }
        }
*/
        public static List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return new ArrayList<>();

            String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
            List<String> combos = new ArrayList<>();
            backtrack(combos, digits.toCharArray(), "", dict);
            return combos;
        }

        public static void backtrack(List<String> combos, char[] digits, String s, String[] dict) {
            if (s.length() == digits.length) { combos.add(s); return; }
            int i = s.length();
            int digit = digits[i] - '0';
            for (char letter : dict[digit].toCharArray()) {
                backtrack(combos, digits, s + Character.toString(letter), dict);
            }
        }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the string:" );
        String s = scanner.nextLine();

        System.out.println(letterCombinations(s));


        scanner.close();
    }
}
