// Daily Problem 31st August

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int mini=100000,i=1;
        int first=0,last=0;
        ListNode prev=head,curr=head.next,nxt=head.next.next;
        while(nxt!=null)
        {
            if(isCrit(prev,curr,nxt))
            {
                if(first==0)
                {
                    first=i;
                }
                else
                {
                    mini=Math.min(mini,i-last);
                }
                last=i;
            }
            prev=curr;
            curr=nxt;
            nxt=nxt.next;
            i++;
        }
        if(first==last)
        {
            return new int[]{-1, -1};
        }
        return new int[]{mini,last-first};
    }

    boolean isCrit(ListNode prev,ListNode curr,ListNode next) {
        return (prev.val<curr.val && curr.val>next.val) || (prev.val>curr.val && curr.val<next.val);
    }
}