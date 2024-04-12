package org.example;

import java.util.List;

import static org.example.GlobalStatsPrinter.print;

public class Main {
    public static void main(String[] args) {
        var app = new App(1, List.of(new Step(), new Step()));

        for (int i=0; i<100; i++) {
            app.ingest(new Message(1));
        }

        print(app.getStats(), 0, 50);
    }
}