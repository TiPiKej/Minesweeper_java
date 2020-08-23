import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<List<Integer>> matrix = new ArrayList<>();

//        load matrix
        String temp;
        while (!(temp = scanner.nextLine()).equals("end")) {
            List<Integer> tempLine = new ArrayList<>();
            for (String nbrStr : temp.split(" ")) {
                tempLine.add(Integer.parseInt(nbrStr));
            }
            matrix.add(tempLine);
        }
        scanner.close();

//        copy matrix
        int[][] matrixCopy = new int[matrix.size()][];
        for (int i = 0; i < matrix.size(); i++) {
            int[] tempLine = new int[matrix.get(i).size()];
            matrixCopy[i] = tempLine;
        }

//        program
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int sum = 0;

//                left
                sum += matrix.get(i == 0 ?
                        Math.max(matrix.size() - 1, 0) :
                        i - 1
                ).get(j);

//                right
                sum += matrix.get(i == matrix.size() - 1 ?
                        0:
                        i + 1
                ).get(j);

//                up
                sum += matrix.get(i).get(j == 0 ?
                        Math.max(matrix.get(i).size() - 1, 0) :
                        Math.max(j - 1, 0)
                );

//                down
                sum += matrix.get(i).get(j == matrix.get(i).size() - 1 ?
                        0 :
                        j + 1
                );

                matrixCopy[i][j] = sum;
            }
        }


//        print matrix
        for (int[] line : matrixCopy) {
            for (int nbr : line) {
                System.out.printf("%d ", nbr);
            } System.out.println();
        }
    }
}