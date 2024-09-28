package tree;

import java.util.*;

public class TreeNodeUtils {

    public static void main(String[] args) {
        List<Integer> treeData = Arrays.asList(
          5,8,3,4,9,1,2
        );
        TreeNode root = null;
        for (Integer data : treeData){
           root =insertInBst(root,data,0);
        }
        System.out.println("In-order traversal of the constructed BST is: ");
        bfsPrint(root);

    }

    /**
     * function to insert in bst
     * @param node
     * @param value
     * @return
     */
    public static TreeNode insertInBst(TreeNode node, int value){

        if(node==null){
           TreeNode newNode = new TreeNode(value);
           return newNode;
        }
        else{
            if(value < node.val){
              node.left  = insertInBst(node.left, value);

            }
            else{
               node.right = insertInBst(node.right, value);
            }
        }
        return node;

    }
    public static TreeNode insertInBst(TreeNode node, int value,int height){

        if(node==null){
            TreeNode newNode = new TreeNode(value);
            newNode.height = height;
            return newNode;
        }
        else{
            if(value < node.val){
                node.left  = insertInBst(node.left, value,height+1);

            }
            else{
                node.right = insertInBst(node.right, value,height+1);
            }
        }
        return node;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void bfsPrint(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty() ){
            int size = queue.size();
            for(int i=1 ; i<=size;i++){
                TreeNode curr = queue.poll();
                System.out.print(curr.val + " and height=" + curr.height+", ");
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if (curr.right!=null){
                    queue.add(curr.right);
                }
            }
            System.out.println();
        }
    }

    public static TreeNode createBinaryTree(List<Integer> list) {
        TreeNode root = null;
        if (!list.isEmpty()) {
            root = new TreeNode(list.get(0));
            root.left = createBinaryTree(list.subList(1, (list.size() + 1) / 2));
            root.right = createBinaryTree(list.subList((list.size() + 1) / 2, list.size()));
        }
        return root;
    }
    // is Both Tree Identical
    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root2==null && root1!=null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

    }
    public static boolean isIdenticalIterative(TreeNode root1, TreeNode root2) {

        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();

        st1.push(root1);
        st2.push(root2);

        while(!st1.isEmpty() &&!st2.isEmpty()){
            TreeNode node1 = st1.pop();
            TreeNode node2 = st2.pop();

            if(node1==null && node2==null){
                continue;
            }
            if(node1==null || node2==null){
                return false;
            }
            if(node1.val!= node2.val){
                return false;
            }

            st1.push(node1.right);
            st1.push(node1.left);

            st2.push(node2.right);
            st2.push(node2.left);
        }
        if(st1.isEmpty() && st2.isEmpty()){
            return true;
        }
        return false;


    }
    /**
     * Delete Node From Binary Search Tree
     */

    public static TreeNode deleteNodeFromBST(TreeNode root,TreeNode parent,int value){
        if(root==null){
            return null;
        }
        TreeNode node= null;

        if(root.val==value){
            return root;
        } else if (value < root.val) {
          node =  deleteNodeFromBST(root.left,root,value);

        } else if (value > root.val) {
           node = deleteNodeFromBST(root.right,root,value);
        }

        if(node!=null){
            // if it has zero child
            if(node.left==null && node.right==null){
                if(parent.left==root){
                    parent.left=null;
                }
                if(parent.right==root){
                    parent.right=null;
                }

            }
        }
        return null;
    }
}
