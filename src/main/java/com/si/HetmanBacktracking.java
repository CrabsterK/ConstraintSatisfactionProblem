package com.si;

public class HetmanBacktracking {
    private final int N;
    private int numberOfRecur;
    private int numberOfSolutions;
    private int numberOfReturns;

    private boolean columnControl[];
    private boolean rowControl[];
    private boolean board[][];


    public HetmanBacktracking(int n) {
        this.N = n;
        this.numberOfRecur = 0;
        this.numberOfSolutions = 0;
        this.numberOfReturns = 0;

        this.columnControl = new boolean[n];
        this.rowControl = new boolean[n];
        this.board = new boolean[n][n];
    }

    public int getNumberOfRecur() {
        return numberOfRecur;
    }

    public int getNumberOfSolutions() {
        return numberOfSolutions;
    }

    public int getNumberOfReturns() {
        return numberOfReturns;
    }

    public void go() {
        goRecoursive(0);
    }


    public boolean canPlaceHetman(int row, int column) {
        if(board[row][column]) { //position controll
            return false;
        }
        if(columnControl[row]){ //column controll
            return false;
        }
        if(rowControl[column]){ //row controll
            return false;
        }

        //diagonal controll
        for(int i = row-1, j = column-1; i >= 0 && j >= 0; i--, j--) {//NW
            if(board[i][j]) {
                return false;
            }
        }
        for(int i = row-1, j = column+1; i >= 0 && j < N; i--, j++) { //NE
            if(board[i][j]) {
                return false;
            }
        }
        for(int i = row+1, j = column-1; i < N && j >= 0; i++, j--) { //SW
            if(board[i][j]) {
                return false;
            }
        }
        for(int i = row+1, j = column+1; i < N && j < N; i++, j++) { //SE
            if(board[i][j]) {
                return false;
            }
        }
        return true;
    }


    private void goRecoursive(int column) {
        numberOfRecur++;
        for (int row = 0; row < N; row++) {
            if(canPlaceHetman(row, column)){
                board[row][column] = true; //wstawia hetmana
                columnControl[row] = true; //zajmuje kolumnę
                rowControl[column] = true; //zajmuje wiersz


                if (column < (N - 1)) {//jeśli mogę sprawdzić kolejną kolumnę
                    goRecoursive(column + 1);
                } else {
                    numberOfSolutions++;
                }


                //nawrót
                columnControl[row] = false;
                rowControl[column] = false;
                board[row][column] = false;
                numberOfReturns++;
            }
        }
    }
}