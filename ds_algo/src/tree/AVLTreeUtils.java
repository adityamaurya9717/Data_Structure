package tree;

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
 *      balance : 2
 *
 *  B) RR rotation   # Inserted node is in the right subtree of right subtree of A
 *
 *      3
 *       \
 *        4
 *         \
 *          5
 *
 *   balanceFactor : -2 , -1 , 0
 *  C) LR rotation   #Inserted node is in the right subtree of left subtree of A
 *
 *        4
 *      /
 *     5
 *      \
 *       6
 *
 *    Balance Factor 2 , -1 , 0
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
        TreeNode root = null;
        for (Integer data : list){
           root = insertNode(root, data);
        }
        System.out.println("In-order traversal of the constructed AVL Tree is: ");
        TreeNode.bfs(root);

    }

    /**
     * First We Need To Insert A Node in tree
     * @param root
     * @param value
     */
    public static TreeNode insertNode(TreeNode node, int value) {
        if(node == null){
            return new TreeNode(value);
        }
        else if( value < node.val){
            node.left = insertNode(node.left, value);
        }
        else if(value > node.val){
            node.right = insertNode(node.right, value);
        }
        else{
            return node;
        }
        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this node
        int balance = getBalanceFactor(node);

        // If the node becomes unbalanced, then apply rotations

        // Left Left Case
        if (balance > 1 && value < node.left.val)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.val)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the node pointer
        return node;

    }

    static int height(TreeNode N) {
        if (N == null)
            return 0;
        return N.height;
    }
    private static int getBalanceFactor(TreeNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);

    }

    // Right rotation
   static TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotation
    static TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }



}
