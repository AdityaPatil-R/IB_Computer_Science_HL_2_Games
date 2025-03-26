import java.util.Scanner;

public class QuestionGame {
    private static Scanner scanner = new Scanner(System.in);
    private static QuestionNode questionTree = new QuestionNode("a toy");
    private static int guessNumber = 0;

    public QuestionGame() {
        System.out.println("Welcome to 20 Questions!");

        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.println("");
            }

            System.out.println("Think of an object and I'll try to guess it by asking 20 or less yes-or-no questions.");

            playGame(questionTree);

            System.out.print("Do you want to play \"20 Questions\" again?     ");
            String answer = scanner.nextLine();

            if (answer.equals("no")) {
                break;
            } else {
                guessNumber = 0;
            }
        }

        System.out.println("My brain has been reset to zero. Thanks for playing!");
    }

    private static void playGame(QuestionNode tree) {
        System.out.println("");

        if (guessNumber > 20) {
            System.out.print("I've exceeded my 20 alloted guesses, and have lost! That was fun! Do you want to play with me again?     ");
            String playAgain = scanner.nextLine();

            if (playAgain.equals("yes")) {
                new QuestionGame();
            } else {
                return;
            }
        }

        if (tree.yes == null && tree.no == null) {
            System.out.print("Is it " + tree.object + "?     ");
            guessNumber++;

            String answer = scanner.nextLine();

            if (answer.equals("yes")) {
                System.out.println("I win!");
            } else {
                guessNumber++;

                System.out.print("I give up. What is it?     ");
                String correctAnswer = scanner.nextLine();

                System.out.print("Write a yes-or-no question that would clearly distinguish " + tree.object + " from " + correctAnswer + ":     ");
                String newQuestion = scanner.nextLine();

                System.out.print("If the object was " + correctAnswer + ", what would the answer to \"" + newQuestion + "\" be?     ");
                String newAnswer = scanner.nextLine();

                if (newAnswer.equals("yes")) {
                    tree.yes = new QuestionNode(correctAnswer);
                    tree.no = new QuestionNode(tree.object);
                } else {
                    tree.yes = new QuestionNode(tree.object);
                    tree.no = new QuestionNode(correctAnswer);
                }

                tree.object = newQuestion;
                System.out.println("Thanks! I'll remember that for next time we play.");
            }
        } else {
            System.out.print(tree.object + "     ");
            String answer = scanner.nextLine();

            if (answer.equals("yes")) {
                playGame(tree.yes);
            } else {
                playGame(tree.no);
            }
        }
    }
}