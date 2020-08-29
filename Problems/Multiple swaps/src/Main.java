import java.util.*;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<Integer> list = new ArrayList<>();
        String tempLine = scanner.nextLine();
        for (String temp : tempLine.split(" ")) {
            list.add(Integer.parseInt(temp));
        }

        int nbrOfSwaps = scanner.nextInt();

        for (int i = 0; i < nbrOfSwaps; i++) {
            Collections.swap(list, scanner.nextInt(), scanner.nextInt());
        }

        scanner.close();

        for (int x : list) {
            System.out.printf("%d ", x);
        }
    }
}