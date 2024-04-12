package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    private final List<AppThread> threads = new ArrayList<>();
    private final List<Step> steps;

    public App(int threads, List<Step> steps) {
        this.steps = steps;
        for (int i=0;i<threads;i++) {
            this.threads.add(new AppThread());
        }
    }

    public void ingest(Message message) {
        for (Step step : steps) {
            AppThread thread = getAvailableThread();
            thread.process(message, step);
        }
    }

    private AppThread getAvailableThread() {
        long minUsed = Long.MAX_VALUE;
        AppThread minThread = null;

        for (AppThread thread: threads) {
            if (thread.used <= minUsed) {
                minUsed = thread.used;
                minThread = thread;
            }
        }

        return minThread;
    }

    public GlobalStats getStats() {
        return new GlobalStats(threads);
    }
}
