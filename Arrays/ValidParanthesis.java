import java.io.IOException;
import java.util.*;

public class ValidParanthesis {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
     */

    public static boolean isValid(String s) {
        Stack<Character> open = new Stack();

        if(s.length()==1) return false;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch(c) {
                case '(':
                    open.push(c);
                    break;
                case '{':
                    open.push(c);
                    break;
                case '[':
                    open.push(c);
                    break;
                case ')':
                    if(open.empty()) return false;
                    if(open.pop()!='(') return false;
                    break;
                case '}':
                    if(open.empty()) return false;
                    if(open.pop()!='{') return false;
                    break;
                case ']':
                    if(open.empty()) return false;
                    if(open.pop()!='[') return false;
                    break;
            }


        }
        if(!open.empty()) return false;
        return true;
    }

    /*
    Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period '.' refers to the current directory. Furthermore, a double period '..' moves the directory up a level.

Note that the returned canonical path must always begin with a slash '/', and there must be only a single slash '/' between two directory names. The last directory name (if it exists) must not end with a trailing '/'. Also, the canonical path must be the shortest string representing the absolute path.



Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: path = "/a/./b/../../c/"
Output: "/c"
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        for (int i = 0; i < p.length; i++) {
            if (!stack.empty() && p[i].equals(".."))
                stack.pop();
            else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        List<String> list = new ArrayList(stack);
        return "/"+String.join("/", list);


    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of test cases: ");
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


            System.out.println("Enter the string : ");

            String s1 = scanner.nextLine();


            System.out.println(isValid(s1));


        scanner.close();
    }
}
