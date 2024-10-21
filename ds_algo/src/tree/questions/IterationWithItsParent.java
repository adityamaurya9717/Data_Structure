package tree.questions;

import tree.TreeNode;
import tree.TreeNodeUtils;

public class IterationWithItsParent {

    public static void main(String[] args) {
        IterationWithItsParent iterationWithItsParent = new IterationWithItsParent();
        TreeNode root = null;
        int arr[] = {3,5,1,6,2,0,8,7,4};
        for(int n : arr){
            root = TreeNodeUtils.insertInBst(root, n);
        }
       TreeNodeUtils.bfsPrint(root);
        //iterationWithItsParent.iterateWithParent(root, null);
        iterationWithItsParent.printAllHirechy(root, 8);
    }

    public void iterateWithParent(TreeNode root,TreeNode parent){
        if(root == null){
            return;
        }
        String p = parent!=null ? String.valueOf(parent.val) : "null";
        System.out.println(" node :" + root.val + " " + "parent: "+p);
        iterateWithParent(root.left,root);
        iterateWithParent(root.right,root);
    }

    public boolean printAllHirechy(TreeNode root,int val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        if( printAllHirechy(root.left,val) || printAllHirechy(root.right,val)){
            System.out.println("currentNode: " + root.val);
            return true;

        }
        return false;
    }
}
