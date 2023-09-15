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
class BSTIterator {
    Stack<Integer> stack = new Stack();

    public BSTIterator(TreeNode root) {
        addToStack(root, stack);
    }

    public void addToStack(TreeNode root, Stack<Integer> stack) {
        // add to stack first the biggest values
        if (root.right!=null) {
            addToStack(root.right, stack);
        }

        stack.add(root.val);
        if (root.left!=null) {
            addToStack(root.left, stack);
        }
    }
    
    public int next() {
        return stack.pop();
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */