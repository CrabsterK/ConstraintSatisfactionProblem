package com.si;

import java.util.*;

public class LatinBacktracking {
    private final int DEFAULT_VALUE = 0;
    private final int N;
    private int numberOfRecur;
    private int numberOfSolutions;
    private int numberOfReturns;
    private ArrayList board;

    public LatinBacktracking(int n) {
        this.N = n;
        this.numberOfRecur = 0;
        this.numberOfSolutions = 0;
        this.numberOfReturns = 0;
        this.board = initialiseEmptyBoard();
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

    private ArrayList initialiseEmptyBoard() {
        ArrayList board = new ArrayList(N*N);
        for(int i = 0; i < N*N; i++){
            board.add(DEFAULT_VALUE);
        }
        return board;
    }

    private boolean isSafe(List<Integer> board) {//same zera, unikalny wiersz, unikalna kolumna
        HashSet<Integer> values = new HashSet<>(board);
        if (values.size() == 1 && values.contains(0)) { //są same '0'
            return true;
        }
        boolean isOk = true;
        for (int i = 0; i < N && isOk; i++) {
            List<Integer> tmpRow = board.subList(i * N, N * (i + 1));
            if (!uniqueArrayValuesNoDefault(tmpRow)) {
                isOk = false;
            }
            List<Integer> tmpCol = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                tmpCol.add(board.get(i + N * j));
            }
            if (!uniqueArrayValuesNoDefault(tmpCol)) {
                isOk = false;
            }
        }
        return isOk;
    }

    private boolean uniqueArrayValuesNoDefault(List list) {//valid wiersz lub kolumna
        ArrayList parsedlist = new ArrayList();
        for(int i = 0; i < N; i++) {
            if(!list.get(i).equals(DEFAULT_VALUE)) {
                parsedlist.add(list.get(i));
            }
        }
        return new HashSet<>(parsedlist).size() == parsedlist.size();
    }

    public void go() {
        goRecoursive(board);
    }

    private void goRecoursive(ArrayList board) {
        numberOfRecur++;
        if (isSafe(board)) {
            if (!board.contains(0)) {
                numberOfSolutions++;
            }
            else {
                for( int i = 1; i <= N; i++){
                    ArrayList newSolution = putNextVal(board, i);
                    goRecoursive(newSolution);//rekurencja
                }
            }
        }
        else {
            numberOfReturns++;
        }
    }

    private ArrayList putNextVal(ArrayList board, int i) {//na pierwsze napotkane 0 wstawia nextVal i zwraca taką listę
        int index = board.indexOf(0);
        ArrayList newBoard = new ArrayList<>(board);
        newBoard.set(index, i);
        return newBoard;
    }
}
