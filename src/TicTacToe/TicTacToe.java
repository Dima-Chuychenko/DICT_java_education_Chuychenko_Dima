package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static char[][] matrix = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    static char step = 'X';

    public static void main(String[] args) {
        System.out.println("PLAYING FIELD");
        board();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHINTS: enter coordinates separated by a \"space\"\n");
            System.out.print(step + " Enter the coordinates:");
            String[] coordinateInput = scanner.nextLine().split(" ", 2);

            while (coordinateInput.length != 2) {
                System.out.print(" " + step + " Enter the coordinates:");
                coordinateInput = scanner.nextLine().split(" ", 2);
            }

            if (!coordinateInput[0].matches("\\d+") || !coordinateInput[1].matches("\\d+")) {
                System.out.println("You should enter numbers!");
                System.out.print(step + " Enter the coordinates:");
                continue;
            }

            int x = Integer.parseInt(coordinateInput[0]) - 1;
            int y = Integer.parseInt(coordinateInput[1]) - 1;

            if (!(x >= 0 && x < 3 && y >= 0 && y < 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (matrix[x][y] != '-') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            matrix[x][y] = step;
            board();

            if (checkWin()) {
                System.out.println(step + " wins");
                break;
            }

            if (checkDraw()) {
                System.out.println("Draw");
                break;
            }

            step = (step == 'X') ? 'O' : 'X';
        }
    }

    static void board() {
        System.out.println("_____");
        for (char[] row : matrix) {
            System.out.println("|" + row[0] + row[1] + row[2] + "|");
        }
        System.out.println("_____");
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] + matrix[i][1] + matrix[i][2] == step * 3 ||
                    matrix[0][i] + matrix[1][i] + matrix[2][i] == step * 3) {
                return true;
            }
        }

        return matrix[0][0] + matrix[1][1] + matrix[2][2] == step * 3 ||
                matrix[0][2] + matrix[1][1] + matrix[2][0] == step * 3;
    }

    static boolean checkDraw() {
        for (char[] row : matrix) {
            for (char cell : row) {
                if (cell == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
