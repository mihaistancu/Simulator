package org.example;

public class GlobalStatsPrinter {

    public static void  print(GlobalStats stats, int start, int end) {
        System.out.println(stats.messages(start, end).size());
    }
}
