public class MorseCodeNode {
    public String value;
    public MorseCodeNode dot;
    public MorseCodeNode dash;

    public MorseCodeNode(String value) {
        this.value = value;
        dot = null;
        dash = null;
    }

    public String decode(String text) {
        if (text.length() > 0) {
            if (text.substring(0, 1).equals(".")) {
                return dot.decode(text.substring(1));
            } else if (text.substring(0, 1).equals("-")) {
                return dash.decode(text.substring(1));
            } else if (text.substring(0, 1).equals("/")) {
                return " ";
            }
        }

        return value;
    }
}