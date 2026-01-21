// Daily Problem 9th January

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;

        Map<TreeNode, TreeNode> mp = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        mp.put(root, null);

        List<TreeNode> lastLevel = new ArrayList<>();

        while(!q.isEmpty())
        {
            int size = q.size();
            lastLevel.clear();

            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                lastLevel.add(node);
                if (node.left != null)
                {
                    mp.put(node.left, node);
                    q.offer(node.left);
                }
                if (node.right != null)
                {
                    mp.put(node.right, node);
                    q.offer(node.right);
                }
            }
        }

        Set<TreeNode> s = new HashSet<>(lastLevel);

        while (s.size() > 1)
        {
            Set<TreeNode> next = new HashSet<>();
            for (TreeNode node : s)
            {
                next.add(mp.get(node));
            }
            s = next;
        }

        return s.iterator().next();
    }
}