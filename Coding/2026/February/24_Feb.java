// Daily Problem 24th February

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return solve(root,0);
    }

    public int solve(TreeNode root, int sum)
    {
        if(root==null)
        {
            return 0;
        }
        sum=sum*2+root.val;
        if(root.left==root.right)
        {
            return sum;
        }
        return solve(root.left,sum)+solve(root.right,sum);
    }
}