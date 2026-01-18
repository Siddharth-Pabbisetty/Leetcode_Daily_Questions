// Daily Problem 6th January

class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int l=1;
        int maxi=1;
        int maxx=Integer.MIN_VALUE;

        while(!q.isEmpty())
        {
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            if(sum>maxx)
            {
                maxx=sum;
                maxi=l;
            }
            l++;
        }
        return maxi;
    }
}