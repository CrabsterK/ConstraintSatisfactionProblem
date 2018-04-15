package com.si;

public class Main {
    public static void main(String[] args) {
        int n = 14;

        HetmanBacktracking bt = new HetmanBacktracking(n);
        long startTimeBt = System.currentTimeMillis();
        bt.go();
        double estimatedTimeBt = System.currentTimeMillis() - startTimeBt;
        System.out.println("n = " + n + "\tLiczba rozwiązań: " + bt.getNumberOfSolutions() + "\tWywołań rekursywnych: " + bt.getNumberOfRecur() + "\tCzas: " + estimatedTimeBt +"ms");


        HetmanForwardChecking fc = new HetmanForwardChecking(n);
        long startTimeFc = System.currentTimeMillis();
        fc.go();
        double estimatedTimeFc = System.currentTimeMillis() - startTimeFc;
        System.out.println("n = " + n + "\tLiczba rozwiązań: " + fc.getNumberOfSolutions() + "\tWywołań rekursywnych: " + fc.getNumberOfRecur() + "\tCzas: " + estimatedTimeFc +"ms");
    }
}
