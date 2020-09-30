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

    }
