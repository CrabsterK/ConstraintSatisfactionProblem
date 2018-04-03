package com.si;

public class Main {
    public static void main(String[] args) {

        int n = 8;
        HetmanBacktracking bt = new HetmanBacktracking(n);

        long startTime = System.nanoTime();
        bt.go();
        double estimatedTime = System.nanoTime() - startTime;

        System.out.println("n = " + n + "\tLiczba rozwiązań: " + bt.getNumberOfSolutions() + "\tWywołań rekursywnych: " + bt.getNumberOfRecur() + "\tNawrotów: " + bt.getNumberOfReturns() + "\tCzas: " + estimatedTime/1000000 +"ms");

    }
}
