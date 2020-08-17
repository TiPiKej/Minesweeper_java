package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {
    private int width;
    private int height;
    private int[][][] field;
    private int bombs;

    public Minesweeper(int width, int height, int bombs) {
        this.width = width;
        this.height = height;
        this.bombs = bombs;

        createField();
    }

    public Minesweeper(int bombs) {
        this.height = 9;
        this.width = 9;
        this.bombs = bombs;

        createField();
    }

    public Minesweeper() {
        this.height = 9;
        this.width = 9;
        this.bombs = 10;

        createField();
    }

    public void createField() {
//        initialize
        field = new int[height][width][2]; // third directional: isBomb(1 - yes, 0 - no), how much around him
//        for (int i = 0; i < height; i++) {
//            Arrays.fill(field[i], new String[2]);
//        }

//        fill with bombs
        for (int i = 0; i < bombs; i++) {
            int j = random(0, height * width - i);
            int k = 0;
            int l = 0;
            while (k < j) {
                if (field[l / height][l % width][0] == 0) k++;

                if (l == height * width - 1) l = 0;
                else l++;
            }

            while (field[l / height][l % width][0] == 1) {
                if (l == height * width - 1) l = 0;
                else l++;
            }

            field[l / height][l % width][0] = 1;
        }

//        calculate how much around bombs is
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (field[i][j][0] == 1) { // if its a bomb
                    field[i][j][1] = -1;
                    continue;
                }
                int count = 0;

//              ******************
//                checking sides
//              ******************

//                top
                if (i != 0) if (field[i - 1][j][0] == 1) count++;
//                left
                if (j != 0) if (field[i][j - 1][0] == 1) count++;
//                down
                if (i != height - 1) if (field[i + 1][j][0] == 1) count++;
//                right
                if (j != width - 1) if (field[i][j + 1][0] == 1) count++;

//                top-left
                if (i != 0 && j != 0) if (field[i - 1][j - 1][0] == 1) count++;
//                top-right
                if (i != 0 && j != width - 1) if (field[i - 1][j + 1][0] == 1) count++;
//                down-left
                if (i != height - 1 && j != 0) if (field[i + 1][j - 1][0] == 1) count++;
//                down-right
                if (i != height - 1 && j != width - 1) if (field[i + 1][j + 1][0] == 1) count++;

                field[i][j][1] = count;
            }
        }
    }

    private int random(int start, int end) {
        Random gen = new Random();
        return gen.nextInt(end - start + 1) + start;
    }

    @Override
    public String toString() {
        final String newLine = "\n";

        final StringBuilder ret = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ret.append(field[i][j][0] == 1 ? "X" :
                        (field[i][j][1] == 0 ? "." : String.valueOf(field[i][j][1]))
                );
            }
            ret.append(newLine);
        }

        return ret.toString();
    }
}
