//Daily Problem 14th September

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> cmp = new HashMap<>();
        Map<String, String> vmp = new HashMap<>();

        for (String s : wordlist)
        {
            String lower = toLower(s);
            String notvowel = notVowel(lower);
            cmp.putIfAbsent(lower, s);
            vmp.putIfAbsent(notvowel, s);
        }
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++)
        {
            String q = queries[i];
            if (exact.contains(q))
            {
                res[i] = q;
            }
            else
            {
                String lower = toLower(q);
                String notvowel = notVowel(lower);
                if (cmp.containsKey(lower))
                    res[i] = cmp.get(lower);
                else if (vmp.containsKey(devowel))
                    res[i] = vmp.get(devowel);
                else
                    res[i] = "";
            }
        }
        return res;
    }

    private String toLower(String s)
    {
        return s.toLowerCase();
    }

    private String notVowel(String s)
    {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++)
        {
            if (isVowel(ch[i])) ch[i] = '*';
        }
        return new String(ch);
    }

    private boolean isVowel(char c)
    {
        return "aeiou".indexOf(Character.toLowerCase(c)) >= 0;
    }
}