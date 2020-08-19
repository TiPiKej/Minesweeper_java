import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String nbrStr = scanner.nextLine();
        scanner.close();

        System.out.println(stringToNumber(nbrStr));
    }

    private static int stringToNumber(String str) {
        switch (str.toLowerCase()) {
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            case "zero": return 0;
        }

        return -1;
    }
}