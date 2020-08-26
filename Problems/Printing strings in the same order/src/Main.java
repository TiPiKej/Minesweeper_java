import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String[] temp = scanner.nextLine().split("\\s");

            for (String word : temp) {
                System.out.println(word);
            }
        }

        scanner.close();
    }
}