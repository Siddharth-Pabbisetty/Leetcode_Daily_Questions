// Daily Problem 7th January

class Solution {
    static final int MOD = 1000000007;
    long total=0;
    long maxi=0;
    long solve(TreeNode root)
    {
        if(root==null)
            return 0;
        return root.val + solve(root.left) + solve(root.right);
    }
    long dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        long left=dfs(root.left);
        long right=dfs(root.right);
        long sum=root.val+left+right;
        long prod=sum*(total-sum);
        maxi=Math.max(maxi,prod);

        return sum;
    }

    public int maxProduct(TreeNode root) {
        total=solve(root);
        dfs(root);
        return (int)(maxi%MOD);
    }
}