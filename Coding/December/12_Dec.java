// Daily Problem 12th December

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offline = new int[numberOfUsers];

        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            return timeA == timeB ? b.get(0).compareTo(a.get(0)) : timeA - timeB;
        });

        for (List<String> i : events)
        {
            if (i.get(0).equals("MESSAGE"))
            {
                handleMessage(i, mentions, offline);
            }
            else if (i.get(0).equals("OFFLINE"))
            {
                handleOffline(i, offline);
            }
        }

        return mentions;
    }

    private void handleMessage(List<String> event, int[] mentions, int[] offline) {
        int timestamp = Integer.parseInt(event.get(1));
        String[] tokens = event.get(2).split(" ");

        for (String str : tokens)
        {
            if(str.equals("ALL"))
            {
                for(int i=0;i<mentions.length;i++)
                    mentions[i]++;
            }
            else if(str.equals("HERE"))
            {
                for(int i=0;i<mentions.length;i++)
                {
                    if(offline[i]==0 || offline[i]+60<=timestamp)
                        mentions[i]++;
                }
            }
            else
            {
                int id = Integer.parseInt(str.substring(2));
                mentions[id]++;
            }
        }
    }

    private void handleOffline(List<String> event, int[] offline) {
        int timestamp=Integer.parseInt(event.get(1));
        int id=Integer.parseInt(event.get(2));
        offline[id]=timestamp;
    }
}