package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {
    private int width;
    private int height;
    private char[][] field;
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
        final char empty = '.';

        field = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(field[i], empty);
        }

        for (int i = 0; i < bombs; i++) {
            int j = random(0, height * width - i);
            int k = 0;
            int l = 0;
            while (k < j) {
                if (field[l / height][l % width] == empty) k++;

                if (l == height * width - 1) l = 0;
                else l++;
            }

            while (field[l / height][l % width] != empty) {
                if (l == height * width - 1) l = 0;
                else l++;
            }

            field[l / height][l % width] = 'X';
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
                ret.append(field[i][j]);
            }
            ret.append(newLine);
        }

        return ret.toString();
    }
}
