class Solution {

    int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode root, int maxValue) {

        if (root == null) {
            return;
        }

        // Good node
        if (root.val >= maxValue) {
            count++;
        }

        // Maximum value update
        maxValue = Math.max(maxValue, root.val);

        dfs(root.left, maxValue);
        dfs(root.right, maxValue);
    }
}