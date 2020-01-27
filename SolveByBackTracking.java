public class SolveByBackTracking {

    static int k = 1;

    /* A utility function to print solution */
    static void printSolution(int board[][]) {
        int sum_board = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                sum_board += board[i][j];
            }
        }

        // Maximum number of 1's in an optimal solution is 22
        if (sum_board == 22) {
            System.out.printf("%d-\n", k++);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++)
                    System.out.printf(" %d ", board[i][j]);
                System.out.printf("\n");
            }
            System.out.printf("\n");
        }
    }

    /* This function solves the puzzle using
    Backtracking. It mainly uses solvePuzzleUtil() to
    solve the problem.*/
    static void solvePuzzle() {
        int board[][] = new int[5][6];

        if (solvePuzzleUtil(board, 0, 0) == false) {
            System.out.printf("Solution does not exist");
            return;
        }

        return;
    }

    /* A recursive utility function
    to solve the puzzle */
    static boolean solvePuzzleUtil(int board[][], int row, int col) {

        /* base case: If we have reached end of the board */
        if (col == 6) {
            printSolution(board);
            return true;
        }

    /* Consider this column and try placing
    1's in all rows one by one */
        boolean res = false;
        /* Check if 1 can be placed on
        board[row][col] */
        while (row < 5) {

            if (isSafe(board, row, col)) {
                /* Place a 1 in board[i][col] */
                board[row][col] = 1;

                // Make result true if any placement
                // is possible
                if (row < 4) {
                    res = solvePuzzleUtil(board, row + 1, col) || res;

                }

                if (row == 4) {
                    res = solvePuzzleUtil(board, 0, col + 1) || res;
                }

            /* If placing 1 in board[row][col]
            doesn't lead to a solution, then
            remove 1 from board[row][col] */
                board[row][col] = 0; // BACKTRACK
            }

            if (row == 4) {
                res = solvePuzzleUtil(board, 0, col + 1) || res;
            }

            row++;

        }

    /* If a 1 can not be place in any row in
        this column then return false */
        return res;
    }


    /* A utility function to check if a 1 can
    be placed on board[row][col]. */
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;
        int k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14, k15, k16, k17, k18, k19, k20, k21, k22, k23,
            k24, k25, k26, k27, k28, k29, k30, k31, k32, k33, k34, k35, k36, k37, k38, k39, k40, k41, k42, k43, k44,
            k45, k46, k47, k48, k49, k50, k51, k52, k53, k54, k55, k56, k57, k58, k59, k60, k61, k62, k63, k64, k65,
            k66, k67, k68, k69, k70, k71, k72, k73, k74, k75, k76, k77, k78;

        k1 = k2 = k3 = k4 = k5 = k6 = k7 = k8 = k9 = k10 = k11 = k12 = k13 = k14 = k15 = k16 = k17 = k18 = k19 = k20 =
        k21 = k22 = k23 = k24 = k25 = k26 = k27 = k28 = k29 = k30 = k31 = k32 = k33 = k34 = k35 = k36 = k37 = k38 = 
        k39 = k40 = k41 = k42 = k43 = k44 = k45 = k46 = k47 = k48 = k49 = k50 = k51 = k52 = k53 = k54 = k55 = k56 = 
        k57 = k58 = k59 = k60 = k61 = k62 = k63 = k64 = k65 = k66 = k67 = k68 = k69 = k70 = k71 = k72 = k73 = k74 = 
        k75 = k76 = k77 = k78 = 0;

        if (col == 0) {
            if (row == 0) {
                // check diagonally to bottom right
                for (i = row + 1, j = col + 1; i <= row + 3 && j <= col + 3; i++, j++) {
                    k1 += board[i][j];
                }
                if (k1 == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k2 += board[i][col];
                }
                if (k2 == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k3 += board[row][i];
                }
                if (k3 == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally to bottom right
                for (i = row + 1, j = col + 1; i <= row + 3 && j <= col + 3; i++, j++) {
                    k4 += board[i][j];
                }
                if (k4 == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k5 += board[i][col];
                }
                if (k5 == 3) {
                    return false;
                }
                //check other vertical
                if (board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k6 += board[row][i];
                }
                if (k6 == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally to top right
                for (i = row - 1, j = col + 1; i >= row - 3 && j <= col + 3; i--, j++) {
                    k7 += board[i][j];
                }
                if (k7 == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k8 += board[i][col];
                }
                if (k8 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k9 += board[row][i];
                }
                if (k9 == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3 ||
                        board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k10 += board[row][i];
                }
                if (k10 == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally to top right
                for (i = row - 1, j = col + 1; i >= row - 3 && j <= col + 3; i--, j++) {
                    k11 += board[i][j];
                }
                if (k11 == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k12 += board[i][col];
                }
                if (k12 == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k13 += board[row][i];
                }
                if (k13 == 3) {
                    return false;
                }
            }
        } else if (col == 1) {
            if (row == 0) {
                // check diagonally bottom right
                for (i = row + 1, j = col + 1; i <= row + 3 && j <= col + 3; i++, j++) {
                    k14 += board[i][j];
                }
                if (k14 == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k15 += board[i][col];
                }
                if (k15 == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k16 += board[row][i];
                }
                if (k16 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally top right
                for (i = row - 1, j = col + 1; i >= row - 3 && j <= col + 3; i--, j++) {
                    k17 += board[i][j];
                }
                if (k17 == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k18 += board[i][col];
                }
                if (k18 == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k19 += board[row][i];
                }
                if (k19 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check diagonally
                if (board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3 ||
                        board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k20 += board[row][i];
                }
                if (k20 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3 ||
                        board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally bottom right
                for (i = row + 1, j = col + 1; i <= row + 3 && j <= col + 3; i++, j++) {
                    k21 += board[i][j];
                }
                if (k21 == 3) {
                    return false;
                }
                // check the other diagonal
                if (board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k22 += board[i][col];
                }
                if (k22 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row + 2][col] + board[row - 1][col] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k23 += board[row][i];
                }
                if (k23 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally top right
                for (i = row - 1, j = col + 1; i >= row - 3 && j <= col + 3; i--, j++) {
                    k24 += board[i][j];
                }
                if (k24 == 3) {
                    return false;
                }
                // check other diagonal
                if (board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k25 += board[i][col];
                }
                if (k25 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k26 += board[row][i];
                }
                if (k26 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            }
        } else if (col == 2) {
            if (row == 0) {
                // check diagonally bottom right
                for (i = row + 1, j = col + 1; i <= row + 3 && j <= col + 3; i++, j++) {
                    k27 += board[i][j];
                }
                if (k27 == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k28 += board[i][col];
                }
                if (k28 == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i < col + 3; i++) {
                    k29 += board[row][i];
                }
                if (k29 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3 ||
                        board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally top right
                for (i = row - 1, j = col + 1; i >= row - 3 && j <= col + 3; i--, j++) {
                    k30 += board[i][j];
                }
                if (k30 == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k31 += board[i][col];
                }
                if (k31 == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k32 += board[row][i];
                }
                if (k32 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3 ||
                        board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check diagonally
                if (board[row - 2][col - 2] + board[row - 1][col - 1] + board[row + 1][col + 1] == 3 ||
                        board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3 ||
                        board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3 ||
                        board[row + 2][col - 2] + board[row + 1][col - 1] + board[row - 1][col + 1] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k33 += board[row][i];
                }
                if (k33 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3 ||
                        board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3 ||
                        board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally top right
                for (i = row - 1, j = col + 1; i >= row - 3 && j <= col + 3; i--, j++) {
                    k34 += board[i][j];
                }
                if (k34 == 3) {
                    return false;
                }
                // check 2nd diagonal
                if (board[row - 2][col - 2] + board[row - 1][col - 1] + board[row + 1][col + 1] == 3) {
                    return false;
                }
                // check 3rd diagonal
                if (board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k35 += board[i][col];
                }
                if (k35 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k36 += board[row][i];
                }
                if (k36 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3 ||
                        board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally bottom right
                for (i = row + 1, j = col + 1; i <= row + 3 && j <= col + 3; i++, j++) {
                    k37 += board[i][j];
                }
                if (k37 == 3) {
                    return false;
                }
                // check 2nd diagonal
                if (board[row - 1][col + 1] + board[row + 1][col - 1] + board[row + 2][col - 2] == 3) {
                    return false;
                }
                // check 3rd diagonal
                if (board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k38 += board[i][col];
                }
                if (k38 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                for (i = col + 1; i <= col + 3; i++) {
                    k39 += board[row][i];
                }
                if (k39 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3 ||
                        board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            }
        } else if (col == 3) {
            if (row == 0) {
                // check diagonally bottom left
                for (i = row + 1, j = col - 1; i <= row + 3 && j >= col - 3; i++, j--) {
                    k40 += board[i][j];
                }
                if (k40 == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i < row + 3; i++) {
                    k41 += board[i][col];
                }
                if (k41 == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col + 1; i >= col - 3; i--) {
                    k42 += board[row][i];
                }
                if (k42 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3 ||
                        board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally top left
                for (i = row - 1, j = col - 1; i >= row - 3 && j >= col - 3; i--, j--) {
                    k43 += board[i][j];
                }
                if (k43 == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k44 += board[i][col];
                }
                if (k44 == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col + 1; i >= col - 3; i--) {
                    k45 += board[row][i];
                }
                if (k45 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3 ||
                        board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check diagonally
                if (board[row + 2][col - 2] + board[row + 1][col - 1] + board[row - 1][col + 1] == 3 ||
                        board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3 ||
                        board[row - 2][col - 2] + board[row - 1][col - 1] + board[row + 1][col + 1] == 3 ||
                        board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k46 += board[row][i];
                }
                if (k46 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3 ||
                        board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3 ||
                        board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally top left
                for (i = row - 1, j = col - 1; i >= row - 3 && j >= col - 3; i--, j--) {
                    k47 += board[i][j];
                }
                if (k47 == 3) {
                    return false;
                }
                // check 2nd diagonal
                if (board[row - 2][col - 2] + board[row - 1][col - 1] + board[row + 1][col + 1] == 3) {
                    return false;
                }
                // check 3rd diagonal
                if (board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k48 += board[i][col];
                }
                if (k48 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k49 += board[row][i];
                }
                if (k49 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3 ||
                        board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally bottom left
                for (i = row + 1, j = col - 1; i <= row + 3 && j >= col - 3; i++, j--) {
                    k50 += board[i][j];
                }
                if (k50 == 3) {
                    return false;
                }
                // check 2nd diagonal
                if (board[row - 1][col + 1] + board[row + 1][col - 1] + board[row + 2][col - 2] == 3) {
                    return false;
                }
                // check 3rd diagonal
                if (board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k51 += board[i][col];
                }
                if (k51 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k52 += board[row][i];
                }
                if (k52 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3 ||
                        board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
            }
        } else if (col == 4) {
            if (row == 0) {
                // check diagonally bottom left
                for (i = row + 1, j = col - 1; i <= row + 3 && j >= col - 3; i++, j--) {
                    k53 += board[i][j];
                }
                if (k53 == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k54 += board[i][col];
                }
                if (k54 == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k55 += board[row][i];
                }
                if (k55 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally top left
                for (i = row - 1, j = col - 1; i >= row - 3 && j >= col - 3; i--, j--) {
                    k56 += board[i][j];
                }
                if (k56 == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k57 += board[i][col];
                }
                if (k57 == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k58 += board[row][i];
                }
                if (k58 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check diagonally
                if (board[row - 1][col + 1] + board[row + 1][col - 1] + board[row + 2][col - 2] == 3 ||
                        board[row - 2][col - 2] + board[row - 1][col - 1] + board[row + 1][col + 1] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k59 += board[row][i];
                }
                if (k59 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3 ||
                        board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally bottom left
                for (i = row + 1, j = col - 1; i <= row + 3 && j >= col - 3; i++, j--) {
                    k60 += board[i][j];
                }
                if (k60 == 3) {
                    return false;
                }
                // check the other diagonal
                if (board[row - 1][col + 1] + board[row + 1][col - 1] + board[row + 2][col - 2] == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k61 += board[i][col];
                }
                if (k61 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row + 2][col] + board[row - 1][col] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k62 += board[row][i];
                }
                if (k62 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally top left
                for (i = row - 1, j = col - 1; i >= row - 3 && j >= col - 3; i--, j--) {
                    k63 += board[i][j];
                }
                if (k63 == 3) {
                    return false;
                }
                // check other diagonal
                if (board[row + 1][col + 1] + board[row - 1][col - 1] + board[row - 2][col - 2] == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k64 += board[i][col];
                }
                if (k64 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k65 += board[row][i];
                }
                if (k65 == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
            }
        } else if (col == 5) {
            if (row == 0) {
                // check diagonally to bottom left
                for (i = row + 1, j = col - 1; i <= row + 3 && j >= col - 3; i++, j--) {
                    k66 += board[i][j];
                }
                if (k66 == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k67 += board[i][col];
                }
                if (k67 == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k68 += board[row][i];
                }
                if (k68 == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally to top left
                for (i = row - 1, j = col - 1; i >= row - 3 && j >= col - 3; i--, j--) {
                    k69 += board[i][j];
                }
                if (k69 == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k70 += board[i][col];
                }
                if (k70 == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k71 += board[row][i];
                }
                if (k71 == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally to top left
                for (i = row - 1, j = col - 1; i >= row - 3 && j >= col - 3; i--, j--) {
                    k72 += board[i][j];
                }
                if (k72 == 3) {
                    return false;
                }
                // check vertically up
                for (i = row - 1; i >= row - 3; i--) {
                    k73 += board[i][col];
                }
                if (k73 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k74 += board[row][i];
                }
                if (k74 == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3 ||
                        board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k75 += board[row][i];
                }
                if (k75 == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally to bottom left
                for (i = row + 1, j = col - 1; i <= row + 3 && j >= col - 3; i++, j--) {
                    k76 += board[i][j];
                }
                if (k76 == 3) {
                    return false;
                }
                // check vertically down
                for (i = row + 1; i <= row + 3; i++) {
                    k77 += board[i][col];
                }
                if (k77 == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                for (i = col - 1; i >= col - 3; i--) {
                    k78 += board[row][i];
                }
                if (k78 == 3) {
                    return false;
                }
            }
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        solvePuzzle();
    }
}