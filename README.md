## Description of the problem

Winning at Bingo is all about filling consecutive cells as quickly as possible. But what if you wanted to stay in the game for as long as possible without winning? What is the maximum number of cells you can fill before you **have** to win? In this 5x6 version of the Bingo board, we want to find all the optimal configurations where no 4 consecutive cells in a row/column/diagonal can be filled while maximizing the number of filled cells. We will use 1's to represent filled cells and 0's to represent empty cells.

## Motivation for this program

It is always possible to generate 2<sup>30</sup> states of the board (since there are 5x6 cells) by using a brute-force algorithm and emilinating those that fail the constraints. However, this takes expotential run-time to the input size. To achieve polynomial run-time, we can employ a backtracking algorithm similar to one that can solve the N-Queen Problem in a similar fashion.

## Boot up instructions

Open your favorite Terminal and run these commands.

In the directory where you wish to store this project, clone it using Git:
```sh
$ git clone https://github.com/QobyKu/customized-bingo
```

To run the brute-force solver, cd into the project folder, type the following and wait for the program to run and print:
```sh
$ javac SolveByBruteForce.java
$ java SolveByBruteForce
```

To run the efficient solver, cd into the project folder, type the following and wait (not nearly as long!) for the program to run and print:
```sh
$ javac SolveByBackTracking.java
$ java SolveByBackTracking
```
