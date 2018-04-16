package com.si;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int n = 13;
        int n2 = 3;
       // final int EXPERIMENT_COUNTER = 10;
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
       // for(int n2 = 1; n2 < 7; n2++) {
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
      //  }
    }

    public static double getMedian(ArrayList set) {
        Collections.sort(set);
        int middle = set.size() / 2;
        middle = middle % 2 == 0? middle - 1 : middle;
        return (double) set.get(middle);
    }
}
