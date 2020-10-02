import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */

public class MinimumAbsDifferenceBST {
    TreeNode treeNode;
    static int minDiff = Integer.MAX_VALUE;
    static Integer val = null;
    public static int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    public static void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        if(val == null){
            val = root.val;
        }
        else{
            minDiff = Math.min(minDiff, Math.abs(val - root.val));
            val = root.val;
        }
        dfs(root.right);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        TreeNode root = new TreeNode();
        root = root.insert(root, 5);
        root.insert(root, 3);
        root.insert(root, 6);
        root.insert(root, 2);
        root.insert(root, 4);
        root.insert(root, 7);

        System.out.println(getMinimumDifference(root));
    }
}
