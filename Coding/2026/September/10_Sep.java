// Daily Problem 10th September

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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }

    private int[] solve(TreeNode root)
    {
        if(root==null)
        {
            return new int[]{0, 0};
        }
        int[] left=solve(root.left);
        int[] right=solve(root.right);
        int sum=left[0]+right[0]+root.val;
        int cnt=left[1]+right[1]+1;
        if(sum/cnt == root.val)
        {
            ans++;
        }
        return new int[]{sum, cnt};
    }
}