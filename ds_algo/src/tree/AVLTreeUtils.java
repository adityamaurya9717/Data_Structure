package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AVL Tress Are Self Balancing Tree on every Time when an insertion occur there is a rotation occur
 * there are four type of rotation
 *  A ) LL rotation   #Inserted node is in the left subtree of left subtree of A
 *
 *              1
 *            /
 *          2
 *        /
 *      3
 *
 *  B) RR rotation   # Inserted node is in the right subtree of right subtree of A
 *
 *      3
 *       \
 *        4
 *         \
 *          5
 *  C) LR rotation   #Inserted node is in the right subtree of left subtree of A
 *
 *        4
 *      /
 *     5
 *      \
 *       6
 *
 *  D) RL rotation   # Inserted node is in the left subtree of right subtree of A
 *
 *        4
 *         \
 *          5
 *         /
 *        6
 *
 *
 * We Insert New Node by first finding out balance Factor
 * Balance Factor (k) = height (left(k)) - height (right(k))
 */
public class AVLTreeUtils {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5,7,12,4,6,5,3,7,8);

    }

    /**
     * First We Need To Insert A Node in tree
     * @param root
     * @param value
     */
    public static TreeNode insertNode(TreeNode root, int value) {
        if(root == null){
            return new TreeNode(value);
        }
        else if( value < root.val){
            root.left = insertNode(root.left, value);
        }
        else if(value > root.val){
            root.right = insertNode(root.right, value);
        }
        else{
            return root;
        }
        int balance = getBalanceFactor(root);


    }

    private static int getBalanceFactor(TreeNode root) {
        return 0;
    }


}
    private int balanceFactor(){
    return 0;

    }

    private static void LLRotate(){
        // Perform LL rotation
    }

    private static void RRRotate() {
        // Perform RR rotation
    }


}
