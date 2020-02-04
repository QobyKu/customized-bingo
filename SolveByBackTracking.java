public class SolveByBackTracking {

    // Dimensions of Bingo board
    static int num_rows = 5;
    static int num_cols = 6;
    // Keeps track of number of solutions
    static int sol_counter = 1;

    // Driver code
    public static void main(String[] args) {
        solvePuzzle();
    }

    /*
     * This function solves the puzzle using Backtracking. It mainly uses
     * solvePuzzleUtil() to solve the problem.
     */
    static void solvePuzzle() {
        int[][] board = new int[num_rows][num_cols];

        if (!solvePuzzleUtil(board, 0, 0)) {
            System.out.print("Solution does not exist");
        }
    }

    /*
     * A recursive utility function to solve the puzzle
     */
    static boolean solvePuzzleUtil(int[][] board, int row, int col) {

        /* base case: If we have reached end of the board */
        if (col == num_cols) {
            printSolution(board);
            return true;
        }

        /*
         * Consider this column and try placing 1's in all rows one by one
         */
        boolean res = false;
        /*
         * Check if 1 can be placed on board[row][col]
         */
        while (row < num_rows) {
            if (isSafe(board, row, col)) {
                /* Place a 1 in board[i][col] */
                board[row][col] = 1;

                // Make result true if any placement is possible
                // Try the next row if we haven't reached the bottom
                if (row < num_rows - 1) {
                    res = solvePuzzleUtil(board, row + 1, col) || res;
                }
                // Try the next column if we have reached the bottom
                if (row == num_rows - 1) {
                    res = solvePuzzleUtil(board, 0, col + 1) || res;
                }

                /*
                 * If placing 1 in board[row][col] doesn't lead to a solution, then remove 1
                 * from board[row][col]
                 */
                board[row][col] = 0; // BACKTRACK
            }

            // Move to the next column
            if (row == num_rows - 1) {
                res = solvePuzzleUtil(board, 0, col + 1) || res;
            }

            row++;

        }

        /*
         * If a 1 can not be place in any row in this column then return false
         */
        return res;
    }

    /*
     * A utility function to check if a 1 can be placed on board[row][col].
     */
    static boolean isSafe(int[][] board, int row, int col) {
        if (col == 0) {
            if (row == 0) {
                // check diagonally to bottom right
                if (sumBottomRight(board, row, col) == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally to bottom right
                if (sumBottomRight(board, row, col) == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally to top right
                if (sumTopRight(board, row, col) == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3
                        || board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally to top right
                if (sumTopRight(board, row, col) == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
            }
        } else if (col == 1) {
            if (row == 0) {
                // check diagonally bottom right
                if (sumBottomRight(board, row, col) == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally top right
                if (sumTopRight(board, row, col) == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check diagonally
                if (board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3
                        || board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3
                        || board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally bottom right
                if (sumBottomRight(board, row, col) == 3) {
                    return false;
                }
                // check the other diagonal
                if (board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row + 2][col] + board[row - 1][col] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally top right
                if (sumTopRight(board, row, col) == 3) {
                    return false;
                }
                // check other diagonal
                if (board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
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
                if (sumBottomRight(board, row, col) == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check horizontally right
                if (sumBottomRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3
                        || board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally top right
                if (sumTopRight(board, row, col) == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3
                        || board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check diagonally
                if (board[row - 2][col - 2] + board[row - 1][col - 1] + board[row + 1][col + 1] == 3
                        || board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3
                        || board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3
                        || board[row + 2][col - 2] + board[row + 1][col - 1] + board[row - 1][col + 1] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3
                        || board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3
                        || board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally top right
                if (sumTopRight(board, row, col) == 3) {
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
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3
                        || board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally bottom right
                if (sumBottomRight(board, row, col) == 3) {
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
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally right
                if (sumHorizontalRight(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col - 2] + board[row][col - 1] + board[row][col + 1] == 3
                        || board[row][col - 1] + board[row][col + 1] + board[row][col + 2] == 3) {
                    return false;
                }
            }
        } else if (col == 3) {
            if (row == 0) {
                // check diagonally bottom left
                if (sumBottomLeft(board, row, col) == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3
                        || board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally top left
                if (sumTopLeft(board, row, col) == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3
                        || board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check diagonally
                if (board[row + 2][col - 2] + board[row + 1][col - 1] + board[row - 1][col + 1] == 3
                        || board[row + 1][col - 1] + board[row - 1][col + 1] + board[row - 2][col + 2] == 3
                        || board[row - 2][col - 2] + board[row - 1][col - 1] + board[row + 1][col + 1] == 3
                        || board[row - 1][col - 1] + board[row + 1][col + 1] + board[row + 2][col + 2] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3
                        || board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3
                        || board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally top left
                if (sumTopLeft(board, row, col) == 3) {
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
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3
                        || board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally bottom left
                if (sumBottomLeft(board, row, col) == 3) {
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
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3
                        || board[row][col + 1] + board[row][col + 2] + board[row][col - 1] == 3) {
                    return false;
                }
            }
        } else if (col == 4) {
            if (row == 0) {
                // check diagonally bottom left
                if (sumBottomLeft(board, row, col) == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally top left
                if (sumTopLeft(board, row, col) == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check diagonally
                if (board[row - 1][col + 1] + board[row + 1][col - 1] + board[row + 2][col - 2] == 3
                        || board[row - 2][col - 2] + board[row - 1][col - 1] + board[row + 1][col + 1] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3
                        || board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally bottom left
                if (sumBottomLeft(board, row, col) == 3) {
                    return false;
                }
                // check the other diagonal
                if (board[row - 1][col + 1] + board[row + 1][col - 1] + board[row + 2][col - 2] == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row + 2][col] + board[row - 1][col] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
                // check other horizontal
                if (board[row][col + 1] + board[row][col - 1] + board[row][col - 2] == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally top left
                if (sumTopLeft(board, row, col) == 3) {
                    return false;
                }
                // check other diagonal
                if (board[row + 1][col + 1] + board[row - 1][col - 1] + board[row - 2][col - 2] == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
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
                if (sumBottomLeft(board, row, col) == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
            } else if (row == 4) {
                // check diagonally to top left
                if (sumTopLeft(board, row, col) == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
            } else if (row == 3) {
                // check diagonally to top left
                if (sumTopLeft(board, row, col) == 3) {
                    return false;
                }
                // check vertically up
                if (sumVerticalUp(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row + 1][col] + board[row - 1][col] + board[row - 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
            } else if (row == 2) {
                // check vertically
                if (board[row - 2][col] + board[row - 1][col] + board[row + 1][col] == 3
                        || board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
            } else if (row == 1) {
                // check diagonally to bottom left
                if (sumBottomLeft(board, row, col) == 3) {
                    return false;
                }
                // check vertically down
                if (sumVerticalDown(board, row, col) == 3) {
                    return false;
                }
                // check other vertical
                if (board[row - 1][col] + board[row + 1][col] + board[row + 2][col] == 3) {
                    return false;
                }
                // check horizontally left
                if (sumHorizontalLeft(board, row, col) == 3) {
                    return false;
                }
            }
        }
        return true;
    }

    /* A utility function to sum the 3 cells diagonally to bottom right. */
    static int sumBottomRight(int[][] board, int row, int col) {
        int sum = 0;

        for (int i = row + 1, j = col + 1; i <= row + 3 && j <= col + 3; i++, j++) {
            sum += board[i][j];
        }
        return sum;
    }

    /* A utility function to sum the 3 cells diagonally to bottom left. */
    static int sumBottomLeft(int[][] board, int row, int col) {
        int sum = 0;

        for (int i = row + 1, j = col - 1; i <= row + 3 && j >= col - 3; i++, j--) {
            sum += board[i][j];
        }
        return sum;
    }

    /* A utility function to sum the 3 cells diagonally to top right. */
    static int sumTopRight(int[][] board, int row, int col) {
        int sum = 0;

        for (int i = row - 1, j = col + 1; i >= row - 3 && j <= col + 3; i--, j++) {
            sum += board[i][j];
        }
        return sum;
    }

    /* A utility function to sum the 3 cells diagonally to top left. */
    static int sumTopLeft(int[][] board, int row, int col) {
        int sum = 0;

        for (int i = row - 1, j = col - 1; i >= row - 3 && j >= col - 3; i--, j--) {
            sum += board[i][j];
        }
        return sum;
    }

    /* A utility function to sum the 3 cells vertically down. */
    static int sumVerticalDown(int[][] board, int row, int col) {
        int sum = 0;

        for (int i = row + 1; i <= row + 3; i++) {
            sum += board[i][col];
        }
        return sum;
    }

    /* A utility function to sum the 3 cells vertically up. */
    static int sumVerticalUp(int[][] board, int row, int col) {
        int sum = 0;

        for (int i = row - 1; i >= row - 3; i--) {
            sum += board[i][col];
        }
        return sum;
    }

    /* A utility function to sum the 3 cells horizontally right. */
    static int sumHorizontalRight(int[][] board, int row, int col) {
        int sum = 0;

        for (int i = col + 1; i <= col + 3; i++) {
            sum += board[row][i];
        }
        return sum;
    }

    /* A utility function to sum the 3 cells horizontally left. */
    static int sumHorizontalLeft(int[][] board, int row, int col) {
        int sum = 0;

        for (int i = col - 1; i >= col - 3; i--) {
            sum += board[row][i];
        }
        return sum;
    }

    /* A utility function to print solution */
    static void printSolution(int[][] board) {
        int sum_board = 0;

        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                sum_board += board[i][j];
            }
        }

        // Maximum number of 1's in an optimal solution is 22
        if (sum_board == 22) {
            System.out.printf("%d-\n", sol_counter++);
            for (int i = 0; i < num_rows; i++) {
                for (int j = 0; j < num_cols; j++)
                    System.out.printf(" %d ", board[i][j]);
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
}