package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Minesweeper {
    private int width;
    private int height;
    private int[][][] field;
    private int bombs;
    private int vote;
    private final List<Integer[]> bombsArr = new ArrayList<>();

    public Minesweeper(int width, int height, int bombs) {
        this.width = width;
        this.height = height;
        this.bombs = bombs;
        this.vote = 0;

        createField();
    }

    public Minesweeper(int bombs) {
        this.height = 9;
        this.width = 9;
        this.bombs = bombs;
        this.vote = 0;

        createField();
    }

    public Minesweeper() {
        this.height = 9;
        this.width = 9;
        this.bombs = 10;
        this.vote = 0;

        createField();
    }

    public void createField() {
//        initialize
        field = new int[height][width][3]; // third directional: isBomb(1 - yes, 0 - no), how much around him, if was guessed(1 - yes, 0 - no))

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
            bombsArr.add(new Integer[]{l / height, l % width});
        }

//        calculate how much around bombs is
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (field[i][j][0] == 1) { // if its a bomb
                    field[i][j][1] = 0;
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

    public int guess(int x, int y) {
        System.out.println(x + "..." + y);
        if (field[x][y][1] > 0 && field[x][y][0] == 0) {
            return 1;
        }

        if (field[x][y][2] == 0) {
            field[x][y][2] = 1;
            vote++;
        } else {
            field[x][y][2] = 0;
            vote--;
        }

        return 0;
    }

    public boolean checkIfWin() {
        if (vote != bombs) return false;

        for (Integer[] bomb : bombsArr) {
            if (field[bomb[0]][bomb[1]][2] == 0) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        final String newLine = "\n";
        final String horizontalSeparator = "—";
        final String verticalSeparator = "|";
        final StringBuilder lineBreak = new StringBuilder(horizontalSeparator + verticalSeparator);

        final StringBuilder ret = new StringBuilder();

//        first Line
        ret.append(" " + verticalSeparator);
        for (int i = 0; i < width; i++) {
            ret.append(i + 1);
            lineBreak.append(horizontalSeparator);
        }ret.append(verticalSeparator + newLine);
        lineBreak.append(verticalSeparator + newLine);

//        break line
        ret.append(lineBreak);

//        actually field
        // third directional: [isBomb(1 - yes, 0 - no), how much around him, if was vote(1 - yes, 0 - no))]
        for (int i = 0; i < height; i++) {
            ret.append((i + 1) + verticalSeparator);
            for (int j = 0; j < width; j++) {
                ret.append(
                        field[i][j][2] == 1 ?
                                "*" :
                                (field[i][j][1] == 0 ? "." : String.valueOf(field[i][j][1]))
                );
//                ret.append(field[i][j][0] == 1 ?
//                        (field[i][j][1] == 0 ? "." : "*") :
//                        (field[i][j][1] == 0 ? "." : String.valueOf(field[i][j][1]))
//                );
            }
            ret.append(verticalSeparator + newLine);
        }

//        break line
        ret.append(lineBreak);

        return ret.toString();
    }
}
