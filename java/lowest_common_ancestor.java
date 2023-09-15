/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Ituition: Rule 1: Lca should be on the lowest level possible. So we can iterate from the bottom of the tree. To check if a node is a LCA need to check for the other rules: being a parent of both p & q, so that means that iteration should be started from bottom, then to every items in the level before movinf to the higher level.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root.val==p.val || root.val==q.val) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left==null ? right : right==null ? left : root;
    }
}