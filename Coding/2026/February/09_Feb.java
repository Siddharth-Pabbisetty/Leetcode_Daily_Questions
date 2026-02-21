// Daily Problem 9th February

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        inorder(root,l);
        return solve(l,0,l.size()-1);
    }

    private void inorder(TreeNode node,List<Integer> l)
    {
        if(node==null)
            return;
        inorder(node.left,l);
        l.add(node.val);
        inorder(node.right,l);
    }

    private TreeNode solve(List<Integer> l, int start, int end)
    {
        if(start>end)
            return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(l.get(mid));
        root.left=solve(l,start,mid-1);
        root.right=solve(l,mid+1,end);
        return root;
    }
}