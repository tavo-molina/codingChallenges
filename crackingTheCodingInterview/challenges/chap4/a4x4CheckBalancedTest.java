package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a4x4CheckBalancedTest extends a4x4CheckBalanced {
    @Test
    public void testCheckBalanced(){
        TreeNode root = new TreeNode(1);
        BinaryTree t = new BinaryTree(root);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(checkBalanced(t));
        root.right.right = new TreeNode(4);
        System.out.println(checkBalanced(t));
        root.right.right.right = new TreeNode(5);
        System.out.println(checkBalanced(t));
        /**note: the complexity is nlogn, because we visit the
         * all the nodes and for every node we do logn work
         *
         * Found a O(N) time O(height) solution!
         * The getHeight Method can also return if subtree is unbalanced,
         * so we can modify that method and the solution will be much better!
         *
         *
         **/
    }

}