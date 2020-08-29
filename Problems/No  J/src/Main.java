import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> list = new ArrayList<>(List.of(array));
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (temp.charAt(0) != 'J') iterator.remove();
            else iterator.set(temp.substring(1));
        }

        Collections.reverse(list);
        for (String temp : list) {
            System.out.println(temp);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}