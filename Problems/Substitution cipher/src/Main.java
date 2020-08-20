import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Map<Character, Character> keyA = new HashMap<>();
        final Map<Character, Character> keyB = new HashMap<>();

        final char[] tempKeys = scanner.nextLine().toCharArray();
        final char[] tempKeysValue = scanner.nextLine().toCharArray();

        for (int i = 0; i < tempKeys.length; i++) {
            keyA.put(tempKeys[i], tempKeysValue[i]);
            keyB.put(tempKeysValue[i], tempKeys[i]);
        }

        final char[] decodeLineA = scanner.nextLine().toCharArray();
        final char[] decodeLineB = scanner.nextLine().toCharArray();

        scanner.close();

        for (char lineA : decodeLineA) {
            System.out.print(keyA.get(lineA));
        } System.out.println();

        for (char lineB : decodeLineB) {
            System.out.print(keyB.get(lineB));
        } System.out.println();
    }
}