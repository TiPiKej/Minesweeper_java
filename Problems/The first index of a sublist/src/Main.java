import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<Integer> firstLine = new ArrayList<>();
        int nbr;

        String tempLine = scanner.nextLine();
        for (String temp : tempLine.split(" ")) {
            firstLine.add(Integer.parseInt(temp));
        }

        nbr = scanner.nextInt();

        scanner.close();

        System.out.printf("%d %d", firstLine.indexOf(nbr), firstLine.lastIndexOf(nbr));
    }
}