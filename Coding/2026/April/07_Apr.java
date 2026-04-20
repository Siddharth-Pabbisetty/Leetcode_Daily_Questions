// Daily Problem 7th April

class Robot {
    int x, y, width, height;
    String dir;
    public Robot(int width, int height)
    {
        this.x=0;
        this.y=0;
        this.dir="East" ;
        this.width=width;
        this.height = height;
    }
    public void step(int num)
    {
        int perimeter=2*(width-1)+2*(height-1);
        num%=perimeter;
        if(num==0)
        {
            num=perimeter;
        }
        while(num>0)
        {
            int nx=x,ny=y;
            if(dir.equals("East"))
            {
                int maxi=Math.min(x+num,width-1);
                int rem =num-(maxi-x) ;
                num=rem;
                if(rem == 0)
                {
                    x=maxi;
                }
                else
                {
                    x=maxi;
                    dir="North";
                }
            }
            else if(dir.equals("West"))
            {
                int mini=Math.max(x-num,0);
                int rem =num-(x-mini);
                num=rem;
                if(rem==0)
                {
                    x=mini;
                }
                else
                {
                    x=mini;
                    dir="South";
                }
            }
            else if(dir.equals("North"))
            {
                int maxi=Math.min(y+num,height-1);
                int rem=num-(maxi-y);
                num=rem;
                if(rem==0)
                {
                    y=maxi;
                }
                else
                {
                    y=maxi;
                    dir="West";
                }
            }
            else if(dir.equals("South"))
            {
                int mini=Math.max(y-num,0);
                int rem=num-(y-mini);
                num=rem;
                if(rem==0)
                {
                    y=mini;
                }
                else
                {
                    y=mini;
                    dir="East";
                }
            }
        }
    }

    public int[] getPos()
    {
        return new int[]{x, y};
    }
    public String getDir()
    {
        return dir;
    }
}