class Solution {

    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Inorder ke elements ke indexes store karo
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        // Preorder se root
        int value = preorder[preIndex++];
        TreeNode root = new TreeNode(value);

        // Inorder me root ka index
        int index = map.get(value);

        // Left subtree
        root.left = build(preorder, left, index - 1);

        // Right subtree
        root.right = build(preorder, index + 1, right);

        return root;
    }
}