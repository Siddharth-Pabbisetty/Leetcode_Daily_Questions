//Daily Problem 19th September

class Spreadsheet {
    Map<String, Integer> mp = new HashMap<>();

    public Spreadsheet(int rows) {

    }

    public void setCell(String cell, int value) {
        mp.put(cell, value);
    }

    public void resetCell(String cell) {
        mp.put(cell, 0);
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        for (int i = 0; i < formula.length(); i++)
        {
            if (formula.charAt(i) == '+')
            {
                String s1 = formula.substring(0, i);
                String s2 = formula.substring(i + 1);
                int l = Character.isUpperCase(s1.charAt(0)) ? mp.getOrDefault(s1, 0) : Integer.parseInt(s1);
                int r = Character.isUpperCase(s2.charAt(0)) ? mp.getOrDefault(s2, 0) : Integer.parseInt(s2);
                return l + r;
            }
        }
        return 0;
    }
}