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

    private boolean isSafe(int row, int column) {
/*
 //TO OPISAC JAKO HEURYSTYKE. ZASTĄPIONE TYMI DWOMA NIZEJ
        for (int i = 0; i < column; i++) {
            if (board[row][i]) {
                return false;
            }
        }*/
        if(columnControl[row]){ //column controll
            return false;
        }
        if(rowControl[column]){ //row controll
            return false;
        }
        //left diagonal controll
        for(int i = row-1, j = column-1; i >= 0 && j >= 0; i--, j--) {//NW
            if(board[i][j]) {
                return false;
            }
        }
        for(int i = row+1, j = column-1; i < N && j >= 0; i++, j--) { //SW
            if(board[i][j]) {
                return false;
            }
        }
        return true;
    }

    public void go(){
        goRecoursive(0);
    }

    private void goRecoursive(int col) {
        numberOfRecur++;
        if (col >= N) {
            //print();
            numberOfSolutions++;
        }
        for (int row = 0; row < N; row++){//Iterating over each row in column 'col'
            if (isSafe(row, col)) {
                board[row][col] = true; //wstawia hetmana
                columnControl[row] = true; //zajmuje kolumnę
                rowControl[col] = true; //zajmuje wiersz

                goRecoursive(col + 1 );

                //If no possible arrangement is found then backtrack and remove the quueen
                columnControl[row] = false;
                rowControl[col] = false;
                board[row][col] = false;
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