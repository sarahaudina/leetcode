/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // use inorder traversal to go to the left most node, then start the
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidNode(TreeNode root, long min, long max) {
        if (root==null) {
            return true;
        }

        boolean valid = root.val> min && root.val < max;
        boolean leftValid = isValidNode(root.left, min, root.val);
        boolean rightValid = isValidNode(root.right, root.val, max);

        return valid && leftValid && rightValid;
    }
}