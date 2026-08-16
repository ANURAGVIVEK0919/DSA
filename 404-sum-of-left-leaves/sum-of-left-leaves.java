class Solution {
    // Global variable (Class-level variable)
    int globalSum = 0; 

    public int sumOfLeftLeaves(TreeNode root) {
        // 1. Har test case ke shuru mein globalSum ko 0 karna zaroori hai
        
        
        // 2. Helper function ko call karenge jo sum calculate karega
        calculateSum(root);
        
        // 3. Final answer return karenge
        return globalSum;
    }

    // Helper function jo tree mein ghumkar left leaves dundhega
    private void calculateSum(TreeNode root) {
        if (root == null) return;

        // Check agar left child ek leaf node hai
        if (root.left != null && root.left.left == null && root.left.right == null) {
            globalSum += root.left.val;  // Direct global variable mein add kar diya
        }

        // Baaki ke tree ko check karo
        calculateSum(root.left);
        calculateSum(root.right);
    }
}
