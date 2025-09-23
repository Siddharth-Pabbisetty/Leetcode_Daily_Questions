//Daily Problem 15th September

class Solution {
    public int canBeTypedWords(String text, String brokenLetters)
    {
        Set<Character> keys = new HashSet<>();
        int cnt = 0;

        for (char ch : brokenLetters.toCharArray()) {
            keys.add(ch);
        }

        String[] words = text.split(" ");

        for (String s : words) {
            for (char ch : s.toCharArray()) {
                if (keys.contains(ch)) {
                    cnt++;
                    break;
                }
            }
        }

        return words.length - cnt;
    }
}