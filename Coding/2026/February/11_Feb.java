// Daily Problem 11th February

import java.util.*;

class Solution {
    static class Tree {
        int n;
        int[] odd, even, temp;
        Tree(int n)
        {
            this.n = n;
            odd = new int[4*n];
            even = new int[4*n];
            temp = new int[4*n];
        }
        void add(int idx, int v)
        {
            odd[idx] += v;
            even[idx] += v;
            temp[idx] += v;
        }
        void push(int idx)
        {
            int t=temp[idx];
            if(t!=0)
            {
                add(idx<<1,t);
                add(idx<<1|1,t);
                temp[idx]=0;
            }
        }
        void pull(int idx)
        {
            odd[idx] = Math.min(odd[idx<<1], odd[idx<<1|1]);
            even[idx] = Math.max(even[idx<<1], even[idx<<1|1]);
        }
        void addRange(int idx, int l, int r, int ql, int qr, int val)
        {
            if(ql>qr)
                return;
            if(ql<=l && r<=qr)
            {
                add(idx,val);
                return;
            }
            push(idx);
            int mid=(l+r)/2;
            if(ql<=mid)
                addRange(idx<<1,l,mid,ql,Math.min(qr,mid),val);
            if(qr>mid)
                addRange(idx<<1|1,mid+1,r,Math.max(ql,mid+1),qr,val);
            pull(idx);
        }
        void addRange(int l,int r,int v)
        {
            if(l>r)
                return;
            addRange(1,0,n-1,l,r,v);
        }
        int findRightmostZero(int idx,int l,int r,int ql,int qr)
        {
            if(ql>qr || qr<l || ql>r)
                return -1;
            if(odd[idx]>0 || even[idx]<0)
                return -1;
            if(l==r)
            {
                return odd[idx]==0?l:-1;
            }
            push(idx);
            int mid=(l+r)/2;
            if(qr>mid)
            {
                int res=findRightmostZero(idx<<1|1,mid+1,r,Math.max(ql,mid+1),qr);
                if(res!=-1)
                    return res;
            }
            if(ql<=mid)
            {
                return findRightmostZero(idx<<1,l,mid,ql,Math.min(qr,mid));
            }
            return -1;
        }
        int findRightmostZero(int l, int r)
        {
            if(l>r)
                return -1;
            return findRightmostZero(1,0,n-1,l,r);
        }
    }

    public int longestBalanced(int[] nums)
    {
        int n=nums.length;
        HashMap<Integer, ArrayList<Integer>> mp=new HashMap<>();
        for (int i=0;i<n;i++)
        {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        Tree st = new Tree(n);
        for(Map.Entry<Integer,ArrayList<Integer>> i:mp.entrySet())
        {
            int val=i.getKey();
            int sign=(val%2==1)?1:-1;
            int p=i.getValue().get(0);
            st.addRange(p,n-1,sign);
        }
        HashMap<Integer, Integer> m=new HashMap<>();
        for(int i:mp.keySet())
            m.put(i,0);

        int ans=0;
        for(int i=0;i<n;i++)
        {
            int r=st.findRightmostZero(i,n-1);
            if(r!=-1)
                ans=Math.max(ans,r-i+1);
            int x=nums[i];
            int pIndex=m.get(x);
            m.put(x,pIndex+1);
            ArrayList<Integer> lst=mp.get(x);
            int nextPos=(pIndex+1<lst.size())?lst.get(pIndex+1):n;
            int sign=(x%2==1)?1:-1;
            int left=i,right=nextPos-1;
            if(left<=right)
                st.addRange(left,right,-sign);
        }
        return ans;
    }
}