// Daily Problem 8th February

class Solution {
    public boolean isBalanced(TreeNode root) {
        return solve(root)!=-1;
    }

    private int solve(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int lHeight=solve(node.left);
        if(lHeight==-1)
        {
            return -1;
        }
        int rHeight=solve(node.right);
        if(rHeight==-1)
        {
            return -1;
        }
        if(Math.abs(lHeight-rHeight)>1)
        {
            return -1;
        }
        return 1 + Math.max(lHeight,rHeight);
    }
}