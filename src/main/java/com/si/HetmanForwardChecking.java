package com.si;

import java.util.ArrayList;

public class HetmanForwardChecking {
    private final int N;
    private int numberOfRecur;
    private int numberOfSolutions;
    private int numberOfReturns;

    private boolean columnControl[];
    private boolean rowControl[];
    private boolean board[][];
    ArrayList<Integer> domainList;

    public HetmanForwardChecking(int n) {
        this.N = n;
        this.numberOfRecur = 0;
        this.numberOfSolutions = 0;
        this.numberOfReturns = 0;

        this.columnControl = new boolean[n];
        this.rowControl = new boolean[n];
        this.board = new boolean[n][n];
        domainList = new ArrayList<>(n);
        for (int i = 0; i < N; i++) {
            domainList.add(i);
        }
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
        if (column >= N) {
            return true;
        }
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

    private ArrayList<Integer> getDomain(int col) {
        ArrayList<Integer> domainList = new ArrayList<Integer>(N);
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                domainList.add(i);
            }
        }
        return domainList;
    }

    public void go(){
        goRecoursive(0, domainList);
    }

    private void goRecoursive(int col, ArrayList<Integer> domain) {
        numberOfRecur++;
        if (col >= N) {
            //print();
            numberOfSolutions++;
        } else {
            if (!domain.isEmpty()) {
                for (int i = 0; i < domain.size(); i++) {
                    board[domain.get(i)][col] = true; //wstawia hetmana
                    columnControl[domain.get(i)] = true; //zajmuje kolumnę
                    rowControl[col] = true; //zajmuje wiersz

                    ArrayList<Integer> newDomain = getDomain(col + 1);
                    if (!newDomain.isEmpty()) {
                        goRecoursive(col + 1, newDomain);
                    }

                    columnControl[domain.get(i)] = false;
                    rowControl[col] = false;
                    board[domain.get(i)][col] = false;
                }
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




