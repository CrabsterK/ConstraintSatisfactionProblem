package com.si;

public class Main {
    public static void main(String[] args) {
        int n = 7;
        int n2 = 4;

        System.out.println("============================== N QUEENS ==============================");
        System.out.println("                             BACKTRACKING                             ");


        HetmanBacktracking bt = new HetmanBacktracking(n);
        long startTimeBt = System.currentTimeMillis();
        bt.go();
        double estimatedTimeBt = System.currentTimeMillis() - startTimeBt;
        System.out.println("n = " + n + "\tLiczba rozwiązań: " + bt.getNumberOfSolutions() + "\tWywołań rekursywnych: " + bt.getNumberOfRecur() + "\tCzas: " + estimatedTimeBt + "ms\n");

        System.out.println("                           FORWARD CHECKING                             ");
        HetmanForwardChecking fc = new HetmanForwardChecking(n);
        long startTimeFc = System.currentTimeMillis();
        fc.go();
        double estimatedTimeFc = System.currentTimeMillis() - startTimeFc;
        System.out.println("n = " + n + "\tLiczba rozwiązań: " + fc.getNumberOfSolutions() + "\tWywołań rekursywnych: " + fc.getNumberOfRecur() + "\tCzas: " + estimatedTimeFc + "ms\n");







        System.out.println("\n\n================================ LATIN ===============================");
        System.out.println("                             BACKTRACKING                             ");

        LatinBacktracking lbt = new LatinBacktracking(n2);
        long startTimeLbt = System.currentTimeMillis();
        lbt.go();
        double estimatedTimeLbt = System.currentTimeMillis() - startTimeLbt;
        System.out.println("n = " + n2 + "\tLiczba rozwiązań: " + lbt.getNumberOfSolutions() + "\tWywołań rekursywnych: " + lbt.getNumberOfRecur() + "\tCzas: " + estimatedTimeLbt + "ms\n");

        System.out.println("                           FORWARD CHECKING                             ");
        LatinForwardChecking lfc = new LatinForwardChecking(n2);
        long startTimeLfc = System.currentTimeMillis();
        lfc.go();
        double estimatedTimeLfc = System.currentTimeMillis() - startTimeLfc;
        System.out.println("n = " + n2 + "\tLiczba rozwiązań: " + lfc.getNumberOfSolutions() + "\tWywołań rekursywnych: " + lfc.getNumberOfRecur() + "\tCzas: " + estimatedTimeLfc + "ms\n");
    }
}
