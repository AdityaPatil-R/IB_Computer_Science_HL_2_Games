import java.util.Scanner;

public class MorseCodeGame {
    private static MorseCodeNode morseCode = new MorseCodeNode("");
    private static Scanner scanner = new Scanner(System.in);

    public MorseCodeGame() {
        morseCode.dot = new MorseCodeNode("e");
        morseCode.dot.dot = new MorseCodeNode("i");
        morseCode.dot.dot.dot = new MorseCodeNode("s");
        morseCode.dot.dot.dot.dot = new MorseCodeNode("h");
        morseCode.dot.dot.dot.dot.dot = new MorseCodeNode("5");
        morseCode.dot.dot.dot.dot.dash = new MorseCodeNode("4");
        morseCode.dot.dot.dot.dash = new MorseCodeNode("v");
        morseCode.dot.dot.dot.dash.dash = new MorseCodeNode("3");
        morseCode.dot.dot.dash = new MorseCodeNode("u");
        morseCode.dot.dot.dash.dot = new MorseCodeNode("f");
        morseCode.dot.dot.dash.dash = new MorseCodeNode("");
        morseCode.dot.dot.dash.dash.dash = new MorseCodeNode("2");
        morseCode.dot.dash = new MorseCodeNode("a");
        morseCode.dot.dash.dot = new MorseCodeNode("r");
        morseCode.dot.dash.dot.dot = new MorseCodeNode("l");
        morseCode.dot.dash.dash = new MorseCodeNode("w");
        morseCode.dot.dash.dash.dot = new MorseCodeNode("p");
        morseCode.dot.dash.dash.dash = new MorseCodeNode("j");
        morseCode.dot.dash.dash.dash.dash = new MorseCodeNode("1");
        morseCode.dash = new MorseCodeNode("t");
        morseCode.dash.dot = new MorseCodeNode("n");
        morseCode.dash.dot.dot = new MorseCodeNode("d");
        morseCode.dash.dot.dot.dot = new MorseCodeNode("b");
        morseCode.dash.dot.dot.dot.dot = new MorseCodeNode("6");
        morseCode.dash.dot.dot.dash = new MorseCodeNode("x");
        morseCode.dash.dot.dash = new MorseCodeNode("k");
        morseCode.dash.dot.dash.dot = new MorseCodeNode("c");
        morseCode.dash.dot.dash.dash = new MorseCodeNode("y");
        morseCode.dash.dash = new MorseCodeNode("m");
        morseCode.dash.dash.dot = new MorseCodeNode("g");
        morseCode.dash.dash.dot.dot = new MorseCodeNode("z");
        morseCode.dash.dash.dot.dot.dot = new MorseCodeNode("7");
        morseCode.dash.dash.dot.dash = new MorseCodeNode("q");
        morseCode.dash.dash.dash = new MorseCodeNode("o");
        morseCode.dash.dash.dash.dot = new MorseCodeNode("");
        morseCode.dash.dash.dash.dot.dot = new MorseCodeNode("8");
        morseCode.dash.dash.dash.dash = new MorseCodeNode("");
        morseCode.dash.dash.dash.dash.dot = new MorseCodeNode("9");
        morseCode.dash.dash.dash.dash.dash = new MorseCodeNode("0");

        System.out.println("Type in any text in morse code, and this program will decode it for you.");

        String input = scanner.nextLine().toLowerCase();
        String output = "";

        String[] letters = input.split(" ");

        for (String letter : letters) {
            output += morseCode.decode(letter);
        }

        System.out.println(output);
    }
}