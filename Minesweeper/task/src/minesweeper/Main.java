package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("How many mines do you want on the field? ");
        final Minesweeper minesweeper = new Minesweeper(scanner.nextInt());

        scanner.close();

        System.out.println(minesweeper.toString());
    }
}
