package trim_a_binary_search_tree_669;

public class Solution {
    public static final void main(String[] args) {
        Solution solution = new Solution();
        solution.trimBST(new TreeNode(), 0, 2);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);

        root.left  = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
