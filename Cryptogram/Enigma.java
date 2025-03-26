public class Enigma {
    private char[] lookupTable;

    public Enigma(int numLetInAlph) {
        lookupTable = new char[numLetInAlph];

        for (int i = 0; i < numLetInAlph; i++) {
            lookupTable[i] = '-';
        }
    }

    public void setSubstitution(int i, char ch) {
        lookupTable[i] = ch;
    }

    public String decode(String text) {
        String decoded = "";

        for (int i = 0; i < text.length(); i++) {
            if (Character.getNumericValue(text.charAt(i)) > 9) {
                decoded += lookupTable[Character.getNumericValue(text.charAt(i)) - Character.getNumericValue('A')];
            } else {
                decoded += text.charAt(i);
            } 
        }
      
        return decoded;
    }

    public String getHints(String text, String lettersByFrequency) {
        String hint = "";
        int[] hintArray = countLetters(text);
        char[] hints = new char[lookupTable.length];

        for (int i = 0; i < hintArray.length; i++) {
            int rank = 0;

            for (int j = 0; j < hintArray.length; j++) {
                if (hintArray[j] <= hintArray[i]) {
                    rank++;
                }
            }

            hints[i] = lettersByFrequency.charAt(rank - 1);
        }

        for (char ch : hints) {
            hint += ch;
        }

        return hint;
    }

    private int[] countLetters(String text) {
        int[] countedLetters = new int[lookupTable.length];
      
        for (int i = 0; i < text.length(); i++) {
            if (Character.getNumericValue(text.charAt(i)) > 9) {
                countedLetters[Character.toUpperCase(Character.getNumericValue(text.charAt(i))) - Character.getNumericValue('A')]++;
            }
        }
      
        return countedLetters;
    }
}