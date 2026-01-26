// Daily Problem 14th January

import java.util.*;

class Solution {
    private static class Interval implements Comparable<Interval>
    {
        int start, end;
        Interval(int start, int end)
        {
            this.start=start;
            this.end=end;
        }

        public int compareTo(Interval itr)
        {
            if(this.start!=itr.start)
                return Integer.compare(this.start,itr.start);
            return Integer.compare(this.end,itr.end);
        }

        public boolean equals(Object obj)
        {
            if(this==obj)
                return true;
            if(obj==null || getClass()!=obj.getClass())
                return false;
            Interval interval = (Interval) obj;
            return start==interval.start && end==interval.end;
        }
    }

    private static class Event implements Comparable<Event> {
        int y;
        int type;
        int xStart,xEnd;
        Event(int y,int type,int xStart,int xEnd)
        {
            this.y = y;
            this.type = type;
            this.xStart = xStart;
            this.xEnd = xEnd;
        }

        public int compareTo(Event e)
        {
            return Integer.compare(this.y,e.y);
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> l=new ArrayList<>();
        for (int[] i:squares)
        {
            int x=i[0];
            int y=i[1];
            int z=i[2];
            l.add(new Event(y,1,x,x+z));
            l.add(new Event(y+z,-1,x,x+z));
        }
        Collections.sort(l);
        List<Interval> active=new ArrayList<>();
        List<double[]> process=new ArrayList<>();
        double total=0;
        int prev=l.get(0).y;
        for(Event i:l)
        {
            if(i.y>prev)
            {
                double width=getUnionWidth(active);
                double h=(double)i.y-prev;
                if(width>0)
                {
                    process.add(new double[]{prev,h,width});
                    total+=h*width;
                }
            }
            Interval curr=new Interval(i.xStart,i.xEnd);
            if(i.type==1)
            {
                active.add(curr);
            }
            else
            {
                active.remove(curr);
            }
            prev=i.y;
        }
        double target=total/2.0;
        double accumulated=0;
        for(double[] i:process)
        {
            double bottom=i[0];
            double height=i[1];
            double width=i[2];
            double stripArea=height*width;
            if(accumulated+stripArea>=target)
            {
                double missingArea=target-accumulated;
                return bottom+(missingArea/width);
            }
            accumulated+=stripArea;
        }
        return 0.0;
    }

    private double getUnionWidth(List<Interval> intervals)
    {
        if(intervals.isEmpty())
            return 0;
        List<Interval> sorted=new ArrayList<>(intervals);
        Collections.sort(sorted);
        double unionLength=0;
        double curr=-1e18;
        for(Interval i:sorted)
        {
            if (i.start>=curr)
            {
                unionLength+=(i.end - i.start);
                curr=i.end;
            }
            else if(i.end>curr)
            {
                unionLength+=(i.end-curr);
                curr=i.end;
            }
        }
        return unionLength;
    }
}