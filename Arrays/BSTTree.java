public class BSTTree {
    BSTNode root;

    public BSTNode insert(int data) {
        BSTNode node = new BSTNode();
        node.data=data;
        node.left=null;
        node.right=null;

        while(this.root!=null){
            if(data<root.data) root=root.left;
            else root=root.right;
        }
        return node;
    }

}
