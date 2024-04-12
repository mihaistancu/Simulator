package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GlobalStats {
    public List<ThreadStats> stats;

    public GlobalStats(List<AppThread> threads) {
        stats = new ArrayList<>();

        for (AppThread thread : threads) {
            stats.add(new ThreadStats(thread));
        }
    }

    public Set<Message> messages(long start, long end) {
        Set<Message> messages = new HashSet<>();

        for (ThreadStats s : stats) {
            Set<Message> extra = s.messagesProcessed(start, end);
            messages.addAll(extra);
        }

        return messages;
    }
}
