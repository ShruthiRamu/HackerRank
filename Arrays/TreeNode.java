import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    public TreeNode newNode(int data)
    {
        TreeNode temp = new TreeNode();

        temp.val = data;

        temp.left = null;
        temp.right = null;

        return temp;
    }
    public TreeNode insert(TreeNode root, int key) {
        // Create a new Node containing
        // the new element
        TreeNode newnode = newNode(key);

        // Pointer to start traversing from root and
        // traverses downward path to search
        // where the new node to be inserted
        TreeNode x = root;

        // Pointer y maintains the trailing
        // pointer of x
        TreeNode y = null;

        while (x != null) {
            y = x;
            if (key < x.val)
                x = x.left;
            else
                x = x.right;
        }

        // If the root is null i.e the tree is empty
        // The new node is the root node
        if (y == null)
            y = newnode;

            // If the new key is less then the leaf node key
            // Assign the new node to be its left child
        else if (key < y.val)
            y.left = newnode;

            // else assign the new node its right child
        else
            y.right = newnode;

        // Returns the pointer where the
        // new node is inserted
        return y;
    }

    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length==0) return null;

        int root_element = preorder[0];
        int root_index=-1;

        TreeNode root = new TreeNode(root_element);


        int len=preorder.length;

        for(int i=0;i<len;i++) {
            if(inorder[i]==root_element) {
                root_index=i;
            }
        }

        int[] leftIn = Arrays.copyOfRange(inorder,0,root_index);
        int[] rightIn = Arrays.copyOfRange(inorder,root_index+1, inorder.length);


        int[] leftPre = Arrays.copyOfRange(preorder,1,root_index+1);
        int[] rightPre = Arrays.copyOfRange(preorder,root_index+1, preorder.length);

        root.left=buildTree(leftPre,leftIn);
        root.right=buildTree(rightPre,rightIn);

        return root;


    }

    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length==0) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        stack.push(root);
        int i=0, j=0;
        TreeNode node = null;
        TreeNode cur = root;
        while (j<inorder.length){
            if (stack.peek().val == inorder[j]){
                node = stack.pop();
                j++;
            }
            else if (node!=null){
                cur = new TreeNode(preorder[i]);
                node.right = cur;
                node=null;
                stack.push(cur);
                i++;
            }
            else {
                cur = new TreeNode(preorder[i]);
                stack.peek().left = cur;
                stack.push(cur);
                i++;
            }
        }
        return root.left;
    }
     */


    /*
    Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
     */

    private int idx;

    public TreeNode buildTreePost(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        idx = postorder.length-1;
        TreeNode root = build(inorder, postorder, 0, idx);
        return root;
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start>end) return null;
        TreeNode node = new TreeNode(postorder[idx--]);
        if (start==end) return node;

        int index = findIdx(inorder, node.val, end);
        node.right = build(inorder, postorder, index+1, end);
        node.left = build(inorder, postorder, start, index-1);
        return node;
    }

    private int findIdx(int[] inorder, int val, int end) {
        for (int i=end; i>=0; i--) {
            if (inorder[i]==val) return i;
        }
        return 0;
    }

    /*
    Given the root of a binary tree, return the inorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [2,1]
Example 5:


Input: root = [1,null,2]
Output: [1,2]
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null) {
                stack.add(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            inorder.add(curr.val);
            curr=curr.right;

        }
        return inorder;
    }

    }
