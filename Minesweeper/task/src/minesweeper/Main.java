package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("How many mines do you want on the field? ");
        final Minesweeper minesweeper = new Minesweeper(scanner.nextInt());

        System.out.println(minesweeper.toString());
        while (!minesweeper.checkIfWin()) {
            System.out.println("Set/delete mines marks (x and y coordinates):");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            minesweeper.guess(y - 1, x - 1);
            System.out.println(minesweeper.toString());
        }

        scanner.close();

        System.out.println("Congratulations! You found all mines!");
    }
}
