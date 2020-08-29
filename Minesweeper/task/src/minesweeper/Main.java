package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("How many mines do you want on the field? ");
        final Minesweeper minesweeper = new Minesweeper(Integer.parseInt(scanner.nextLine()));

        System.out.println(minesweeper.toString());
        boolean win = true;
        while (!minesweeper.checkIfEnd()) {
            System.out.println("Set/unset mines marks or claim a cell as free:");
            String[] line = scanner.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int mode = 0;
            switch (line[2]) {
                case "free":
                    mode = 1;
                    break;
                case "mine":
                    mode = 2;
                    break;
            }

            if (minesweeper.guess(y - 1, x - 1, mode) == 1) {
                System.out.println(minesweeper.toString());
                System.out.println("You stepped on a mine and failed!");
                win = false;
            } else System.out.println(minesweeper.toString());
        }

        scanner.close();

        if (win) System.out.println("Congratulations! You found all mines!");
    }
}
