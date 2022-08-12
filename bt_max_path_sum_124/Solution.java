package bt_max_path_sum_124;

public class Solution {
    private int max = Integer.MIN_VALUE;
    /**
     * 使用DFS求解 (后序遍历填入算法)
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        traverse(root, root);
        return max;
    }

    // 返回子树之和
    private int traverse(TreeNode root, TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = traverse(root, node.left);
        int right = traverse(root, node.right);
        
        int sum;

        // 求当前节点之下的最大路径 
        if (left < 0) {
            left = 0;
        }

        if (right < 0) {
            right = 0;
        }

        if (node != root) {
            // 将local最大值存入
            max = Math.max(left + right + node.val, max);
            sum = Math.max(left, right) + node.val;
        } else {
            sum = left + right + node.val;
        }

        max = Math.max(sum, max);

        return sum;
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
