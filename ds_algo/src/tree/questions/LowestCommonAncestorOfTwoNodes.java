package tree.questions;

import tree.TreeNode;
import tree.TreeNodeUtils;

import java.util.Arrays;

public class LowestCommonAncestorOfTwoNodes {

    public static void main(String[] args) {
        LowestCommonAncestorOfTwoNodes l = new LowestCommonAncestorOfTwoNodes();
        TreeNode root = null;
        int arr[] = {3,5,1,6,2,0,8,7,4};
        for(int n : arr){
            root = TreeNodeUtils.insertInBst(root, n);
        }
        TreeNodeUtils.bfsPrint(root);
    }
}
