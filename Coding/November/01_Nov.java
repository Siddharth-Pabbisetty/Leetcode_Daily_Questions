// Daily Problem 1st November
import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> mp = new HashSet<>();
        for (int x : nums)
            mp.add(x);
        while(head != null && mp.contains(head.val))
            head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
        {
            while (curr.next != null && mp.contains(curr.next.val))
            {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}