package com.si;

public class HetmanForwardChecking {
    private final int N;
    private int numberOfRecur;
    private int numberOfSolutions;
    private int numberOfReturns;

    private boolean columnControl[];
    private boolean rowControl[];
    private boolean board[][];

    public HetmanForwardChecking(int n) {
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

    private boolean isSafe(int row, int column) {
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

    public void go(){
        goRecoursive(0);
    }

    private boolean forwardChecking(int column) {
        boolean canGo;
        for (int col = column; col < N; col++) {
            canGo = false;
            for (int row = 0; row < N; row++) {
                if(isSafe(row, col)) {
                    canGo = true;
                }
            }
            if (!canGo) {
                return canGo;
            }
        }
        return true;
    }

    private void goRecoursive(int col) {
        numberOfRecur++;
        for (int row = 0; row < N; row++) {//Iterating over each row in column 'col'
            if(isSafe(row, col)){
                board[row][col] = true; //wstawia hetmana
                columnControl[row] = true; //zajmuje kolumnę
                rowControl[col] = true; //zajmuje wiersz

                if (col < (N - 1)) {
                    if (forwardChecking(col + 1))//DODATKOWY WARTUNEK DLA FC
                        goRecoursive(col + 1);
                }
                else {
                    numberOfSolutions++;
                    print();
                }

                //If no possible arrangement is found then backtrack and remove the quueen
                columnControl[row] = false;
                rowControl[col] = false;
                board[row][col] = false;
                numberOfReturns++;
            }
        }
    }

    public void print() {
        String matrix = "";
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[i].length; j++) {
                if(board[i][j]){
                    matrix += "1  ";
                }
                else {
                    matrix += "0  ";
                }
            }
            matrix += "\n";
        }
        System.out.println(matrix);
    }
}




