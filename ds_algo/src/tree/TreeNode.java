package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public Integer val;
    int height=1;
    public TreeNode left;
   public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", height=" + height +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void bfs(TreeNode node) {
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
}
