import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Deque<Character> stack = new ArrayDeque<>();
        final Scanner scanner = new Scanner(System.in);
        final char[] chars = scanner.nextLine().toCharArray();

        boolean isBalanced = true;
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.offerLast(c);
                continue;
            }

            if (stack.size() == 0) {
                isBalanced = false;
                break;
            }

            char temp = stack.pollLast();

            if (c == ')') isBalanced = temp == '(';
            else if (c == '}') isBalanced = temp == '{';
            else if (c == ']') isBalanced = temp == '[';

            if (!isBalanced) break;
        }

        if (stack.size() != 0) isBalanced = false;

        scanner.close();

        System.out.println(isBalanced);
    }
}